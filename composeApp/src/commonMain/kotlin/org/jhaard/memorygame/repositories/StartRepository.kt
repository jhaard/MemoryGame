package org.jhaard.memorygame.repositories

import org.jhaard.memorygame.apiServices.ImageApiService
import org.jhaard.memorygame.localStorage.SettingsRepository

class StartRepository(
    private val imageApiService: ImageApiService,
    private val localStorage: SettingsRepository
) {

    /**
     * Fetching the images from API proxy server with a key word.
     * @param key The key to search for.
     */
    suspend fun fetchImages(key: String) {
        if (localStorage.getUrlList(key).isEmpty()) {
            println("HEEEEEEJ")

            val imageResponse = imageApiService.getImageIcons(key = key)

            if (imageResponse.icons != null) {

                val sizeFormats = imageResponse.icons
                    .flatMap { it.rasterSizes!! }

                val sizes = sizeFormats.filter { it.size == 64 }

                val previews = sizes
                    .flatMap { it.formats!! }

                val imageUrls = previews.map { it.previewUrl }

                localStorage.saveUrlList(key, imageUrls)

            }

        }
    }


}