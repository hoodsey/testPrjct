package screens

object Onboarding {

    val selectRusButton = ScreenConstructor(
            androidXPath = "//android.view.View[@content-desc=\"Русский\"]",
            iosAccessibilityId = "Русский",
            elementName = "Выбор русского языка на экране онбординга"
    )
    val nextButton = ScreenConstructor(
            androidAccessibilityId = "Далее",
            iosAccessibilityId = "Далее",
            elementName = "Кнопка Далее для переходд с мейнскрину к мэйнскрину"
    )
    val notificationScipButton = ScreenConstructor(
            iosAccessibilityId = "Далее",
            elementName = "Кнопка Далее для переходд с мейнскрину к мэйнскрину"
    )
}
