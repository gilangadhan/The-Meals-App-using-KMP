package network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
class MealsAPI {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getCategories(): List<CategoryResponse> {
        val result: CategoriesResponse = httpClient.get("https://www.themealdb.com/api/json/v1/1/categories.php").body()
        return result.categories
    }
}