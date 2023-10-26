package general_cases_for_tests

import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement
import screens.MenuApps.selectCatalogButton
import screens.MenuApps.selectProfileButton


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

            userIsAuthorization = checkAvailableElement("//android.view.View[@content-desc=\"Войти\"]", LocatorType.XPATH)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false
        }
        when {
            needAuthorizationUser && userIsAuthorization -> {clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)}
            needAuthorizationUser && !userIsAuthorization -> {}
            !needAuthorizationUser && userIsAuthorization -> {}
            !needAuthorizationUser && !userIsAuthorization -> {}
        }
    }
}