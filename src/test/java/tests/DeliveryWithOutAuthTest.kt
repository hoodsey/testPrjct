package tests

import MainActivity
import org.testng.annotations.Test

class DeliveryWithOutAuthTest : MainActivity() {

    @Test
    fun deliveryWithOutAuthTest() {
/*
        checkAuthorizationUser(false)

        clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH,, )

        /* runCatching {
            checkAvailableElement(goOverCart.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        }.onSuccess {
            clickToElement(goOverCart.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        }*/
        //выбор блюда
        clickToElement(SoupCategory.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,, )
        clickToElement(addBorsch.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,, )

        //разрешение на геопозицию и ввод адреса, если нет ни одного адреса в приложении.
        useLocation()
        runCatching {
        fillingAddress("Виленский переулок, 6, Санкт-Петербург","6","6","6","6","6")
        }.onFailure {
            println("Error: ${it.message}")
        }
        // переход в коризну
        clickToElement(goOverCart.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,, )
        // размер и координаты элемента с информацией о заказе
        val preOrderInfoSize: Dimension = findSizeElement(preOrderInfo.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        val preOrderInfoCoordinate: Point = findCoordinates(preOrderInfo.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        /* расчет координат кнопки оформления заказа */
        val preOrderButtonX = preOrderInfoSize.width/2
        val preOrderButtonY= preOrderInfoCoordinate.y+preOrderInfoSize.height+ preOrderInfoSize.height/2
        //нажать на кнопку по координатам
        tapByCoordinates(preOrderButtonX,preOrderButtonY)
        //авторизация
        authorizationApp("9510556586")
        // переход в главное меню
        clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH,, )
        TimeUnit.SECONDS.sleep(2)*/
    }

    }