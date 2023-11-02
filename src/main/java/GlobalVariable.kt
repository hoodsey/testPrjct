import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver


object GlobalVariable {

    lateinit var androidDriver : AndroidDriver
    lateinit var platformType: TypeOS
    lateinit var iosDriver: IOSDriver

}