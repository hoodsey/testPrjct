package tests

import MainActivity
import api_client.environment.Environment.environment
import api_client.requests.auth.AuthResetCode
import api_client.requests.auth.AuthResetCode.authResetCodeReqBody
import api_client.requests.auth.Login
import api_client.requests.auth.Login.loginReqBody
import api_client.requests.categories.Categories
import api_client.requests.categories.User
import api_client.specifications.Specifications.installSpecification
import api_client.specifications.Specifications.requestSpec
import org.testng.annotations.Test

class AuthorizationTest : MainActivity() {

    @Test
    fun authorizationTest() {
        installSpecification(requestSpec(environment.host))

        Categories.get(mutableMapOf()) //  список категорий
        User.get(mutableMapOf()) // результат sessionID
        AuthResetCode.post( authResetCodeReqBody("79510556586"))
        Login.post(loginReqBody("79510556586","3256"))  // результат токен

        /*  // проверка авторизации
          chkAuthorizationUser(false)
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
          menuApps.selectCatalogButton()*/
    }
}