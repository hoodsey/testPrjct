package general_cases_for_tests

import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement
import screens.MenuApps.selectCatalogButton
import screens.MenuApps.selectProfileButton
import screens.Profile.quietButton


object AuthorizationScenarios {

    fun checkAuthorizationUser(needAuthorizationUser: Boolean) {
        /* тут должна быть логика проверки авторизации пользователя
        на входе одна и нужных булевых переменных, вторую нужно получить путем
        проверки доступности элемента

         */
        clickToElement(selectProfileButton.androidXPath, LocatorType.XPATH)
        // нужно описать 4 ветки
        var userIsAuthorization: Boolean
        try {
            // нам нужно получить true, что это сделать, нужно найти элемент, если он не будет
            // найден, то должна обработаться ошибка и установить значение false

            userIsAuthorization = checkAvailableElement(quietButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false
        }
        when {
            // нужна авторизация и есть кнопка выйти в профиле(авторизован)
            needAuthorizationUser && userIsAuthorization -> {clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)}
            //нужна авторизация и кнопке выйти нет(неавторизован)  -> переход к каталогу
            needAuthorizationUser && !userIsAuthorization -> {
                clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)}
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