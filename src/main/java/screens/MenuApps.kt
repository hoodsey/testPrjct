package screens

object MenuApps {
    val selectCatalogButton = ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]",
            elementName = "Переход по кнопке на вкладку выбора блюд"
    )

    val selectMenuButton = ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]",
            elementName = "Переход по кнопке на вкладку меню"
    )
    val selectProfileButton = ScreenConstructor(
            androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]",
            elementName = "Переход по кнопке в профиль"
    )

}