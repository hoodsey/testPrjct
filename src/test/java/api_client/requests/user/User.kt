package api_client.requests.categories

import ResponseType
import api_client.Get
import api_client.Res
import api_client.environment.Environment.endPoints
import api_client.pojo.user.UserPojo
import io.qameta.allure.Step
import io.restassured.response.Response

object User : Get, Res, UserPojo() {
    override lateinit var resBody: String

    override fun getDataFromJSON(response: Response): String {
        return response.body.asString()
    }
    @Step("Отправка запроса GET user/sessionId")
    override fun get(queryParams: MutableMap<String, String>) {
        val responseJSON = getReq(
                queryParams = queryParams,
                endPoint = endPoints.sessionId,
                responseType = ResponseType.HTML
        )
        resBody = getDataFromJSON(responseJSON)

    }

}