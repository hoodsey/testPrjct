package tests

import MainActivity
import api_client.environment.Environment
import api_client.requests.auth.AuthResetCode
import api_client.requests.auth.Login
import api_client.requests.categories.ProfileApi
import api_client.requests.categories.User
import api_client.specifications.Specifications
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import general_cases_for_tests.FillingAddressScenarios.deleteAddress
import general_cases_for_tests.FillingAddressScenarios.fillingAddress
import general_cases_for_tests.FillingAddressScenarios.useLocation
import org.testng.annotations.Test
import screens.Address
import screens.MenuApps
import screens.Profile
import java.util.concurrent.TimeUnit


class DeleteAddressTest : MainActivity() {
    @Test
    fun deleteAddressTest() {
        val menuApps = MenuApps()
        val profile = Profile()
        val address = Address()

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

        // проверка авторизации
        checkAuthorizationUser(true)
        //переход на вкладку "Мои адреса"
        menuApps.selectProfileButton()
        profile.clickToAddressButton()

        //запрос данных профиля
        ProfileApi.get(mutableMapOf())
        // поиск адреса в овтете запроса
        for (addressApi in ProfileApi.resBody.addresses) {
            if (addressApi.street == "Виленский переулок, 6")
                address.insertAddressViewFromApi(addressApi.street, addressApi.flat, addressApi.floor, addressApi.entrance, addressApi.doorphone, addressApi.comment)
        }

        //проверка наличия тестового адреса и его удаление
        runCatching {
            address.checkViewNewAddress()
        }.onFailure {
            println("Error: ${it.message}")
        }.onSuccess {
            deleteAddress(address)
        }
        //нажать кнопку добавления адреса
        address.clickAddAddressButton()
        //вызов функции обработки разрешения на геопозицию
        useLocation()
        //нажать на кнопку добавления адреса
        address.clickAddAddressButton()
        // ввод адреса. Таймайт обязателен, без него иногда крашится
        TimeUnit.SECONDS.sleep(2)
        fillingAddress("Виленский переулок, 6, Санкт-Петербург", "6", "6", "6", "6", "6")
        // проверка наличия нового адреса и его удаление
        TimeUnit.SECONDS.sleep(2)
        if (address.checkViewNewAddress()) {
            deleteAddress(address)
        }
        //проверка наличия после удаления
        runCatching {
            address.checkViewNewAddress()
        }.onFailure {
            // скрыть окно "Мой адреса" и перейти на главную
            address.swipeDownMyAddress()
            menuApps.selectCatalogButton()
        }
        TimeUnit.SECONDS.sleep(2)
    }
}
