package general_cases_for_tests

object FillingAddressScenarios {

  /*  fun fillingAddress(address: String, flat: String, entrance: String, intercom: String, floor: String, comment: String) {
        //вставить адрес
        clickToElement(insertAddress.androidXPath, LocatorType.XPATH,, )
        clearField(insertAddress.androidXPath, LocatorType.XPATH)
        sendText(insertAddress.androidXPath, LocatorType.XPATH, address)
        clickToElement(insertNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,, )
        //вставить номер квартиры
        clickToElement(insertFlat.androidXPath, LocatorType.XPATH,, )
        sendText(insertFlat.androidXPath, LocatorType.XPATH, flat)
        //вставить номер подъезда
        clickToElement(insertEntrance.androidXPath, LocatorType.XPATH,, )
        sendText(insertEntrance.androidXPath, LocatorType.XPATH, entrance)
        //вставить номер домофона
        clickToElement(insertIntercom.androidXPath, LocatorType.XPATH,, )
        sendText(insertIntercom.androidXPath, LocatorType.XPATH, intercom)
        //вставить номер этажа
        clickToElement(insertFloor.androidXPath, LocatorType.XPATH,, )
        sendText(insertFloor.androidXPath, LocatorType.XPATH, floor)
        //вставить комментарий
        clickToElement(insertComment.androidXPath, LocatorType.XPATH,, )
        sendText(insertComment.androidXPath, LocatorType.XPATH, comment)
        //нажать кнопку сохранить адрес
        clickToElement(saveNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID,, )
    }

    //функция обрабатывает окно геопозиции
    fun useLocation(){
        try {
            clickToElement(Location.usingLocation.androidXPath, LocatorType.XPATH,, )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace() //Распечатываем ошибку в консоль
            println("Мы поймали ошибку, и теперь тест не упадет")
        }
        TimeUnit.SECONDS.sleep(2)
    }
    //функция удаляет новый адрес
    fun deleteAddress(){
        //свайп влево по элементу с адресом
        swipeScreenLeft(Address.ViewNewAddress.androidAccessibilityId,LocatorType.ACCESSIBILITY_ID)
        //размеры элемента
        val  addressViewSize: Dimension = findSizeElement(Address.ViewNewAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        // размер экрана устройства
        val widthAndroid = findWidthScreen()
        //расчет координат кнопки "Удалить"
        val deleteButtonX =  widthAndroid-(widthAndroid-addressViewSize.width)/2
        val deleteButtonY = addressViewSize.width/2
        // нажать по вычесленным координатам
        tapByCoordinates(deleteButtonX,deleteButtonY)

    }*/
}