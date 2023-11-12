package api_client.pojo.Meals

import com.google.gson.annotations.SerializedName

open class MealsPojo {
    data class MealsRes(
            @SerializedName("name") var name: String? = null,
            @SerializedName("status") var status: String? = null,
            @SerializedName("code") var code: String? = null,
            @SerializedName("sortIndex") var sortIndex: Int? = null,
            @SerializedName("description") var description: String? = null,
            @SerializedName("calories") var calories: Int? = null,
            @SerializedName("carbohydrate") var carbohydrate: Int? = null,
            @SerializedName("fat") var fat: Int? = null,
            @SerializedName("fiber") var fiber: Int? = null,
            @SerializedName("ingredients") var ingredients: ArrayList<String> = arrayListOf(),
            @SerializedName("categories") var categories: ArrayList<String> = arrayListOf(),
            @SerializedName("weight") var weight: Int? = null,
            @SerializedName("volume") var volume: Int? = null,
            @SerializedName("price") var price: Int? = null,
            @SerializedName("quantity") var quantity: Int? = null,
            @SerializedName("createdAt") var createdAt: String? = null,
            @SerializedName("updatedAt") var updatedAt: String? = null,
            @SerializedName("images") var images: ArrayList<String> = arrayListOf(),
            @SerializedName("tags") var tags: ArrayList<String> = arrayListOf(),
            @SerializedName("deliveryRestrictions") var deliveryRestrictions: ArrayList<String> = arrayListOf(),
            @SerializedName("modifications") var modifications: ArrayList<Any> = arrayListOf(),
            @SerializedName("mainMeal") var mainMeal: Boolean? = null,
            @SerializedName("modificationValues") var modificationValues: ArrayList<Any> = arrayListOf(),
            @SerializedName("toppingGroups") var toppingGroups: ArrayList<Any> = arrayListOf(),
            @SerializedName("priceBeforeDiscount") var priceBeforeDiscount: Int? = null,
            @SerializedName("media") var media: ArrayList<String> = arrayListOf(),
            @SerializedName("descriptionRich") var descriptionRich: ArrayList<String> = arrayListOf(),
            @SerializedName("previewImage") var previewImage: String? = null,
            @SerializedName("minPrice") var minPrice: Int? = null
    )
}