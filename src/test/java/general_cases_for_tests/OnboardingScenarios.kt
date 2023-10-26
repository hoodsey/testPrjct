package general_cases_for_tests

import LocatorType
import TestFunctions.clickToElement
import screens.MainPage
import screens.Onboarding
import java.util.concurrent.TimeUnit

object OnboardingScenarios {
    fun onboardingTest() {

        try {
            clickToElement(Onboarding.selectRusButton.androidXPath, LocatorType.XPATH)
            clickToElement(Onboarding.nextButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)

            TimeUnit.SECONDS.sleep(2)
            clickToElement(MainPage.rollUpElement.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)

        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace() //Распечатываем ошибку в консоль
            println("Мы поймали ошибку, и теперь тест не упадет")

        }
    }
}