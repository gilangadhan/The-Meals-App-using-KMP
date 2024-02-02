package network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class MealsResponse (

    @SerialName("meals")
    var meals: ArrayList<MealResponse> = arrayListOf()
)

@Serializable
data class MealResponse (
    @SerialName("strMeal")
    var title: String = "",
    @SerialName("strMealThumb")
    var image: String = "",
    @SerialName("idMeal")
    var id: String = ""
)