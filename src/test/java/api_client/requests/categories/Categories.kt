package api_client.requests.categories

import ResponseType
import api_client.Get
import api_client.Res
import api_client.environment.Environment.endPoints
import api_client.pojo.categories.CategoriesPojo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.restassured.response.Response

object Categories : Get, Res, CategoriesPojo() {
    override lateinit var resBody: List<CategoriesRes>

    override fun getDataFromJSON(response: Response): List<CategoriesRes> {
        val jsonString = response.asString()
        val gson = Gson()
        val itemType = object : TypeToken<List<CategoriesRes>>() {}.type
        return gson.fromJson(jsonString, itemType)
    }

    override fun get(queryParams: MutableMap<String, String>) {
        val responseJSON = getReq(
                queryParams = queryParams,
                endPoint = endPoints.categories,
                responseType = ResponseType.JSON
        )
        resBody = getDataFromJSON(responseJSON)
    }

}