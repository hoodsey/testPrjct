package screens

object Profile {
    val authorizationButton = ScreenConstructor(
            androidAccessibilityId = "Войти",
            elementName = "Кнопка перехода к авторизации из вкладки профиля"
    )
    val quietButton = ScreenConstructor(
            androidAccessibilityId = "Выйти",
            elementName = "Кнопка выхода из профиля"
    )
    val addressButton = ScreenConstructor(
            androidAccessibilityId = "Мои адреса",
            elementName = "Кнопка выхода из профиля"
    )
}