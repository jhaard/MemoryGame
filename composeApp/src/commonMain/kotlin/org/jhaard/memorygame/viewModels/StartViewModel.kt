package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jhaard.memorygame.apiServices.ImageApiService
import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.services.AudioService

/**
 * The viewModel for the StartScreen, loading the images from the api.
 *
 * @param imageApiService The class for fetching images.
 * @param localStorage Saving the image urls locally.
 */
class StartViewModel(
    private val imageApiService: ImageApiService,
    private val localStorage: SettingsRepository,
    private val audioService: AudioService
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    /**
     * Fetching the images from API proxy server with a key word.
     * @param key The key to search for.
     */
    fun fetchImages(key: String) {
        viewModelScope.launch {
            _isLoading.value = true

            val imageResponse = imageApiService.getImageIcons(key = key)

            if (imageResponse.icons != null) {

                val sizeFormats = imageResponse.icons
                    .flatMap { it.rasterSizes!! }

                val sizes = sizeFormats.filter { it.size == 64 }

                val previews = sizes
                    .flatMap { it.formats!! }

                val imageUrls = previews.map { it.previewUrl }

                localStorage.saveUrlList(imageUrls)

            }
            _isLoading.value = false
        }

    }

    fun stopMusic() {
        audioService.stopBackgroundMusic()
    }
}