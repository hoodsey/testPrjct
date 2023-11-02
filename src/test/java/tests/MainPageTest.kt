package tests

import LocatorType
import MainActivity
import TestFunctions.clickToElement
import general_cases_for_tests.AuthorizationScenarios
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import screens.MenuApps.selectCatalogButton
import screens.MenuApps.selectMenuButton
import screens.MenuApps.selectProfileButton
import screens.Profile.authorizationButton
import java.util.concurrent.TimeUnit

class MainPageTest : MainActivity() {

    @Test
    fun mainPageTest() {

        checkAuthorizationUser(false)


        clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH, selectCatalogButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN)
        //swipeOnScreen(457, 2074, 450, 375)


        clickToElement(selectMenuButton.androidXPath, LocatorType.XPATH, selectMenuButton.iosClassChain,LocatorType.IOS_CLASS_CHAIN )
        clickToElement(selectProfileButton.androidXPath, LocatorType.XPATH, selectProfileButton.iosClassChain,LocatorType.IOS_CLASS_CHAIN )
        clickToElement(authorizationButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, authorizationButton.iosAccessibilityId,LocatorType.ACCESSIBILITY_ID )
        AuthorizationScenarios.authorizationApp("9510556586")
        TimeUnit.SECONDS.sleep(2)
        clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH, selectCatalogButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN)

    }
}