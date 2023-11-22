package screens

import LocatorType
import TestFunctions.clickToElement

class Location {
    fun clickToUsingLocation(findElementWithOutCatching: Boolean = false) {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = usingLocation.androidXPath,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = usingLocation.iosAccessibilityId,
                elementName = usingLocation.elementName,
                findElementWithOutCatching = findElementWithOutCatching
        )
    }

    private val usingLocation = ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]",
            iosAccessibilityId = "При использовании",
            elementName = "Кнопка разрешить использовать геолокацию"
    )
}