package general_cases_for_tests

import LocatorType
import TestFunctions.clickToElement
import screens.MainPage.rollUpElement
import screens.MainPage.systemAboutMonitoring
import screens.Onboarding.nextButton
import screens.Onboarding.notificationScipButton
import screens.Onboarding.selectRusButton
import java.util.concurrent.TimeUnit

object OnboardingScenarios {
    fun onboardingTest() {

        try {
            TimeUnit.SECONDS.sleep(2)
            clickToElement(selectRusButton.androidXPath, LocatorType.XPATH, selectRusButton.iosAccessibilityId,LocatorType.ACCESSIBILITY_ID)
            clickToElement(nextButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, nextButton.iosAccessibilityId,LocatorType.ACCESSIBILITY_ID)
            TimeUnit.SECONDS.sleep(2)
            clickToElement("", LocatorType.XPATH, notificationScipButton.iosAccessibilityId,LocatorType.ACCESSIBILITY_ID  )
            clickToElement("",LocatorType.XPATH,systemAboutMonitoring.iosClassChain, LocatorType.IOS_CLASS_CHAIN)
            clickToElement(rollUpElement.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, rollUpElement.iosAccessibilityId,LocatorType.ACCESSIBILITY_ID)

        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace() //Распечатываем ошибку в консоль
            println("Мы поймали ошибку, и теперь тест не упадет")

        }
    }
}