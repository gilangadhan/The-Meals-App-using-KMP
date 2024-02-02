package network

import network.CategoriesResponse
import network.MealsAPI

class MealsSDK {
    private val api = MealsAPI()
    @Throws(Exception::class)
    suspend fun getCategories(): List<CategoryResponse> = api.getCategories()
}