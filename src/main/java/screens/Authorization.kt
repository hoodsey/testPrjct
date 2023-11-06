package screens

import LocatorType
import TestFunctions.clickToElement
import TestFunctions.getAttribute
import TestFunctions.sendText

class Authorization {
    fun sendPhone(text: String) {
        sendText(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AuthorizationElements.SELECT_PHONE_ANDROID].toString(),
                locatorTypeIOS = LocatorType.XPATH,
                locatorIOS = locatorMap[AuthorizationElements.SELECT_PHONE_IOS].toString(),
                text = text,
                elementName = locatorMap[AuthorizationElements.SELECT_PHONE_ELEMENT_NAME].toString(),
        )
    }

    fun clickToSendCodeButton() {
        clickToElement(
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorAndroid = locatorMap[AuthorizationElements.SEND_CODE_BUTTON_ANDROID].toString(),
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = locatorMap[AuthorizationElements.SEND_CODE_BUTTON_IOS].toString(),
                elementName = locatorMap[AuthorizationElements.SEND_CODE_BUTTON_ELEMENT_NAME].toString(),
        )
    }

    fun getAttributeCodeAuthElement(text: String): String {
        return getAttribute(
                locatorTypeAndroid = LocatorType.XPATH,
                locatorAndroid = locatorMap[AuthorizationElements.GET_ATTRIBUTE_AUTH_ELEMENT_ANDROID].toString(),
                locatorTypeIOS = LocatorType.XPATH,
                locatorIOS = locatorMap[AuthorizationElements.GET_ATTRIBUTE_AUTH_ELEMENT_IOS].toString(),
                elementName = locatorMap[AuthorizationElements.GET_ATTRIBUTE_AUTH_ELEMENT_ELEMENT_NAME].toString(),
                attribute = text,
        )
    }

    fun codeInsert(text: String) {
        sendText(
                locatorTypeAndroid = LocatorType.CLASS_NAME,
                locatorAndroid = locatorMap[AuthorizationElements.CODE_INSERT_ANDROID].toString(),
                locatorTypeIOS = LocatorType.XPATH,
                locatorIOS = locatorMap[AuthorizationElements.CODE_INSERT_IOS].toString(),
                text = text,
                elementName = locatorMap[AuthorizationElements.CODE_INSERT_ELEMENT_NAME].toString(),
        )
    }

    private enum class AuthorizationElements {
        SELECT_PHONE_ANDROID,
        SELECT_PHONE_IOS,
        SELECT_PHONE_ELEMENT_NAME,

        SEND_CODE_BUTTON_ANDROID,
        SEND_CODE_BUTTON_IOS,
        SEND_CODE_BUTTON_ELEMENT_NAME,

        GET_ATTRIBUTE_AUTH_ELEMENT_ANDROID,
        GET_ATTRIBUTE_AUTH_ELEMENT_IOS,
        GET_ATTRIBUTE_AUTH_ELEMENT_ELEMENT_NAME,

        CODE_INSERT_ANDROID,
        CODE_INSERT_IOS,
        CODE_INSERT_ELEMENT_NAME,
    }

    private val locatorMap: LinkedHashMap<AuthorizationElements, String> = linkedMapOf(
            AuthorizationElements.SELECT_PHONE_ANDROID to "//android.view.View[@content-desc=\"Укажите телефон\n" +
                    "На него отправим код подтверждения\"]/android.widget.EditText",
            AuthorizationElements.SELECT_PHONE_IOS to "//XCUIElementTypeTextField",
                AuthorizationElements.SELECT_PHONE_ELEMENT_NAME to "Элемент в окне авторизации для ввода телефона",

            AuthorizationElements.SEND_CODE_BUTTON_ANDROID to "Получить код",
            AuthorizationElements.SEND_CODE_BUTTON_IOS to "Получить код",
            AuthorizationElements.SEND_CODE_BUTTON_ELEMENT_NAME to "Кнопка  для отправки кода атворизации",

            AuthorizationElements.GET_ATTRIBUTE_AUTH_ELEMENT_ANDROID to "//*[starts-with(@content-desc,'Введите код из смс')]",
            AuthorizationElements.GET_ATTRIBUTE_AUTH_ELEMENT_IOS to "//*[starts-with(@name,'Введите код из смс')]",
            AuthorizationElements.GET_ATTRIBUTE_AUTH_ELEMENT_ELEMENT_NAME to "Элемент в окне авторизации c выводом кода авторизации",

            AuthorizationElements.CODE_INSERT_ANDROID to "android.widget.EditText",
            AuthorizationElements.CODE_INSERT_IOS to "//XCUIElementTypeTextField",
            AuthorizationElements.CODE_INSERT_ELEMENT_NAME to "Элемент в окне авторизации для кода авторизации"
    )
}