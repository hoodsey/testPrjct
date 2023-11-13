package api_client.pojo.profile

import com.google.gson.annotations.SerializedName

open class ProfilePojo {
    //описаны объекты для проверки ответа
    data class ProfileRes(
            @SerializedName("name") var name: String? = null,
            @SerializedName("phone") var phone: String? = null,
            @SerializedName("session") var session: String? = null,
            @SerializedName("phoneStatus") var phoneStatus: String? = null,
            @SerializedName("bonuses") var bonuses: Int? = null,
            @SerializedName("instagram") var instagram: String? = null,
            @SerializedName("email") var email: String? = null,
            @SerializedName("birthDate") var birthDate: String? = null,
            @SerializedName("bonusCardCode") var bonusCardCode: String? = null,
            //@SerializedName("order") var order: ArrayList<Any> = arrayListOf(),
            @SerializedName("addresses") var addresses: ArrayList<Any> = arrayListOf(),
            @SerializedName("wallet") var wallet:  ArrayList<Any> = arrayListOf(),
            @SerializedName("bonusProgram") var bonusProgram: String? = null
    )
}