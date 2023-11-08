package general_cases_for_tests

import GlobalVariable.platformType
import TestFunctions.tapByCoordinates
import TypeOS
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import screens.Cart
import screens.MainPage
import java.util.concurrent.TimeUnit

object DeliveryScenarios {

    fun checkShoppingCart(mainPage: MainPage, cart: Cart) {
        // если есть товары в корзине, то корзина отчищается
        runCatching {
            mainPage.checkAvailableCartButton()
        }.onSuccess {
            mainPage.goOverCart()
            cart.cleanCart()
        }
        // если задан адрес, то адрес удаляется
        runCatching {
            mainPage.checkViewAddress()
        }.onSuccess {
            mainPage.clickToAddress()
            TimeUnit.SECONDS.sleep(2)
            FillingAddressScenarios.deleteAddress()
            FillingAddressScenarios.useLocation()
            mainPage.clickRollUpElement()
        }
    }

    fun clickButtonOrder(cart: Cart) {
        val preOrderInfoSize: Dimension = cart.findSizePreOrderInfo()
        val preOrderInfoCoordinate: Point = cart.findCoordinatePreOrderInfo()
        /* расчет координат кнопки оформления заказа */
        var preOrderButtonX = 0
        var preOrderButtonY = 0
        when (platformType) {
            TypeOS.ANDROID -> {
                preOrderButtonX = preOrderInfoSize.width / 2
                preOrderButtonY = preOrderInfoCoordinate.y + preOrderInfoSize.height + preOrderInfoSize.height / 2
            }

            TypeOS.IOS -> {
                preOrderButtonX = preOrderInfoSize.width / 2
                preOrderButtonY = preOrderInfoCoordinate.y + preOrderInfoSize.height / 2 + preOrderInfoSize.height / 4
            }
        }
        //нажать на кнопку по координатам
        tapByCoordinates(preOrderButtonX, preOrderButtonY)
    }
}