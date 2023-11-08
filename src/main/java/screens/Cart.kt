package screens

import LocatorType
import TestFunctions.clickToElement
import TestFunctions.findCoordinates
import TestFunctions.findSizeElement
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point

class Cart {
    fun findSizePreOrderInfo(): Dimension {
        return findSizeElement(
                locatorAndroid = preOrderInfo.androidAccessibilityId,
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = preOrderInfo.iosAccessibilityId,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName =  preOrderInfo.elementName,
        )

    }
    fun findCoordinatePreOrderInfo(): Point {
        return findCoordinates(
                locatorAndroid = preOrderInfo.androidAccessibilityId,
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = preOrderInfo.iosAccessibilityId,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = preOrderInfo.elementName,
        )

    }
    public fun cleanCart() {
        clickToElement(
                locatorAndroid = cleanCart.androidAccessibilityId,
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = cleanCart.iosAccessibilityId,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = cleanCart.elementName,
        )
        clickToElement(
                locatorAndroid = approvalCleanCart.androidAccessibilityId,
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = approvalCleanCart.iosAccessibilityId,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = approvalCleanCart.elementName,
        )
    }

    private val preOrderInfo = ScreenConstructor(
            androidAccessibilityId = "Заказ на сумму\n" +
                    "195 ₽\n" +
                    "Доставка\n" +
                    "Бесплатно",
            iosAccessibilityId = "Заказ на сумму\n" +
                    "195 ₽\n" +
                    "Доставка\n" +
                    "Бесплатно",
            elementName = "Элемент с информацией о заказе"
    )
    private val cleanCart = ScreenConstructor(
            androidAccessibilityId = "Очистить",
            iosAccessibilityId = "Очистить",
            elementName = "Кнопка очистить корзину"
    )
    private val approvalCleanCart = ScreenConstructor(
            androidAccessibilityId = "Да, очистить",
            iosAccessibilityId = "Да, очистить",
            elementName = "Кнопка подтвердить очистку корзину"
    )
}