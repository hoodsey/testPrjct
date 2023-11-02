import GlobalVariable.androidDriver
import GlobalVariable.iosDriver
import GlobalVariable.platformType
import io.appium.java_client.AppiumBy
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Pause
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.time.Duration.ofMillis

object TestFunctions {

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

    fun clickToElement(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType
    ) {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second)
        element.click()
    }
    /*   fun clickToElementForIndex(locator: String = "", locatorType: LocatorType, index: Int) {
           val elements: List<WebElement> = findElementsList(locator, locatorType)
           if (index < elements.size) {
               elements[index].click()
           }
       }*/

    fun sendText(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            text: String) {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second)
        if (findProperty.second == locatorTypeIOS) {
            for (char in text.toCharArray()) {
                element.sendKeys(char.toString())
            }
        } else
            element.sendKeys(text)
    }

    fun clearField(locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        element.clear()
    }

    fun getAttribute(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType,
            text: String): String {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second)
        println(findProperty.second)
        when (findProperty.second) {
           locatorTypeIOS -> {
               return element.getAttribute("name")
           }
           locatorTypeAndroid -> {
                return element.getAttribute("content-desc")
           }  else -> { return "" }
       }
    }

    fun checkAvailableElement(
            locatorAndroid: String,
            locatorTypeAndroid: LocatorType,
            locatorIOS: String,
            locatorTypeIOS: LocatorType
    ): Boolean {
        val findProperty = checkTypeOS(locatorAndroid, locatorTypeAndroid, locatorIOS, locatorTypeIOS)
        val element = findElement(findProperty.first, findProperty.second)
        return element.isEnabled
    }

    //Тап по координатам на экране
    fun tapByCoordinates(cordX: Int, cordY: Int) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val actions = Sequence(finger, 1)
        actions.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), cordX, cordY))
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
        androidDriver.perform(listOf(actions))
    }

    //Позволяет сделать свайп по экрану. Нужно ввести координаты начала и окончания свайпа.
    fun swipeOnScreen(startCordX: Int, startCordY: Int, moveCordX: Int, moveCordY: Int) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val actions = Sequence(finger, 1)
        actions.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), startCordX, startCordY))
        actions.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        actions.addAction(Pause(finger, ofMillis(600)))
        actions.addAction(finger.createPointerMove(ofMillis(1000), PointerInput.Origin.viewport(), moveCordX, moveCordY))
        actions.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
        androidDriver.perform(listOf(actions))
    }


    private fun findElement(locator: String, locatorType: LocatorType): WebElement {
        return when (locatorType) {
            LocatorType.ID ->
                if (platformType == TypeOS.ANDROID) {
                    androidDriver.findElement(AppiumBy.id(locator))
                } else iosDriver.findElement(AppiumBy.id(locator))

            LocatorType.XPATH ->
                if (platformType == TypeOS.ANDROID) {
                    androidDriver.findElement(AppiumBy.xpath(locator))
                } else iosDriver.findElement(AppiumBy.xpath(locator))

            LocatorType.ACCESSIBILITY_ID ->
                if (platformType == TypeOS.ANDROID) {
                    androidDriver.findElement(AppiumBy.accessibilityId(locator))
                } else iosDriver.findElement(AppiumBy.accessibilityId(locator))

            LocatorType.CLASS_NAME -> androidDriver.findElement(AppiumBy.className(locator))

            LocatorType.IOS_CLASS_CHAIN -> iosDriver.findElement(AppiumBy.iOSClassChain(locator))
            LocatorType.IOS_PREDICATE_STRING -> iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))

        }
    }
    /*  private fun findElementsList(locator: String, locatorType: LocatorType):  List<WebElement> {
          return when (locatorType) {
              LocatorType.ID -> androidDriver.findElements(AppiumBy.id(locator))
              LocatorType.XPATH -> androidDriver.findElements(AppiumBy.xpath(locator))
              LocatorType.ACCESSIBILITY_ID -> androidDriver.findElements(AppiumBy.accessibilityId(locator))
              LocatorType.CLASS_NAME -> androidDriver.findElements(AppiumBy.className(locator))
          }
      }*/

    fun swipeScreenLeft(locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        val size = element.size
        val location = element.location
        // Вычисление начальных и конечных координат свайпа
        val startX = location.x + size.width
        val startY = location.y + size.height / 2
        val endX = 0
        val endY = startY
        swipeOnScreen(startX, startY, endX, endY)
    }

    fun swipeElementDown(locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        val size = element.size
        val location = element.location
        // Вычисление начальных и конечных координат свайпа
        val startX = location.x + size.width / 2
        val startY = location.y
        val endX = startX
        val endY = location.y + size.height
        swipeOnScreen(startX, startY, endX, endY)
    }

    fun tapByElement(locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        val size = element.size
        val location = element.location
        tapByCoordinates(location.x + (size.width / 2), location.y + (size.height / 2))
    }

    fun findCoordinates(locator: String, locatorType: LocatorType): Point {
        val element = findElement(locator, locatorType)
        return element.location
    }

    fun findWidthScreen(): Int {
        return androidDriver.manage().window().size.getWidth()
    }

    fun findSizeElement(locator: String, locatorType: LocatorType): Dimension {
        val element = findElement(locator, locatorType)
        return element.size
    }

}