package network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class CategoriesResponse(
    @SerialName("categories")
    var categories: List<CategoryResponse> = arrayListOf(),
)

@Serializable
data class CategoryResponse(
    @SerialName("idCategory")
    var id: String = "",
    @SerialName("strCategory")
    var title: String = "",
    @SerialName("strCategoryThumb")
    var image: String = "",
    @SerialName("strCategoryDescription")
    var description: String = ""
)