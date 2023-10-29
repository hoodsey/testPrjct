package tests

import LocatorType
import MainActivity
import TestFunctions.clickToElement
import TestFunctions.swipeOnScreen
import general_cases_for_tests.AuthorizationScenarios
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import screens.MenuApps.selectCatalogButton
import screens.MenuApps.selectMenuButton
import screens.MenuApps.selectProfileButton
import screens.Profile.authorizationButton

class MainPageTest : MainActivity() {

    @Test
    fun mainPageTest() {

        checkAuthorizationUser(false)


        clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)
        swipeOnScreen(457, 2074, 450, 375)

        clickToElement(selectMenuButton.androidXPath, LocatorType.XPATH)
        clickToElement(selectProfileButton.androidXPath, LocatorType.XPATH)
        clickToElement(authorizationButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        AuthorizationScenarios.authorizationApp("9510556586")

        clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)

    }
}