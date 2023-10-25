package screens

object Authorization {
    val selectTelephone = ScreenConstructor(
            androidXPath = "//android.view.View[@content-desc=\"Укажите телефон\n" +
                    "На него отправим код подтверждения\"]/android.widget.EditText",
            elementName = "Элемент в окне авторизации для ввода телефона"
    )
    val codeButton = ScreenConstructor(
            androidAccessibilityId = "Получить код",
            elementName = "Кнопка Далее для отображения на странице кода авторизации"
    )
    val selectCodeAuthorization = ScreenConstructor(
            androidXPath = "//*[starts-with(@content-desc,'Введите код из смс')]",
            elementName = "Элемент в окне авторизации c выводом кода авторизации"
    )
    val selectCodeInsert = ScreenConstructor(
            className = "android.widget.EditText",
            elementName = "Элемент в окне авторизации для кода авторизации"
    )

}