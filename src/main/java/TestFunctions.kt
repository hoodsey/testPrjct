import GlobalVariable.androidDriver
import GlobalVariable.iosDriver
import GlobalVariable.platformType
import io.appium.java_client.AppiumBy
import io.qameta.allure.Attachment
import io.qameta.allure.Step
import org.openqa.selenium.*
import org.openqa.selenium.interactions.Pause
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.time.Duration.ofMillis
import java.util.*

object TestFunctions {

    //функция выобра по типу ОС пары locator, locatorType
    fun checkTypeOS(locatorAndroid: String,
                    locatorTypeAndroid: LocatorType,
                    locatorIOS: String,
                    locatorTypeIOS: LocatorType): Pair<String, LocatorType> {
        if (platformType == TypeOS.ANDROID) {
            return Pair(locatorAndroid, locatorTypeAndroid)
        } else {
            return Pair(locatorIOS, locatorTypeIOS)
        }
    }

    // фнукция клика по элементу
    @Step("Нажатие на '{elementName}'")
    fun clickToElement(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            elementName: String,
            findElementWithOutCatching: Boolean = false
    ) {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second, findElementWithOutCatching)
        element.click()
    }

    // функция вствки текста
    @Step("Ввод текста '{text}' в поле '{elementName}'")
    fun sendText(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            text: String,
            elementName: String,
            findElementWithOutCatching: Boolean = false) {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second, findElementWithOutCatching)
        if (findProperty.second == locatorTypeIOS) {
            for (char in text.toCharArray()) {
                element.sendKeys(char.toString())
            }
        } else
            element.sendKeys(text)
    }

    //функция отчитки поля
    @Step("Отчистка элемента '{elementName}'")
    fun clearField(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            elementName: String,
            findElementWithOutCatching: Boolean = false
    ) {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second, findElementWithOutCatching)
        element.clear()
    }

    // функция поиска атрибута
    @Step("Поиск атрибута '{attribute}' у элемента '{elementName}'")
    fun getAttribute(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            elementName: String,
            attribute: String): String {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second)
        return element.getAttribute(attribute)
    }

    //функция проверки наличия элемента
    @Step("Проверка наличия элемента '{elementName}'")
    fun checkAvailableElement(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            elementName: String,
            findElementWithOutCatching: Boolean = false
    ): Boolean {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second, findElementWithOutCatching)
        return element.isEnabled
    }

    //Тап по координатам на экране
    @Step("Тап по координатам х:{cordX} у:{cordY} на экране")
    fun tapByCoordinates(cordX: Int, cordY: Int) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val actions = Sequence(finger, 1)
        actions.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), cordX, cordY))
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
        if (platformType == TypeOS.ANDROID) {
            androidDriver.perform(listOf(actions))
        } else {
            iosDriver.perform(listOf(actions))
        }
    }

    //Позволяет сделать свайп по экрану. Нужно ввести координаты начала и окончания свайпа.
    @Step("свайп по экрану с х:{startCordX} у:{startCordY} до х:{moveCordX} у:{moveCordY} ")
    fun swipeOnScreen(startCordX: Int, startCordY: Int, moveCordX: Int, moveCordY: Int) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val actions = Sequence(finger, 1)
        actions.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), startCordX, startCordY))
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(Pause(finger, ofMillis(600)))
        actions.addAction(finger.createPointerMove(ofMillis(1000), PointerInput.Origin.viewport(), moveCordX, moveCordY))
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
        if (platformType == TypeOS.ANDROID) {
            androidDriver.perform(listOf(actions))
        } else {
            iosDriver.perform(listOf(actions))
        }
    }

    // поиск элемента на странице
    private fun findElement(
            locator: String,
            locatorType: LocatorType,
            findElementWithOutCatching: Boolean = false
    ): WebElement {
        lateinit var element: WebElement
        if (findElementWithOutCatching) {
            when (locatorType) {
                LocatorType.ID -> {
                    element = if (platformType == TypeOS.ANDROID) {
                        androidDriver.findElement(AppiumBy.id(locator))
                    } else iosDriver.findElement(AppiumBy.id(locator))
                }

                LocatorType.XPATH -> {
                    element = if (platformType == TypeOS.ANDROID) {
                        androidDriver.findElement(AppiumBy.xpath(locator))
                    } else iosDriver.findElement(AppiumBy.xpath(locator))
                }

                LocatorType.ACCESSIBILITY_ID -> {
                    element = if (platformType == TypeOS.ANDROID) {
                        androidDriver.findElement(AppiumBy.accessibilityId(locator))
                    } else iosDriver.findElement(AppiumBy.accessibilityId(locator))
                }

                LocatorType.CLASS_NAME -> element = androidDriver.findElement(AppiumBy.className(locator))

                LocatorType.IOS_CLASS_CHAIN -> element = iosDriver.findElement(AppiumBy.iOSClassChain(locator))
                LocatorType.IOS_PREDICATE_STRING -> element =
                        iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))

                else -> {}
            }
        } else {
            runCatching {
                when (locatorType) {
                    LocatorType.ID -> {
                        element = if (platformType == TypeOS.ANDROID) {
                            androidDriver.findElement(AppiumBy.id(locator))
                        } else iosDriver.findElement(AppiumBy.id(locator))
                    }

                    LocatorType.XPATH -> {
                        element = if (platformType == TypeOS.ANDROID) {
                            androidDriver.findElement(AppiumBy.xpath(locator))
                        } else iosDriver.findElement(AppiumBy.xpath(locator))
                    }

                    LocatorType.ACCESSIBILITY_ID -> {
                        element = if (platformType == TypeOS.ANDROID) {
                            androidDriver.findElement(AppiumBy.accessibilityId(locator))
                        } else iosDriver.findElement(AppiumBy.accessibilityId(locator))
                    }

                    LocatorType.CLASS_NAME -> element = androidDriver.findElement(AppiumBy.className(locator))
                    LocatorType.IOS_CLASS_CHAIN -> element = iosDriver.findElement(AppiumBy.iOSClassChain(locator))
                    LocatorType.IOS_PREDICATE_STRING -> element =
                            iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))

                    else -> {}

                }
            }.onSuccess {

            }.onFailure {
                makeScreenshotOfScreen(Date().toString())
                org.testng.Assert.fail("Элемент не был найден по локатору - $locator")
            }
        }
        return element
    }

    // свайп по элемнту влево
    @Step("свайп влево по элементу '{elementName}'")
    fun swipeScreenLeft(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            elementName: String,
            findElementWithOutCatching: Boolean = false
    ) {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second, findElementWithOutCatching)
        val size = element.size
        val location = element.location
        // Вычисление начальных и конечных координат свайпа
        val startX = location.x + size.width
        val startY = location.y + size.height / 2
        val endX = 0
        val endY = startY
        swipeOnScreen(startX, startY, endX, endY)
    }

    // свайп по элемнту вниз
    @Step("свайп вниз по элементу '{elementName}'")
    fun swipeElementDown(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            elementName: String,
            findElementWithOutCatching: Boolean = false
    ) {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second, findElementWithOutCatching)
        val size = element.size
        val location = element.location
        // Вычисление начальных и конечных координат свайпа
        val startX = location.x + size.width / 2
        val startY = location.y
        val endX = startX
        val endY = location.y + size.height
        swipeOnScreen(startX, startY, endX, endY)
    }

    // тап по элементу
    @Step("Тап по элементу '{elementName}'")
    fun tapByElement(locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        val size = element.size
        val location = element.location
        tapByCoordinates(location.x + (size.width / 2), location.y + (size.height / 2))
    }

    // найти координаты элемента
    @Step("Найти координаты элемента '{'elementName}'")
    fun findCoordinates(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            elementName: String,
            findElementWithOutCatching: Boolean = false
    ): Point {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second, findElementWithOutCatching)
        return element.location
    }

    // найти ширину экрана
    @Step("Найти ширину экрана")
    fun findWidthScreen(): Int {
        if (platformType == TypeOS.ANDROID) {
            return androidDriver.manage().window().size.getWidth()
        } else {
            return iosDriver.manage().window().size.getWidth()
        }
    }

    // найти размеры элемента
    @Step("Найти размеры элемента '{elementName}'")
    fun findSizeElement(locatorAndroid: String,
                        locatorTypeAndroid: LocatorType,
                        locatorIOS: String,
                        locatorTypeIOS: LocatorType,
                        elementName: String,
                        findElementWithOutCatching: Boolean = false
    ): Dimension {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second, findElementWithOutCatching)
        return element.size
    }

    @Attachment(value = "Screenshot - {dateOnSystem}", type = "image/png")
    fun makeScreenshotOfScreen(dateOnSystem: String?): ByteArray {
        return if (platformType == TypeOS.IOS) {
            (iosDriver as TakesScreenshot?)!!.getScreenshotAs(OutputType.BYTES)
        } else (androidDriver as TakesScreenshot?)!!.getScreenshotAs(OutputType.BYTES)

    }

}