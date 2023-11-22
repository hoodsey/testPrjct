package general_cases_for_tests

import TestFunctions.findWidthScreen
import TestFunctions.tapByCoordinates
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import screens.Address
import screens.Location
import java.util.concurrent.TimeUnit

object FillingAddressScenarios {

    fun fillingAddress(address: String, flat: String, entrance: String, intercom: String, floor: String, comment: String) {
        //вставить адрес
        val addressClass = Address()
        addressClass.insertAddress(address)
        //вставить номер квартиры
        addressClass.insertFlat(flat)
        //вставить номер подъезда
        addressClass.insertEntrance(entrance)
        //вставить номер домофона
        addressClass.insertIntercom(intercom)
        //вставить номер этажа
        addressClass.insertFloor(floor)
        //вставить комментарий
        addressClass.insertComment(comment)
        //нажать кнопку сохранить адрес
        addressClass.clickToSaveNewAddress()
    }

    //функция обрабатывает окно геопозиции
    fun useLocation() {
        val location = Location()
        try {
            location.clickToUsingLocation(findElementWithOutCatching = true)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace() //Распечатываем ошибку в консоль
            println("Мы поймали ошибку, и теперь тест не упадет")
        }
        TimeUnit.SECONDS.sleep(5)
    }

    //функция удаляет новый адрес
    fun deleteAddress(address: Address) {
        //свайп влево по элементу с адресом
        address.swipeLeftViewNewAddress(findElementWithOutCatching = true)
        //размеры элемента
        val addressViewSize: Dimension = address.findSizeViewNewAddress(findElementWithOutCatching = true)
        val addressViewCoordinate: Point = address.findCoordinateViewNewAddress(findElementWithOutCatching = true)
        // размер экрана устройства
        val widthScreens = findWidthScreen()
        //расчет координат кнопки "Удалить"
        var deleteButtonX = 0
        var deleteButtonY = 0
        deleteButtonX = widthScreens - (widthScreens - addressViewSize.width) / 2
        deleteButtonY = addressViewCoordinate.y + addressViewSize.height / 2
        // нажать по вычесленным координатам
        tapByCoordinates(deleteButtonX, deleteButtonY)
        TimeUnit.SECONDS.sleep(2)
    }
}