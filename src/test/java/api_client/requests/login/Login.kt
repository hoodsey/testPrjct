package api_client.requests.auth

import ResponseType
import api_client.Post
import api_client.Res
import api_client.environment.Environment.endPoints
import api_client.pojo.login.LoginPojo
import io.qameta.allure.Step
import io.restassured.response.Response

object Login : Post, Res, LoginPojo() {

    override lateinit var resBody: String

    override fun getDataFromJSON(response: Response): String {

        return response.body.asString()
    }

    // Создание body POST запроса
    fun loginReqBody(phone: String, code: String): LoginReqBody {
        Thread.sleep(3000);
        return LoginReqBody(phone = phone, code = code)
    }

    // отправка запроса POST
    @Step("Отправка запроса POST auth/login")
    override fun post(reqBody: Any) {
        val responseJSON = postReq(
                endPoint = endPoints.login,
                reqBody = reqBody,
                responseType = ResponseType.HTML
        )
        // перенос ответа по классам для дальнейшей обработки
        resBody = getDataFromJSON(responseJSON)
    }
}