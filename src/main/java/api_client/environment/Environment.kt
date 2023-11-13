package api_client.environment

object Environment {


    // функция изменения sessionid
    fun updateSessionId(newSessionId: String) {
        environment = environment.copy(sessionId = newSessionId)
        headers["sessionid"] = newSessionId
    }
    fun updateAuthToken(newAuthToken: String) {
        environment = environment.copy(authToken = newAuthToken)
        headers["authToken"] = newAuthToken
    }

    var environment = Env()
    val endPoints = EndPoints()
    var headers: MutableMap<String,String> = mutableMapOf(
            "authority" to "api.starterapp.ru",
            "authorization" to environment.authToken,
            "sessionid" to environment.sessionId,
            "content-type" to "application/json",
            "accept" to "application/json",
            "lang" to "ru",
            "user-agent" to "IOS-device",
            "origin" to "https://school.starterapp.ru",
            "x-real-ip" to "91.197.192.54",
            "timezone" to "Europe/Moscow"
    )
    data class Env(
            var authToken: String = "",
            var sessionId: String = "3b6be154-2de4-460f-b81d-afafce0febd8",
            val host: String = "https://api.starterapp.ru/school/",
            val shopId: String = "8c65fc68-dfd9-4591-a8f2-9edf77fbd3fd"

    )

    data class EndPoints(
            val categories: String = "categories/8c65fc68-dfd9-4591-a8f2-9edf77fbd3fd/v2",
            val authCode: String  = "auth/resetCode",
            val login: String  = "auth/login",
            val sessionId: String  = "user/sessionId",
            val profile: String ="user/v2",
            val meals: String = "/meals/8c65fc68-dfd9-4591-a8f2-9edf77fbd3fd/v2"


    )

}