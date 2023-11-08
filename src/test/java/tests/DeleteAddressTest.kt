package tests

import MainActivity
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
        // проверка авторизации
        checkAuthorizationUser(true)
        //переход на вкладку "Мои адреса"
        menuApps.selectProfileButton()
        profile.clickToAddressButton()
        //проверка наличия тестового адреса и его удаление
        runCatching {
            address.checkViewNewAddress()
        }.onFailure {
            println("Error: ${it.message}")
        }.onSuccess {
            deleteAddress()
        }
        //нажать кнопку добавления адреса
        address.clickAddAddressButton()
        //вызов функции обработки разрешения на геопозицию
        useLocation()
        //нажать на кнопку добавления адреса
        address.clickAddAddressButton()
        // ввод адреса. Таймайт обязателен, без него иногда крашится
        TimeUnit.SECONDS.sleep(2)
        fillingAddress( "Виленский переулок, 6, Санкт-Петербург", "6", "6", "6", "6", "6")
        // проверка наличия нового адреса и его удаление
        if (address.checkViewNewAddress()) {
            deleteAddress()
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
