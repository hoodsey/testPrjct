package tests

import MainActivity
import general_cases_for_tests.AuthorizationScenarios.authorizationApp
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import general_cases_for_tests.DeliveryScenarios.checkShoppingCart
import general_cases_for_tests.DeliveryScenarios.clickButtonOrder
import general_cases_for_tests.FillingAddressScenarios.fillingAddress
import general_cases_for_tests.FillingAddressScenarios.useLocation
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
        /* проверка есть ли уже товары в корзине и указан ли адрес */
        checkShoppingCart(mainPage, cart)
        //выбор блюда
        mainPage.clickToSoupCategory()
        mainPage.addBorschInCart()
        //разрешение на геопозицию и ввод адреса
        useLocation()
        fillingAddress("Виленский переулок, 6, Санкт-Петербург", "6", "6", "6", "6", "6")
        // переход в коризну
        mainPage.goOverCart()
        // нажать на кнопку оформления заказа
        clickButtonOrder(cart)
        //авторизация
        authorizationApp("9510556586")
        TimeUnit.SECONDS.sleep(2)
        // переход в главное меню
        menuApps.selectCatalogButton()
        menuApps.selectProfileButton()
        TimeUnit.SECONDS.sleep(2)
    }

}
