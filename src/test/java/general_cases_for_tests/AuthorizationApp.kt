package general_cases_for_tests

import LocatorType
import TestFunctions.clickToElement
import TestFunctions.getAttribute
import TestFunctions.sendText
import screens.Authorization
import screens.Authorization.codeButton
import screens.Authorization.selectCodeInsert
import screens.Authorization.selectTelephone
import screens.Profile.authorizationButton

object AuthorizationApp {
    fun  authorizationApp(telephone: String){
        clickToElement(authorizationButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        sendText(selectTelephone.androidXPath, LocatorType.XPATH,telephone)
        clickToElement(codeButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        val fullXPath = getAttribute(Authorization.selectCodeAuthorization.androidXPath, LocatorType.XPATH, "content-desc").substringAfterLast("смс\n")

        sendText(selectCodeInsert.className, LocatorType.CLASS_NAME,fullXPath)
    }
}