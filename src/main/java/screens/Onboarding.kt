package screens

import LocatorType
import TestFunctions.clickToElement

public class Onboarding {

    public fun clickRusButton() {
        clickToElement(
                locatorAndroid = locatorMap[OnboardingElements.SELECT_BUTTON_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[OnboardingElements.SELECT_BUTTON_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[OnboardingElements.SELECT_BUTTON_RUS_ELEMENT_NAME].toString(),
        )
    }

    public fun clickNextButton() {
        clickToElement(
                locatorAndroid = locatorMap[OnboardingElements.NEXT_BUTTON_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[OnboardingElements.NEXT_BUTTON_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[OnboardingElements.NEXT_BUTTON_ELEMENT_NAME].toString(),
        )
    }

    public fun notificationScipButton() {
        clickToElement(
                locatorAndroid = locatorMap[OnboardingElements.NOTIFICATION_BUTTON__ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[OnboardingElements.NOTIFICATION_BUTTON_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[OnboardingElements.NOTIFICATION_BUTTON_ELEMENT_NAME].toString(),
        )
    }

    private enum class OnboardingElements {
        NEXT_BUTTON_ANDROID,
        NEXT_BUTTON_IOS,
        NEXT_BUTTON_ELEMENT_NAME,

        SELECT_BUTTON_ANDROID,
        SELECT_BUTTON_IOS,
        SELECT_BUTTON_RUS_ELEMENT_NAME,

        NOTIFICATION_BUTTON__ANDROID,
        NOTIFICATION_BUTTON_IOS,
        NOTIFICATION_BUTTON_ELEMENT_NAME,
    }

    private val locatorMap: LinkedHashMap<OnboardingElements, String> = linkedMapOf(
            OnboardingElements.NEXT_BUTTON_ANDROID to "Далее",
            OnboardingElements.NEXT_BUTTON_IOS to "Далее",
            OnboardingElements.NEXT_BUTTON_ELEMENT_NAME to "Выбор русского языка на экране онбординга",

            OnboardingElements.SELECT_BUTTON_ANDROID to "Русский",
            OnboardingElements.SELECT_BUTTON_IOS to "Русский",
            OnboardingElements.SELECT_BUTTON_RUS_ELEMENT_NAME to "Нажать кнопку далее и перейти к главному экрану",

            OnboardingElements.NOTIFICATION_BUTTON__ANDROID to "",
            OnboardingElements.NOTIFICATION_BUTTON_IOS to "Далее",
            OnboardingElements.NOTIFICATION_BUTTON_ELEMENT_NAME to "Нажать на кнопку далее в системном окне IOS",
    )
}
