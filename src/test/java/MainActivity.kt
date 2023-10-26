
import GlobalVarible.androidDriver
import general_cases_for_tests.OnbordingScenarios.onboardingTest
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.*
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit

open class MainActivity {

    @BeforeSuite
    fun InstallDriver() {

        val capabilities = DesiredCapabilities()

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Andorid")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel")
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/admin/apps/app-profile.apk")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2")
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true)
        //capabilites.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "starter.school.client")
        //capabilites.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "starter.school.client.MainActivity")

        val url = URL("http://127.0.0.1:4723/")

        androidDriver = AndroidDriver(url, capabilities)

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6))
        onboardingTest()
    }


    @AfterSuite
    fun quiDriver() {
        androidDriver.quit()
    }

    @BeforeClass
    fun beforeClass() {

    }
    @AfterClass
    fun afterClass(){

    }
    @BeforeMethod
    fun launceApp(){
        androidDriver.activateApp(BUNDLE_ID)
        TimeUnit.SECONDS.sleep(10)


    }
    @AfterMethod
    fun clouseApp(){
        androidDriver.terminateApp(BUNDLE_ID)

    }

    companion object {
        const val BUNDLE_ID = "starter.school.client"
    }


}