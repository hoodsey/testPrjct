package api_client.requests.categories

import ResponseType
import api_client.Get
import api_client.Res
import api_client.environment.Environment.endPoints
import api_client.pojo.Meals.MealsPojo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.restassured.response.Response

object Meals: Get, Res,MealsPojo() {
    override lateinit var resBody: List<MealsRes>

    override fun getDataFromJSON(response: Response): List<MealsRes> {
        val jsonString = response.asString()
        val gson = Gson()
        val itemType = object : TypeToken<List<MealsRes>>() {}.type
        return gson.fromJson(jsonString, itemType)
    }
    override fun get(queryParams: MutableMap<String, String>) {
        val responseJSON = getReq(
                queryParams = queryParams,
                endPoint = endPoints.meals,
                responseType = ResponseType.JSON
        )
        resBody = getDataFromJSON(responseJSON)
    }

}