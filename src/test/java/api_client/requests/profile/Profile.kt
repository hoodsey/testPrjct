package api_client.requests.categories

import ResponseType
import api_client.Get
import api_client.Res
import api_client.environment.Environment.endPoints
import api_client.pojo.profile.ProfilePojo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.restassured.response.Response

object Profile: Get, Res,ProfilePojo() {
    override lateinit var resBody: List<ProfileRes>

    override fun getDataFromJSON(response: Response): List<ProfileRes> {
        val jsonString = response.asString()
        val gson = Gson()
        val itemType = object : TypeToken<ProfileRes?>() {}.type
        return gson.fromJson(jsonString, itemType)
    }
    override fun get(queryParams: MutableMap<String, String>) {
        val responseJSON = getReq(
                queryParams = queryParams,
                endPoint = endPoints.profile,
                responseType = ResponseType.JSON
        )
        resBody = getDataFromJSON(responseJSON)
    }

}