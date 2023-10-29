package screens

object Cart {
    val preOrderInfo = ScreenConstructor(
            androidAccessibilityId = "Заказ на сумму\n" +
                    "195 ₽\n" +
                    "Доставка\n" +
                    "Бесплатно",
            elementName = "Элемент с информацией о заказе"
    )
    val cleanCart = ScreenConstructor(
            androidAccessibilityId = "Очистить",
            elementName = "Элемент с информацией о заказе"
    )
    val approvalCleanCart = ScreenConstructor(
            androidAccessibilityId = "Да, очистить",
            elementName = "Элемент с информацией о заказе"
    )
}