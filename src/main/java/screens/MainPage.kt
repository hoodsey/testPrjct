package screens

object MainPage {
    val rollUpElement = ScreenConstructor(
            androidAccessibilityId = "Закрыть",
            elementName = "Свернуть окно с выбором типа заказа"
    )
    val SoupCategory = ScreenConstructor(
            androidAccessibilityId = "Супы",
            elementName = "Кнопка перехода к разделу Супы"
    )
    val addBorsch = ScreenConstructor(
            androidAccessibilityId = "195 ₽",
            elementName = "Кнопка добавления борща в заказ"
    )
    val goOverCart = ScreenConstructor(
            androidAccessibilityId = "1\n" +
                    "Корзина\n" +
                    "195 ₽",
            elementName = "Кнопка перехода в корзину с главного экрана"
    )

}