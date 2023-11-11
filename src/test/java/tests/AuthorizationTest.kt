package tests

import MainActivity
import api_client.environment.Environment.environment
import api_client.requests.auth.AuthResetCode
import api_client.requests.auth.AuthResetCode.authResetCodeReqBody
import api_client.specifications.Specifications.installSpecification
import api_client.specifications.Specifications.requestSpec
import org.testng.annotations.Test

class AuthorizationTest : MainActivity() {

    @Test
    fun authorizationTest() {
        installSpecification(requestSpec(environment.host))

        //Categories.get(mutableMapOf())


        AuthResetCode.post( authResetCodeReqBody("79510556586"))


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