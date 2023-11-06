package tests

import GlobalVariable.platformType
import MainActivity
import TestFunctions.tapByCoordinates
import TypeOS
import general_cases_for_tests.AuthorizationScenarios.authorizationApp
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import general_cases_for_tests.FillingAddressScenarios.deleteAddress
import general_cases_for_tests.FillingAddressScenarios.fillingAddress
import general_cases_for_tests.FillingAddressScenarios.useLocation
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.testng.annotations.Test
import screens.Cart
import screens.MainPage
import screens.MenuApps
import java.util.concurrent.TimeUnit

class DeliveryWithOutAuthTest : MainActivity() {

    @Test
    fun deliveryWithOutAuthTest() {

        checkAuthorizationUser(false)

        val menuApps = MenuApps()
        val mainPage = MainPage()
        val cart = Cart()

        menuApps.selectCatalogButton()

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
            deleteAddress()
            useLocation()
            mainPage.clickRollUpElement()
        }
        //выбор блюда
        mainPage.clickToSoupCategory()
        mainPage.addBorschInCart()
        //разрешение на геопозицию и ввод адреса
        useLocation()
        fillingAddress("Виленский переулок, 6, Санкт-Петербург", "6", "6", "6", "6", "6")
        // переход в коризну
        mainPage.goOverCart()
        // размер и координаты элемента с информацией о заказе
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
        //авторизация
        authorizationApp("9510556586")
        // переход в главное меню
        menuApps.selectCatalogButton()
        menuApps.selectProfileButton()
        TimeUnit.SECONDS.sleep(2)
    }

}
