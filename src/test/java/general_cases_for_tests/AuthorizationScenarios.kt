package general_cases_for_tests

import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement
import general_cases_for_tests.AuthorizationApp.authorizationApp
import screens.MenuApps.selectCatalogButton
import screens.MenuApps.selectProfileButton
import screens.Profile.quietButton


object AuthorizationScenarios {

    fun checkAuthorizationUser(needAuthorizationUser: Boolean) {

        clickToElement(selectProfileButton.androidXPath, LocatorType.XPATH)

        var userIsAuthorization: Boolean
        try {
            userIsAuthorization = checkAvailableElement(quietButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false
        }
        when {
            // нужна авторизация и есть кнопка выйти в профиле(авторизован)
            needAuthorizationUser && userIsAuthorization -> {clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)}
            //нужна авторизация и кнопке выйти нет(неавторизован)  -> авторизация + переход к каталогу
            needAuthorizationUser && !userIsAuthorization -> {
                authorizationApp( "9510556586")
                clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)
            }
            //не нужна авторизация, но есть кнопка выйти в профиле(авторизован) -> клик по кнопке выйти
            !needAuthorizationUser && userIsAuthorization -> {
                clickToElement(quietButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
                clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)
            }
            //не нужна авторизация и не авторизован
            !needAuthorizationUser && !userIsAuthorization ->{clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)}
        }
    }
}