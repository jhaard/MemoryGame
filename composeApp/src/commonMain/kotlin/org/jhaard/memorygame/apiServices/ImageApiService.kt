package org.jhaard.memorygame.apiServices

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import org.jhaard.memorygame.httpClient.createHttpClient
import org.jhaard.memorygame.models.iconImageModels.IconImageResponse
import org.jhaard.memorygame.models.values.StringValues

/**
 * Fetching icons to the memory tiles from proxy server url.
 *
 * @param client The HTTP-client created directly since this project only will use one service class.
 */
class ImageApiService(private val client: HttpClient = createHttpClient()) {

    suspend fun getImageIcons(key: String): IconImageResponse {

        val url: String = StringValues.BASE_URL + StringValues.QUERY_ADDITION + key

        return try {
            val response = client.get(url) {
                method = HttpMethod.Get
                contentType(ContentType.Application.Json)
            }

            response.body()

        } catch (e: Exception) {
            println("Error fetching IconImageResponse: ${e.message}")
            IconImageResponse(emptyList())
        }
    }

}