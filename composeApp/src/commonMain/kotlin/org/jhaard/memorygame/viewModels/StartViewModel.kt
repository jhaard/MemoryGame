package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jhaard.memorygame.apiServices.ImageApiService
import org.jhaard.memorygame.localStorage.SettingsRepository

/**
 * The viewModel for the StartScreen, loading the images from the api.
 *
 * @param imageApiService The class for fetching images.
 */
class StartViewModel(
    private val imageApiService: ImageApiService,
    private val localStorage: SettingsRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchImages() {
        viewModelScope.launch {
            _isLoading.value = true

            val imageResponse = imageApiService.getImageIcons("cat")

            if (imageResponse.icons != null) {
                val sizeFormats = imageResponse.icons
                    .flatMap { it.rasterSizes!! }

                val sizes = sizeFormats.filter { it.size == 48 }

                val previews = sizes
                    .flatMap { it.formats!! }

                val imageUrls = previews.map { it.previewUrl }

                localStorage.saveUrlList(imageUrls)

            }
            _isLoading.value = false
        }

    }
}