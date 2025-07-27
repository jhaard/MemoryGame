package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jhaard.memorygame.apiServices.ImageApiService

/**
 * The viewModel for the StartScreen, loading the images from the api.
 *
 * @param imageApiService The class for fetching images.
 */
class StartViewModel(private val imageApiService: ImageApiService) : ViewModel() {

    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> = _isLoading


    fun fetchImages() {
        viewModelScope.launch {
            _isLoading.value = true

            val imageResponse = imageApiService.getImageIcons("cat")
            println("Testing fetch from viewmodel: $imageResponse")

            _isLoading.value = false
        }
    }
}