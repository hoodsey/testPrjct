package tests

import LocatorType
import MainActivity
import TestFunctions.clickToElement
import TestFunctions.getAttribute
import TestFunctions.sendText
import TestFunctions.swipeOnScreen
import org.testng.annotations.Test
import screens.Authorization.codeButton
import screens.Authorization.selectCodeAuthorization
import screens.Authorization.selectCodeInsert
import screens.Authorization.selectTelephone
import screens.MainPage.rollUpElement
import screens.MenuApps
import screens.MenuApps.selectMenuButton
import screens.MenuApps.selectProfileButton
import screens.Onboarding.nextButton
import screens.Onboarding.selectRusButton
import screens.Profile.authorizationButton
import java.util.concurrent.TimeUnit


class MainPageTest : MainActivity() {


    @Test
    fun MainPageTest() {

        clickToElement(selectRusButton.androidXPath, LocatorType.XPATH)
        clickToElement(nextButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)

        TimeUnit.SECONDS.sleep(10)

        clickToElement(rollUpElement.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        swipeOnScreen(457, 2074, 450, 375)

        clickToElement(selectMenuButton.androidXPath, LocatorType.XPATH)
        clickToElement(selectProfileButton.androidXPath, LocatorType.XPATH)

        //checkAuthorizationUser(false)

        clickToElement(authorizationButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)

        sendText(selectTelephone.androidXPath, LocatorType.XPATH,"9510556586")
        clickToElement(codeButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(5)

        val fullXPath = getAttribute(selectCodeAuthorization.androidXPath, LocatorType.XPATH, "content-desc").substringAfterLast("смс\n")

        sendText(selectCodeInsert.className, LocatorType.CLASS_NAME,fullXPath)
        TimeUnit.SECONDS.sleep(10)

        //checkAuthorizationUser(true)

        clickToElement(MenuApps.selectCatalogButton.androidXPath, LocatorType.XPATH)

    }
}