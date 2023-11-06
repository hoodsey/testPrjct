package screens

import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clearField
import TestFunctions.clickToElement
import TestFunctions.findCoordinates
import TestFunctions.findSizeElement
import TestFunctions.sendText
import TestFunctions.swipeElementDown
import TestFunctions.swipeScreenLeft
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point

class Address {

    public fun clickAddAddressButton() {
        clickToElement(
                locatorAndroid = locatorMap[AddressElements.ADD_ADDRESS_BUTTON_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.ADD_ADDRESS_BUTTON_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[AddressElements.ADD_ADDRESS_BUTTON_ELEMENT_NAME].toString(),
        )
    }

    fun checkViewNewAddress(): Boolean {
        return checkAvailableElement(
                locatorAndroid = locatorMap[AddressElements.VIEW_NEW_ADDRESS_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.VIEW_NEW_ADDRESS_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[AddressElements.VIEW_NEW_ADDRESS_ELEMENT_NAME].toString(),
        )
    }

    fun swipeLeftViewNewAddress() {
        swipeScreenLeft(
                locatorAndroid = locatorMap[AddressElements.VIEW_NEW_ADDRESS_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.VIEW_NEW_ADDRESS_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[AddressElements.VIEW_NEW_ADDRESS_ELEMENT_NAME].toString(),
        )
    }

    fun findSizeViewNewAddress(): Dimension {
        return findSizeElement(
                locatorAndroid = locatorMap[AddressElements.VIEW_NEW_ADDRESS_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.VIEW_NEW_ADDRESS_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[AddressElements.VIEW_NEW_ADDRESS_ELEMENT_NAME].toString(),
        )
    }
    fun findCoordinateViewNewAddress(): Point {
        return findCoordinates(
                locatorAndroid = locatorMap[AddressElements.VIEW_NEW_ADDRESS_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.VIEW_NEW_ADDRESS_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[AddressElements.VIEW_NEW_ADDRESS_ELEMENT_NAME].toString(),
        )

    }
    fun insertAddress(address: String) {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_ADDRESS_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_ADDRESS_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_ADDRESS_ELEMENT_NAME].toString(),
        )

        clearField(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_ADDRESS_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_ADDRESS_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_ADDRESS_ELEMENT_NAME].toString(),
        )
        sendText(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_ADDRESS_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_ADDRESS_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_ADDRESS_ELEMENT_NAME].toString(),
                text = address,
        )
        clickToElement(
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorAndroid = locatorMap[AddressElements.INSERT_NEW_ADDRESS_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_NEW_ADDRESS_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_NEW_ADDRESS_ELEMENT_NAME].toString(),
        )
    }

    fun insertFlat(flat: String) {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_FLAT_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_FLAT_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_FLAT_ELEMENT_NAME].toString(),
        )

