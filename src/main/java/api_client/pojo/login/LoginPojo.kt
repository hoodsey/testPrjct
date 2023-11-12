package api_client.pojo.login

open class LoginPojo {
    data class LoginReqBody(
            val phone: String,
            val code: String,
    )
}