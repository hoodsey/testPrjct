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
import screens.Address.ViewNewAddress
import screens.Address.addAddressButton
import screens.Address.addressesView
import screens.MenuApps.selectCatalogButton
import screens.MenuApps.selectProfileButton
import screens.Profile.addressButton
import java.util.concurrent.TimeUnit

class DeleteAddressTest : MainActivity() {
    @Test
    fun deleteAddressTest() {

        checkAuthorizationUser(true)
        //переход на вкладку "Мои адреса"
        clickToElement(selectProfileButton.androidXPath, LocatorType.XPATH, selectProfileButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN)
        clickToElement(addressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, addressButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)

        TimeUnit.SECONDS.sleep(5)
        //проверка наличия тестового адреса и его удаление
        runCatching {
            checkAvailableElement(ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, ViewNewAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        }.onFailure {
            println("Error: ${it.message}")
        }.onSuccess {
            deleteAddress()
        }
        TimeUnit.SECONDS.sleep(5)
        //нажать кнопку добавления адреса
        clickToElement(addAddressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, addAddressButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(2)
        useLocation()

        //нажать на кнопку добавления адреса
        clickToElement(addAddressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, addAddressButton.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        // ввод адреса
        fillingAddress("Виленский переулок, 6, Санкт-Петербург", "6", "6", "6", "6", "6")
        // проверка наличия нового адреса и его удаление

        if (checkAvailableElement(ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, ViewNewAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)) {
            deleteAddress()
        }
        //проверка наличия после удаления
        runCatching {
            checkAvailableElement(ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, ViewNewAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        }.onFailure {
            // скрыть окно "Мой адреса" и перейти на главную
            swipeElementDown(addressesView.androidXPath, LocatorType.XPATH, addressesView.iosClassChain, LocatorType.IOS_CLASS_CHAIN)
            clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH, selectCatalogButton.iosClassChain, LocatorType.IOS_CLASS_CHAIN)
        }
        TimeUnit.SECONDS.sleep(2)
    }
}
