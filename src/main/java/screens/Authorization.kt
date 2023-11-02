package screens

object Authorization {
    val selectTelephone = ScreenConstructor(
            androidXPath = "//android.view.View[@content-desc=\"Укажите телефон\n" +
                    "На него отправим код подтверждения\"]/android.widget.EditText",
            iosXPath = "//XCUIElementTypeApplication[@name=\"School\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField",
            elementName = "Элемент в окне авторизации для ввода телефона"
    )
    val codeButton = ScreenConstructor(
            androidAccessibilityId = "Получить код",
            iosAccessibilityId = "Получить код",
            elementName = "Кнопка Далее для отображения на странице кода авторизации"
    )
    val selectCodeAuthorization = ScreenConstructor(
            androidXPath = "//*[starts-with(@content-desc,'Введите код из смс')]",
            iosXPath = "//*[starts-with(@name,'Введите код из смс')]",
            elementName = "Элемент в окне авторизации c выводом кода авторизации"
    )
    val selectCodeInsert = ScreenConstructor(
            className = "android.widget.EditText",
            iosClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField",
            elementName = "Элемент в окне авторизации для кода авторизации"
    )

}