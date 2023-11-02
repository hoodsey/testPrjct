package general_cases_for_tests

import GlobalVariable.platformType
import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement
import TestFunctions.getAttribute
import TestFunctions.sendText
import TypeOS
import screens.Authorization.codeButton
import screens.Authorization.selectCodeAuthorization
import screens.Authorization.selectCodeInsert
import screens.Authorization.selectTelephone
import screens.MenuApps.selectCatalogButton
import screens.MenuApps.selectProfileButton
import screens.Profile.authorizationButton
import screens.Profile.quietButton


object AuthorizationScenarios {

    fun checkAuthorizationUser(needAuthorizationUser: Boolean) {

        clickToElement(selectProfileButton.androidXPath, LocatorType.XPATH, selectProfileButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN)

        var userIsAuthorization: Boolean

        try {
            userIsAuthorization = checkAvailableElement(quietButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, quietButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false
        }
        when {
            // нужна авторизация и есть кнопка выйти в профиле(авторизован)
            needAuthorizationUser && userIsAuthorization -> {
                clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH, selectCatalogButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN)
            }
            //нужна авторизация и кнопке выйти нет(неавторизован)  -> авторизация + переход к каталогу
            needAuthorizationUser && !userIsAuthorization -> {
                clickToElement(authorizationButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, authorizationButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
                authorizationApp("9510556586")
                clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH, selectCatalogButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN)
            }
            //не нужна авторизация, но есть кнопка выйти в профиле(авторизован) -> клик по кнопке выйти
            !needAuthorizationUser && userIsAuthorization -> {
                clickToElement(quietButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, quietButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
                clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH, selectCatalogButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN)
            }
            //не нужна авторизация и не авторизован
            !needAuthorizationUser && !userIsAuthorization -> {
                clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH, selectCatalogButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN)
            }
        }
    }

    fun authorizationApp(phone: String) {
        sendText(selectTelephone.androidXPath, LocatorType.XPATH, selectTelephone.iosXPath, LocatorType.XPATH, phone)
        clickToElement(codeButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, codeButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        var fullXPath = "";
        when (platformType) {
            TypeOS.IOS -> {
                fullXPath = getAttribute(selectCodeAuthorization.androidXPath, LocatorType.XPATH, selectCodeAuthorization.iosXPath, LocatorType.XPATH, "name").substringBefore("\n+7").substringAfterLast("смс\n")
            }
            TypeOS.ANDROID -> {
                fullXPath = getAttribute(selectCodeAuthorization.androidXPath, LocatorType.XPATH, selectCodeAuthorization.iosXPath, LocatorType.XPATH, "content-desc").substringBefore("\n+7").substringAfterLast("смс\n")
            }
        }
        sendText(selectCodeInsert.className, LocatorType.CLASS_NAME, selectCodeInsert.iosClassChain, LocatorType.IOS_CLASS_CHAIN, fullXPath)

    }
}