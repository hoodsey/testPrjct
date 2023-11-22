package general_cases_for_tests


import GlobalVariable.platformType
import TypeOS
import screens.MainPage
import screens.Onboarding

object OnboardingScenarios {
    fun onboardingTest() {
        // инициализация классов
        val onboarding = Onboarding()
        val mainPage = MainPage()
        // обработка ошибки запуска приложения не с нуля
        try {
            // выбрать русский язык и перейти дальше
            onboarding.clickRusButton(findElementWithOutCatching = true)
            onboarding.clickNextButton(findElementWithOutCatching = true)
            // условие для обработки системных окон на IOS
            when (platformType) {
                TypeOS.IOS -> {
                    onboarding.notificationScipButton(findElementWithOutCatching = true)
                    try {
                        mainPage.clickSystemAboutMonitoring(findElementWithOutCatching = true)
                    } catch (e: org.openqa.selenium.NoSuchElementException) {
                        e.printStackTrace() //Распечатываем ошибку в консоль
                        println("Мы поймали ошибку, и теперь тест не упадет")
                    }
                }

                else -> {}
            }
            //закрыть окно с выбором типа заказа
            mainPage.clickRollUpElement(findElementWithOutCatching = true)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace() //Распечатываем ошибку в консоль
            println("Мы поймали ошибку, и теперь тест не упадет")

        }

    }
}