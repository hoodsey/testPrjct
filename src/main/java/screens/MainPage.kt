package screens

object MainPage {
    val rollUpElement = ScreenConstructor(
            androidAccessibilityId = "Закрыть",
            iosAccessibilityId = "Закрыть",
            elementName = "Свернуть окно с выбором типа заказа"
    )
    val systemAboutMonitoring = ScreenConstructor(
            iosClassChain = "**/XCUIElementTypeOther[`label == \"Горизонтальная полоса прокрутки, 1 страница\"`][2]",
            elementName = "Свернуть окно с выбором типа заказа"
    )
    val SoupCategory = ScreenConstructor(
            androidAccessibilityId = "Супы",
            iosAccessibilityId  = "Супы",
            elementName = "Кнопка перехода к разделу Супы"
    )
    val addBorsch = ScreenConstructor(
            androidAccessibilityId = "195 ₽",
            iosAccessibilityId = "195 ₽",
            elementName = "Кнопка добавления борща в заказ"
    )
    val goOverCart = ScreenConstructor(
            androidAccessibilityId = "1\n" +
                    "Корзина\n" +
                    "195 ₽",
            iosAccessibilityId = "1\n" +
                    "Корзина\n" +
                    "195 ₽",
            elementName = "Кнопка перехода в корзину с главного экрана"
    )

}