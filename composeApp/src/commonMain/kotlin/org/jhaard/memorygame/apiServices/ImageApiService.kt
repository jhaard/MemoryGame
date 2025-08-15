package org.jhaard.memorygame.apiServices

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.jhaard.memorygame.models.iconImageModels.IconImageResponse
import org.jhaard.memorygame.models.values.StringValues

/**
 * Fetching icons to the memory tiles from proxy server url.
 *
 * @param client The HTTP-client created directly since this project only will use one service class.
 */
class ImageApiService(private val client: HttpClient) {

    /**
     * Get the icons from the proxy server and return the response.
     *
     * @param key The search-word added to the params.
     * @return The response body.
     *
     * TODO Handle exceptions.
     */
    suspend fun getImageIcons(key: String): IconImageResponse {

        val url: String = StringValues.BASE_URL + StringValues.QUERY_ADDITION + key

        return try {
            val response = client.get(url)

            response.body()

        } catch (e: Exception) {
            println("Error fetching IconImageResponse: ${e.message}")
            IconImageResponse(emptyList())
        }
    }

}