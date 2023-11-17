package screens

import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement

class MainPage {

    public fun clickSystemAboutMonitoring() {
        clickToElement(
                locatorAndroid = locatorMap[MaimPageElements.SYSTEM_ABOUT_MONITORING_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.XPATH,
                locatorIOS = locatorMap[MaimPageElements.SYSTEM_ABOUT_MONITORING_IOS].toString(),
                locatorTypeIOS = LocatorType.IOS_CLASS_CHAIN,
                elementName = locatorMap[MaimPageElements.SYSTEM_ABOUT_MONITORING_ELEMENT_NAME].toString(),
        )
    }

    public fun clickRollUpElement() {
        clickToElement(
                locatorAndroid = locatorMap[MaimPageElements.ROLL_UP_ELEMENT_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[MaimPageElements.ROLL_UP_ELEMENT_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[MaimPageElements.ROLL_UP_ELEMENT_ELEMENT_NAME].toString(),
        )
    }

    public fun clickToSoupCategory() {
        clickToElement(
                locatorAndroid = locatorMap[MaimPageElements.SOUP_CATEGORY_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[MaimPageElements.SOUP_CATEGORY_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[MaimPageElements.SOUP_CATEGORY_ELEMENT_NAME].toString(),
        )
    }

    public fun addSoupInCart() {
        clickToElement(
                locatorAndroid = locatorMap[MaimPageElements.ADD_SOUP_IN_CART_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[MaimPageElements.ADD_SOUP_IN_CART_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[MaimPageElements.ADD_SOUP_IN_CART_ELEMENT_NAME].toString(),
        )
    }

    public fun goOverCart() {
        clickToElement(
                locatorAndroid = locatorMap[MaimPageElements.GO_OVER_CART_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.XPATH,
                locatorIOS = locatorMap[MaimPageElements.GO_OVER_CART_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[MaimPageElements.GO_OVER_CART_ELEMENT_NAME].toString(),
        )
    }

    public fun checkAvailableCartButton(): Boolean {
        return checkAvailableElement(
                locatorAndroid = locatorMap[MaimPageElements.GO_OVER_CART_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.XPATH,
                locatorIOS = locatorMap[MaimPageElements.GO_OVER_CART_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[MaimPageElements.GO_OVER_CART_ELEMENT_NAME].toString(),
        )
    }

    public fun checkViewAddress(): Boolean {
        return checkAvailableElement(
                locatorAndroid = locatorMap[MaimPageElements.VIEW_ADDRESS_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[MaimPageElements.VIEW_ADDRESS_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[MaimPageElements.VIEW_ADDRESS_ELEMENT_NAME].toString(),
        )
    }

    public fun clickToAddress() {
        clickToElement(
                locatorAndroid = locatorMap[MaimPageElements.VIEW_ADDRESS_ANDROID].toString(),
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[MaimPageElements.VIEW_ADDRESS_IOS].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                elementName = locatorMap[MaimPageElements.VIEW_ADDRESS_ELEMENT_NAME].toString(),
        )
    }

    private enum class MaimPageElements {
        SYSTEM_ABOUT_MONITORING_ANDROID,
        SYSTEM_ABOUT_MONITORING_IOS,
        SYSTEM_ABOUT_MONITORING_ELEMENT_NAME,

        ROLL_UP_ELEMENT_ANDROID,
        ROLL_UP_ELEMENT_IOS,
        ROLL_UP_ELEMENT_ELEMENT_NAME,

        SOUP_CATEGORY_ANDROID,
        SOUP_CATEGORY_IOS,
        SOUP_CATEGORY_ELEMENT_NAME,

        ADD_SOUP_IN_CART_ANDROID,
        ADD_SOUP_IN_CART_IOS,
        ADD_SOUP_IN_CART_ELEMENT_NAME,

        GO_OVER_CART_ANDROID,
        GO_OVER_CART_IOS,
        GO_OVER_CART_ELEMENT_NAME,

        VIEW_ADDRESS_ANDROID,
        VIEW_ADDRESS_IOS,
        VIEW_ADDRESS_ELEMENT_NAME,
    }

    fun insertPriceFromApi(
            price: Int?,
    ) {
        val locator = "${price.toString()} ₽"
        locatorMap[MaimPageElements.ADD_SOUP_IN_CART_ANDROID] = locator
        locatorMap[MaimPageElements.ADD_SOUP_IN_CART_IOS] = locator

    }

    private val locatorMap: LinkedHashMap<MainPage.MaimPageElements, String> = linkedMapOf(
            MaimPageElements.SYSTEM_ABOUT_MONITORING_ANDROID to "",
            MaimPageElements.SYSTEM_ABOUT_MONITORING_IOS to "**/XCUIElementTypeOther[`label == \"Горизонтальная полоса прокрутки, 1 страница\"`][2]",
            MaimPageElements.SYSTEM_ABOUT_MONITORING_ELEMENT_NAME to "Закрыть системное окно на IOS",

            MaimPageElements.ROLL_UP_ELEMENT_ANDROID to "Закрыть",
            MaimPageElements.ROLL_UP_ELEMENT_IOS to "Закрыть",
            MaimPageElements.ROLL_UP_ELEMENT_ELEMENT_NAME to "Свернуть окно с выбором типа заказа",

            MaimPageElements.SOUP_CATEGORY_ANDROID to "Супы",
            MaimPageElements.SOUP_CATEGORY_IOS to "Супы",
            MaimPageElements.SOUP_CATEGORY_ELEMENT_NAME to "Кнопка перехода к разделу Супы",

            MaimPageElements.ADD_SOUP_IN_CART_ANDROID to "",
            MaimPageElements.ADD_SOUP_IN_CART_IOS to "",
            MaimPageElements.ADD_SOUP_IN_CART_ELEMENT_NAME to "Кнопка добавления cупа в заказ",

            MaimPageElements.GO_OVER_CART_ANDROID to "//*[contains(@content-desc,'Корзина')]",
            MaimPageElements.GO_OVER_CART_IOS to "1\n" +
                    "Корзина\n" +
                    "444 ₽",
            MaimPageElements.GO_OVER_CART_ELEMENT_NAME to "Кнопка перехода в корзину с главного экрана",

            MaimPageElements.VIEW_ADDRESS_ANDROID to "Виленский переулок, 6",
            MaimPageElements.VIEW_ADDRESS_IOS to "Виленский переулок, 6",
            MaimPageElements.VIEW_ADDRESS_ELEMENT_NAME to "Отображение введенного адреса на главной странице",
    )
}