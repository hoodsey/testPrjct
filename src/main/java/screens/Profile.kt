package screens

import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement

class Profile {


    fun checkQuitButton(findElementWithOutCatching: Boolean = false): Boolean {
        return checkAvailableElement(
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorAndroid = quietButton.androidAccessibilityId,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = quietButton.iosAccessibilityId,
                elementName = quietButton.elementName,
                findElementWithOutCatching = findElementWithOutCatching
        )
    }

    fun clickAuthorizationButton() {
        clickToElement(
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorAndroid = authorizationButton.androidAccessibilityId,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = authorizationButton.iosAccessibilityId,
                elementName = authorizationButton.elementName
        )
    }

    fun clickQuietButton() {
        clickToElement(
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorAndroid = quietButton.androidAccessibilityId,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = quietButton.iosAccessibilityId,
                elementName = quietButton.elementName
        )
    }

    fun clickToAddressButton() {
        clickToElement(
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorAndroid = addressButton.androidAccessibilityId,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = addressButton.iosAccessibilityId,
                elementName = addressButton.elementName
        )
    }

    private val authorizationButton = ScreenConstructor(
            androidAccessibilityId = "Войти",
            iosAccessibilityId = "Войти",
            elementName = "Кнопка перехода к авторизации из вкладки профиля"
    )
    private val quietButton = ScreenConstructor(
            androidAccessibilityId = "Выйти",
            iosAccessibilityId = "Выйти",
            elementName = "Кнопка выхода из профиля"
    )
    private val addressButton = ScreenConstructor(
            androidAccessibilityId = "Мои адреса",
            iosAccessibilityId = "Мои адреса",
            elementName = "Кнопка перехода к окну Мои адреса"
    )

}