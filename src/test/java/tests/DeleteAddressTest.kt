package tests

import MainActivity

class DeleteAddressTest : MainActivity() {
 /*   @Test
    fun deleteAddressTest() {

        checkAuthorizationUser(true)
        //переход на вкладку "Мои адреса"
        clickToElement(selectProfileButton.androidXPath, LocatorType.XPATH,, )
        clickToElement(Profile.addressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,, )
        //проверка наличия тестового адреса и его удаление
        runCatching {
            checkAvailableElement(Address.ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        }.onFailure {
            println("Error: ${it.message}")
        }.onSuccess {
            deleteAddress()
        }
        //нажать кнопку добавления адреса
        clickToElement(addAddressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,, )
        //обработать окно геопозиции
        useLocation()
        //нажать на кнопку добавления адреса
        clickToElement(addAddressButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,, )
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
            clickToElement(selectCatalogButton.androidXPath, LocatorType.XPATH,, )
            TimeUnit.SECONDS.sleep(2)
        }
    }*/
}