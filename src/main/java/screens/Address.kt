package screens

object Address {
    val addAddressButton = ScreenConstructor(
            androidAccessibilityId = "Добавить новый адрес",
            iosAccessibilityId = "Добавить новый адрес",
            elementName = "Кнопка добавления нового адреса"
    )
   val insertAddress = ScreenConstructor(
           androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.widget.EditText",
           iosAccessibilityId = "Адрес",
           elementName = "Форма вствки нового адреса"
    )
    val insertNewAddress = ScreenConstructor(
            androidAccessibilityId = "Виленский переулок, 6, Санкт-Петербург",
           iosAccessibilityId = "Виленский переулок, 6, Санкт-Петербург",
            elementName = "Кнопка добавления нового адреса"
    )
    val insertFlat = ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]" ,
            iosAccessibilityId = "Квартира",
            elementName = "Поле ввода квартиры"
    )
    val insertEntrance= ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]",
            iosAccessibilityId = "Подъезд",
            elementName = "Поле ввода подъезда"
    )
    val insertIntercom = ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]",
            iosAccessibilityId = "Домофон",
            elementName = "Поле ввода домофона"
    )
    val insertFloor = ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]",
            iosAccessibilityId = "Этаж",
            elementName = "Поле ввода квартиры"
    )
    val insertComment = ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[5]",
            iosAccessibilityId = "Комментарий для курьера",
            elementName = "Поле ввода коментария к адресу"
    )
    val saveNewAddress = ScreenConstructor(
            androidAccessibilityId = "Сохранить",
            iosAccessibilityId = "Сохранить",
            elementName = "Кнопка сохранить адрес"
    )
    val ViewNewAddress = ScreenConstructor(
            androidAccessibilityId = "Виленский переулок, 6\n" +
                    "кв 6, 6 подъезд, 6 этаж. Домофон: 6. 6",
            iosAccessibilityId = "Виленский переулок, 6\n" +
                    "кв 6, 6 подъезд, 6 этаж. Домофон: 6. 6",
            elementName = "Элемент с новым адресом"
    )

    val addressesView = ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View",
           iosClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView",
            elementName = "Окно Мои адреса"
    )
}