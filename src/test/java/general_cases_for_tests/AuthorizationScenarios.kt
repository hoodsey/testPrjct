package general_cases_for_tests

import GlobalVariable.platformType
import TypeOS
import screens.Authorization
import screens.MenuApps
import screens.Profile
import java.util.concurrent.TimeUnit


object AuthorizationScenarios {
    //функция проверяет наличие авторизации
    fun checkAuthorizationUser(needAuthorizationUser: Boolean) {

        val menuApps = MenuApps()
        val profile = Profile()
        //переход в профиль
        menuApps.selectProfileButton()
        var userIsAuthorization: Boolean
        // проверка наличия кноки выход
        try {
            userIsAuthorization = profile.checkQuitButton()
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false
        }
        when {
            // нужна авторизация и есть кнопка выйти в профиле(авторизован)
            needAuthorizationUser && userIsAuthorization -> {
                menuApps.selectMenuButton()
            }
            //нужна авторизация и кнопке выйти нет(неавторизован)  -> авторизация + переход к каталогу
            needAuthorizationUser && !userIsAuthorization -> {
                profile.clickAuthorizationButton()
                authorizationApp("9510556586")
                menuApps.selectCatalogButton()
            }
            //не нужна авторизация, но есть кнопка выйти в профиле(авторизован) -> клик по кнопке выйти
            !needAuthorizationUser && userIsAuthorization -> {
                profile.clickQuietButton()
                menuApps.selectCatalogButton()
            }
            //не нужна авторизация и не авторизован
            !needAuthorizationUser && !userIsAuthorization -> {
                menuApps.selectCatalogButton()
            }
        }
    }

    // авторизация по номеру телефона
    fun authorizationApp(phone: String) {

        val auth = Authorization()
        // ввод номера телефона
        auth.sendPhone(phone)
        // нажать кнопку получения кода авторизации
        auth.clickToSendCodeButton()
        var codeAuth = "";
        //поиск элемента с кодом по атрибуту и обрезка кода
        when (platformType) {
            TypeOS.IOS -> {
                codeAuth = auth.getAttributeCodeAuthElement("name").substringAfterLast("смс\n").substringBefore("\n+7")
            }

            TypeOS.ANDROID -> {
                codeAuth = auth.getAttributeCodeAuthElement("content-desc").substringAfterLast("смс\n").substringBefore("\n+7")
            }
        }
        // вставка кода
        TimeUnit.SECONDS.sleep(2)
        auth.codeInsert(codeAuth)
    }
}