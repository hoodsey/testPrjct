import GlobalVarible.androidDriver
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit


class MainActivity {

    @BeforeSuite
    fun InstallDriver() {

        val capabilities = DesiredCapabilities()

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Andorid")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel")
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/admin/apps/app-profile.apk")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2")
        //capabilites.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "starter.school.client")
        //capabilites.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "starter.school.client.MainActivity")

        val url = URL("http://127.0.0.1:4723/")

        androidDriver = AndroidDriver(url, capabilities)

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1))

        // обработка ошибок при прокликиваинии элементов в сценарии атворизации по номеру +7 951 055 65 86
        try {
            val element1 = androidDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Русский\"]"))
            element1.click()

            val element2 = androidDriver.findElement(AppiumBy.accessibilityId("Далее"))
            element2.click()

            TimeUnit.SECONDS.sleep(5)

            val element3 = androidDriver.findElement(AppiumBy.accessibilityId("Закрыть"))
            element3.click()

            val element4 = androidDriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]"))
            element4.click()

            val element6 = androidDriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]"))
            element6.click()

            val element7 = androidDriver.findElement(AppiumBy.accessibilityId("Войти"))
            element7.click()

            val element8 = androidDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Укажите телефон\n" + "На него отправим код подтверждения\"]/android.widget.EditText"))
            element8.sendKeys("9510556586")

            val element9 = androidDriver.findElement(AppiumBy.accessibilityId("Получить код"))
            element9.click()

            TimeUnit.SECONDS.sleep(5)
            val element10 = androidDriver.findElement(AppiumBy.xpath("//*[starts-with(@content-desc,'Введите код из смс')]"))


            val fullXPath = element10.getAttribute("content-desc")
            //println("Вывод" + fullXPath)

            val substringAfterLast = fullXPath.substringAfterLast("смс\n")

            val element11 = androidDriver.findElement(AppiumBy.className("android.widget.EditText"))
            element11.sendKeys(substringAfterLast)

            // тест с ошибкой при поиске по resource-id
            val element5 = androidDriver.findElement(AppiumBy.id("Fail resource-id"))
            element5.click()


        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace() // распечатываем ошибку в консоль
            println("Мы поймали ошибку, и теперь тест не упадет")

        }
        /*
        val text = androidDriver.pageSource()
        */
        TimeUnit.SECONDS.sleep(10)

    }

    @AfterSuite
    fun quiDriver() {
        androidDriver.quit()
    }

    @Test
    fun testOne() {
        println("Тест запущен")
        TimeUnit.SECONDS.sleep(10)
    }
}