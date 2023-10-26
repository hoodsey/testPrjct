package general_cases_for_tests

import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement
import TestFunctions.getAttribute
import TestFunctions.sendText
import screens.Authorization
import screens.MenuApps.selectCatalogButton
import screens.MenuApps.selectProfileButton
import screens.Profile
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
            needAuthorizationUser && userIsAuthorization -> {
                clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)
            }
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
            !needAuthorizationUser && !userIsAuthorization ->{
                clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)
            }
        }
    }
    fun  authorizationApp(telephone: String){
        clickToElement(Profile.authorizationButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        sendText(Authorization.selectTelephone.androidXPath, LocatorType.XPATH,telephone)
        clickToElement(Authorization.codeButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        val fullXPath = getAttribute(Authorization.selectCodeAuthorization.androidXPath, LocatorType.XPATH, "content-desc").substringAfterLast("смс\n")

        sendText(Authorization.selectCodeInsert.className, LocatorType.CLASS_NAME,fullXPath)
    }
}