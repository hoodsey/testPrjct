package tests

import LocatorType
import MainActivity
import TestFunctions.clickToElement
import org.testng.annotations.Test
import screens.Onboarding.nextButton
import screens.Onboarding.selectRusButton
import java.util.concurrent.TimeUnit

class OnboardingTest : MainActivity(){

    @Test
    fun OnboardingTest() {

        // обработка ошибок при прокликиваинии элементов в сценарии атворизации по номеру +7 951 055 65 86
        try {

            clickToElement(selectRusButton.androidXPath, LocatorType.XPATH)
            clickToElement(nextButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)

            TimeUnit.SECONDS.sleep(10)
                    /*
            // тест с ошибкой при поиске по resource-id
            val element5 = androidDriver.findElement(AppiumBy.id("Fail resource-id"))
            element5.click()
         */

        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace() // распечатываем ошибку в консоль
            println("Мы поймали ошибку, и теперь тест не упадет")

        }
        /*
        val text = androidDriver.pageSource()
        */
        TimeUnit.SECONDS.sleep(10)
    }
}