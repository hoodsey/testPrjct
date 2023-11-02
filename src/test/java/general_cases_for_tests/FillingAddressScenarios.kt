package general_cases_for_tests

import GlobalVariable.platformType
import LocatorType
import TestFunctions.clearField
import TestFunctions.clickToElement
import TestFunctions.findSizeElement
import TestFunctions.findWidthScreen
import TestFunctions.sendText
import TestFunctions.swipeScreenLeft
import TestFunctions.tapByCoordinates
import TypeOS
import org.openqa.selenium.Dimension
import screens.Address.ViewNewAddress
import screens.Address.insertAddress
import screens.Address.insertComment
import screens.Address.insertEntrance
import screens.Address.insertFlat
import screens.Address.insertFloor
import screens.Address.insertIntercom
import screens.Address.insertNewAddress
import screens.Address.saveNewAddress
import screens.Location.usingLocation
import java.util.concurrent.TimeUnit

object FillingAddressScenarios {

    fun fillingAddress(address: String, flat: String, entrance: String, intercom: String, floor: String, comment: String) {
        //вставить адрес
        clickToElement(insertAddress.androidXPath, LocatorType.XPATH, insertAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        clearField(insertAddress.androidXPath, LocatorType.XPATH, insertAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        sendText(insertAddress.androidXPath, LocatorType.XPATH, insertAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID, address)
        clickToElement(insertNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, insertNewAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        //вставить номер квартиры
        clickToElement(insertFlat.androidXPath, LocatorType.XPATH, insertFloor.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        sendText(insertFlat.androidXPath, LocatorType.XPATH, insertFlat.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID, "6")
        //вставить номер подъезда
        clickToElement(insertEntrance.androidXPath, LocatorType.XPATH, insertEntrance.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        sendText(insertEntrance.androidXPath, LocatorType.XPATH, insertEntrance.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID, entrance)
        //вставить номер домофона
        clickToElement(insertIntercom.androidXPath, LocatorType.XPATH, insertIntercom.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        sendText(insertIntercom.androidXPath, LocatorType.XPATH, insertIntercom.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID, intercom)
        //вставить номер этажа
        clickToElement(insertFloor.androidXPath, LocatorType.XPATH, insertFloor.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        sendText(insertFloor.androidXPath, LocatorType.XPATH, insertFloor.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID, floor)
        //вставить комментарий
        clickToElement(insertComment.androidXPath, LocatorType.XPATH, insertComment.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        sendText(insertComment.androidXPath, LocatorType.XPATH, insertComment.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID, comment)
        //нажать кнопку сохранить адрес
        clickToElement(saveNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, saveNewAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
    }

    //функция обрабатывает окно геопозиции
    fun useLocation() {
        try {
            clickToElement(usingLocation.androidXPath, LocatorType.XPATH, usingLocation.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace() //Распечатываем ошибку в консоль
            println("Мы поймали ошибку, и теперь тест не упадет")
        }
        TimeUnit.SECONDS.sleep(2)
    }

    //функция удаляет новый адрес
    fun deleteAddress() {
        //свайп влево по элементу с адресом
        swipeScreenLeft(ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, ViewNewAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        //размеры элемента
        val addressViewSize: Dimension = findSizeElement(ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID, ViewNewAddress.iosAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        //размеры элемента
        // размер экрана устройства
        val widthScreens = findWidthScreen()
        //расчет координат кнопки "Удалить"
        var deleteButtonX = 0
        var deleteButtonY = 0
        when (platformType) {
            TypeOS.IOS -> {
                deleteButtonX = widthScreens - (widthScreens - addressViewSize.width) / 2
                deleteButtonY = addressViewSize.width / 2 + addressViewSize.height / 2

            }

            TypeOS.ANDROID -> {
                deleteButtonX = widthScreens - (widthScreens - addressViewSize.width) / 2
                deleteButtonY = addressViewSize.width / 2
            }
        }
        // нажать по вычесленным координатам
        tapByCoordinates(deleteButtonX, deleteButtonY)

    }
}