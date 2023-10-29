package tests

import LocatorType
import MainActivity
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement
import TestFunctions.swipeElementDown
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import general_cases_for_tests.FillingAddressScenarios.deleteAddress
import general_cases_for_tests.FillingAddressScenarios.fillingAddress
import general_cases_for_tests.FillingAddressScenarios.useLocation
import org.testng.annotations.Test
import screens.Address
import screens.Address.ViewNewAddress
import screens.Address.addAddressButton
import screens.Address.addressesView
import screens.MenuApps.selectCatalogButton
import screens.MenuApps.selectProfileButton
import screens.Profile
import java.util.concurrent.TimeUnit

class DeleteAddressTest : MainActivity() {
    @Test
    fun deleteAddressTest() {

        checkAuthorizationUser(true)
        //переход на вкладку "Мои адреса"
        clickToElement(selectProfileButton.androidXPath, LocatorType.XPATH)
        clickToElement(Profile.addressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        //проверка наличия тестового адреса и его удаление
        runCatching {
            checkAvailableElement(Address.ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        }.onFailure {
            println("Error: ${it.message}")
        }.onSuccess {
            deleteAddress()
        }
        //нажать кнопку добавления адреса
        clickToElement(addAddressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        //обработать окно геопозиции
        useLocation()
        //нажать на кнопку добавления адреса
        clickToElement(addAddressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        // ввод адреса
        fillingAddress("Виленский переулок, 6, Санкт-Петербург", "6", "6", "6", "6", "6")
        // проверка наличия нового адреса и его удаление
        if (checkAvailableElement(ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)) {
            deleteAddress()
        }
        //проверка наличия после удаления
        runCatching {
            checkAvailableElement(ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        }.onFailure {
            // скрыть окно "Мой адреса" и перейти на главную
            swipeElementDown(addressesView.androidXPath, LocatorType.XPATH)
            clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH)
            TimeUnit.SECONDS.sleep(2)
        }
    }
}