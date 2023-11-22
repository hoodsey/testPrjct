package general_cases_for_tests

import GlobalVariable.platformType
import TestFunctions.tapByCoordinates
import TypeOS
import api_client.requests.categories.ProfileApi
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import screens.Address
import screens.Cart
import screens.MainPage
import java.util.concurrent.TimeUnit

object DeliveryScenarios {

    fun checkShoppingCart(mainPage: MainPage, cart: Cart) {
        // если есть товары в корзине, то корзина отчищается
        runCatching {
            mainPage.checkAvailableCartButton(findElementWithOutCatching = true)
        }.onSuccess {
            mainPage.goOverCart(findElementWithOutCatching = true)
            cart.cleanCart(findElementWithOutCatching = true)
        }
        // если задан адрес, то адрес удаляется
        runCatching {
            mainPage.checkViewAddress(findElementWithOutCatching = true)
        }.onSuccess {
            mainPage.clickToAddress(findElementWithOutCatching = true)
            TimeUnit.SECONDS.sleep(2)
            //запрос данных профиля
            ProfileApi.get(mutableMapOf())
            val address = Address()
            for (addressApi in ProfileApi.resBody.addresses) {
                if (addressApi.street == "Виленский переулок, 6")
                    address.insertAddressViewFromApi(addressApi.street, addressApi.flat, addressApi.floor, addressApi.entrance, addressApi.doorphone, addressApi.comment)
            }
            FillingAddressScenarios.deleteAddress(address)
            FillingAddressScenarios.useLocation()
            mainPage.clickRollUpElement(findElementWithOutCatching = true)
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