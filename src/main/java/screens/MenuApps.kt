package screens

import LocatorType
import TestFunctions.clickToElement

class MenuApps {

    fun selectCatalogButton() {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]",
                locatorTypeIOS = LocatorType.IOS_CLASS_CHAIN,
                locatorIOS = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[2]",
                elementName = "Переход по кнопке на вкладку выбора блюд"
        )
    }

    fun selectMenuButton() {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]",
                locatorTypeIOS = LocatorType.IOS_CLASS_CHAIN,
                locatorIOS = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[3]",
                elementName = "Переход по кнопке на вкладку меню"
        )
    }

    fun selectProfileButton() {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]",
                locatorTypeIOS = LocatorType.IOS_CLASS_CHAIN,
                locatorIOS = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[1]",
                elementName = "Переход по кнопке в профиль"
        )
    }

}