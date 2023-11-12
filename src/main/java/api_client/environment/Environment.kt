package api_client.environment

object Environment {

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
            var sessionId: String = "6f9da34e-85c3-46f5-a9c5-65422f2f2e97",
            val host: String = "https://api.starterapp.ru/school/",
            val shopId: String = "8c65fc68-dfd9-4591-a8f2-9edf77fbd3fd"

    )

    data class EndPoints(
            val categories: String = "categories/8c65fc68-dfd9-4591-a8f2-9edf77fbd3fd/v2",
            val authCode: String  = "auth/resetCode",
            val login: String  = "auth/login",
            val sessionId: String  = "user/sessionId",


    )
}