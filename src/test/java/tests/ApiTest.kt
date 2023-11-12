package tests

import api_client.environment.Environment.environment
import api_client.environment.Environment.updateAuthToken
import api_client.environment.Environment.updateSessionId
import api_client.requests.auth.AuthResetCode
import api_client.requests.auth.Login
import api_client.requests.categories.Categories
import api_client.requests.categories.Meals
import api_client.requests.categories.User
import api_client.specifications.Specifications.installSpecification
import api_client.specifications.Specifications.requestSpec
import org.testng.annotations.Test

class ApiTest {

    @Test
    fun apiTest() {
        installSpecification(requestSpec(environment.host))
        // Запрос sessionID
        User.get(mutableMapOf())
        // Изменение параметра sesseionId в окружении
        updateSessionId(User.resBody)
        // запрос списка категорий
        Categories.get(mutableMapOf())
        // запрос кода авторизации
        AuthResetCode.post(AuthResetCode.authResetCodeReqBody("79510556586"))
        // запрос токена
        Login.post(Login.loginReqBody("79510556586", "3256"))
        // изменение токена в окружении
        updateAuthToken(Login.resBody)
        // запрос меню с главной страницы
        Meals.get(mutableMapOf())
        //Profile.get(mutableMapOf())
    }
}