        sendText(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_FLAT_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_FLAT_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_FLAT_ELEMENT_NAME].toString(),
                text = flat,
        )
    }

    fun insertEntrance(entrance: String) {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_ENTRANCE_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_ENTRANCE_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_ENTRANCE_ELEMENT_NAME].toString(),
        )

        sendText(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_ENTRANCE_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_ENTRANCE_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_ENTRANCE_ELEMENT_NAME].toString(),
                text = entrance,
        )
    }

    fun insertIntercom(intercom: String) {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_INTERCOM_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_INTERCOM_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_INTERCOM_ELEMENT_NAME].toString(),
        )

        sendText(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_INTERCOM_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_INTERCOM_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_INTERCOM_ELEMENT_NAME].toString(),
                text = intercom,
        )
    }

    fun insertFloor(floor: String) {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_FLOOR_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_FLOOR_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_FLOOR_ELEMENT_NAME].toString(),
        )

        sendText(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_FLOOR_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_FLOOR_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_FLOOR_ELEMENT_NAME].toString(),
                text = floor,
        )
    }

    fun insertComment(comment: String) {
        clickToElement(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_COMMENT_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_COMMENT_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_COMMENT_ELEMENT_NAME].toString(),
        )

        sendText(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AddressElements.INSERT_COMMENT_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.INSERT_COMMENT_IOS].toString(),
                elementName = locatorMap[AddressElements.INSERT_COMMENT_ELEMENT_NAME].toString(),
                text = comment,
        )
    }

    fun clickToSaveNewAddress() {
        clickToElement(
                locatorAndroid = locatorMap[AddressElements.SAVE_NEW_ADDRESS_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AddressElements.SAVE_NEW_ADDRESS_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[AddressElements.SAVE_NEW_ADDRESS_ELEMENT_NAME].toString(),
        )
    }

    fun swipeDownMyAddress() {
        swipeElementDown(
                locatorAndroid = locatorMap[AddressElements.MY_ADDRESSES_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.XPATH,
                locatorIOS = locatorMap[AddressElements.MY_ADDRESSES_IOS].toString(),
                locatorTypeIOS = LocatorType.IOS_CLASS_CHAIN,
                elementName = locatorMap[AddressElements.MY_ADDRESSES_ELEMENT_NAME].toString(),
        )
    }

    private enum class AddressElements {
        ADD_ADDRESS_BUTTON_ANDROID,
        ADD_ADDRESS_BUTTON_IOS,
        ADD_ADDRESS_BUTTON_ELEMENT_NAME,

        VIEW_NEW_ADDRESS_ANDROID,
        VIEW_NEW_ADDRESS_IOS,
        VIEW_NEW_ADDRESS_ELEMENT_NAME,

        INSERT_ADDRESS_ANDROID,
        INSERT_ADDRESS_IOS,
        INSERT_ADDRESS_ELEMENT_NAME,

        INSERT_NEW_ADDRESS_ANDROID,
        INSERT_NEW_ADDRESS_IOS,
        INSERT_NEW_ADDRESS_ELEMENT_NAME,

        INSERT_FLAT_ANDROID,
        INSERT_FLAT_IOS,
        INSERT_FLAT_ELEMENT_NAME,

        INSERT_ENTRANCE_ANDROID,
        INSERT_ENTRANCE_IOS,
        INSERT_ENTRANCE_ELEMENT_NAME,

        INSERT_INTERCOM_ANDROID,
        INSERT_INTERCOM_IOS,
        INSERT_INTERCOM_ELEMENT_NAME,

        INSERT_FLOOR_ANDROID,
        INSERT_FLOOR_IOS,
        INSERT_FLOOR_ELEMENT_NAME,

        INSERT_COMMENT_ANDROID,
        INSERT_COMMENT_IOS,
        INSERT_COMMENT_ELEMENT_NAME,

        SAVE_NEW_ADDRESS_ANDROID,
        SAVE_NEW_ADDRESS_IOS,
        SAVE_NEW_ADDRESS_ELEMENT_NAME,

        MY_ADDRESSES_ANDROID,
        MY_ADDRESSES_IOS,
        MY_ADDRESSES_ELEMENT_NAME,
    }

    private val locatorMap: LinkedHashMap<AddressElements, String> = linkedMapOf(
            AddressElements.ADD_ADDRESS_BUTTON_ANDROID to "Добавить новый адрес",
            AddressElements.ADD_ADDRESS_BUTTON_IOS to "Добавить новый адрес",
            AddressElements.ADD_ADDRESS_BUTTON_ELEMENT_NAME to "Кнопка добавления нового адреса",

            AddressElements.VIEW_NEW_ADDRESS_ANDROID to "Виленский переулок, 6\n" +
                    "кв 6, 6 подъезд, 6 этаж. Домофон: 6. 6",
            AddressElements.VIEW_NEW_ADDRESS_IOS to "Виленский переулок, 6\n" +
                    "кв 6, 6 подъезд, 6 этаж. Домофон: 6. 6",
            AddressElements.VIEW_NEW_ADDRESS_ELEMENT_NAME to "Элемент с новым адресом",

            AddressElements.INSERT_ADDRESS_ANDROID to "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.widget.EditText",
            AddressElements.INSERT_ADDRESS_IOS to "Адрес",
            AddressElements.INSERT_ADDRESS_ELEMENT_NAME to "Форма вствки нового адреса",

            AddressElements.INSERT_NEW_ADDRESS_ANDROID to "Виленский переулок, 6, Санкт-Петербург",
            AddressElements.INSERT_NEW_ADDRESS_IOS to "Виленский переулок, 6, Санкт-Петербург",
            AddressElements.INSERT_NEW_ADDRESS_ELEMENT_NAME to "Кнопка добавления нового адреса",

            AddressElements.INSERT_FLAT_ANDROID to "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]",
            AddressElements.INSERT_FLAT_IOS to "Квартира",
            AddressElements.INSERT_FLAT_ELEMENT_NAME to "Поле ввода квартиры",

            AddressElements.INSERT_ENTRANCE_ANDROID to "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]",
            AddressElements.INSERT_ENTRANCE_IOS to "Подъезд",
            AddressElements.INSERT_ENTRANCE_ELEMENT_NAME to "Поле ввода подъезда",

            AddressElements.INSERT_INTERCOM_ANDROID to "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]",
            AddressElements.INSERT_INTERCOM_IOS to "Домофон",
            AddressElements.INSERT_INTERCOM_ELEMENT_NAME to "Поле ввода домофона",

            AddressElements.INSERT_FLOOR_ANDROID to "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]",
            AddressElements.INSERT_FLOOR_IOS to "Этаж",
            AddressElements.INSERT_FLOOR_ELEMENT_NAME to "Поле ввода квартиры",

            AddressElements.INSERT_COMMENT_ANDROID to "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[5]",
            AddressElements.INSERT_COMMENT_IOS to "Комментарий для курьера",
            AddressElements.INSERT_COMMENT_ELEMENT_NAME to "Поле ввода коментария к адресу",

            AddressElements.SAVE_NEW_ADDRESS_ANDROID to "Сохранить",
            AddressElements.SAVE_NEW_ADDRESS_IOS to "Сохранить",
            AddressElements.SAVE_NEW_ADDRESS_ELEMENT_NAME to "Кнопка сохранить адрес",

            AddressElements.MY_ADDRESSES_ANDROID to "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View",
            AddressElements.MY_ADDRESSES_IOS to "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView",
            AddressElements.MY_ADDRESSES_ELEMENT_NAME to "Окно Мои адреса",
    )
}