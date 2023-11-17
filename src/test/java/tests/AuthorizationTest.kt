package tests

import MainActivity
import TestFunctions.swipeOnScreen
import general_cases_for_tests.AuthorizationScenarios.authorizationApp
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import screens.MenuApps
import screens.Profile
import java.util.concurrent.TimeUnit

class AuthorizationTest : MainActivity() {

    @Test
    fun authorizationTest() {

        // проверка авторизации
        checkAuthorizationUser(false)
        val menuApps = MenuApps()
        val profile = Profile()
        // свайп на главной странице
        menuApps.selectCatalogButton()
        swipeOnScreen(457, 2074, 450, 375)
        // переход на вкладку меню
        menuApps.selectMenuButton()
        // переход в профиль и авторизация
        menuApps.selectProfileButton()
        profile.clickAuthorizationButton()
        authorizationApp("9510556586")
        TimeUnit.SECONDS.sleep(2)
        menuApps.selectCatalogButton()
    }
}



