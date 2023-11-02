package screens

object Profile {
    val authorizationButton = ScreenConstructor(
            androidAccessibilityId = "Войти",
            iosAccessibilityId = "Войти",
            elementName = "Кнопка перехода к авторизации из вкладки профиля"
    )
    val quietButton = ScreenConstructor(
            androidAccessibilityId = "Выйти",
            iosAccessibilityId = "Выйти",
            elementName = "Кнопка выхода из профиля"
    )
    val addressButton = ScreenConstructor(
            androidAccessibilityId = "Мои адреса",
            iosAccessibilityId = "Мои адреса",
            elementName = "Кнопка выхода из профиля"
    )
}