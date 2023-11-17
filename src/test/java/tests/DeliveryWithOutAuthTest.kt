package tests

import MainActivity
import api_client.environment.Environment
import api_client.requests.auth.AuthResetCode
import api_client.requests.auth.Login
import api_client.requests.categories.Meals
import api_client.requests.categories.User
import api_client.specifications.Specifications
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

        // инициализация сессии
        Specifications.installSpecification(Specifications.requestSpec(Environment.environment.host))
        // Запрос sessionID
        User.get(mutableMapOf())
        // Изменение параметра sesseionId в окружении
        Environment.updateSessionId(User.resBody)
        // запрос кода авторизации
        AuthResetCode.post(AuthResetCode.authResetCodeReqBody("79510556586"))
        // запрос токена
        Login.post(Login.loginReqBody("79510556586", "3256"))
        // изменение токена в окружении
        Environment.updateAuthToken(Login.resBody)

        checkAuthorizationUser(false)

        val menuApps = MenuApps()
        val mainPage = MainPage()
        val cart = Cart()

        menuApps.selectCatalogButton()
        /* проверка есть ли уже товары в корзине и указан ли адрес */
        checkShoppingCart(mainPage, cart)
        //выбор блюда
        mainPage.clickToSoupCategory()

        // запрос меню с главной страницы
        Meals.get(mutableMapOf())
        // поиск в запросе первого супа
        for (mealsApi in Meals.resBody) {
            if (mealsApi.categories[0] == "supy") {
                mainPage.insertPriceFromApi(mealsApi.price)
                break
            }
        }
        // добавление в корзину
        TimeUnit.SECONDS.sleep(5)
        mainPage.addSoupInCart()
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
