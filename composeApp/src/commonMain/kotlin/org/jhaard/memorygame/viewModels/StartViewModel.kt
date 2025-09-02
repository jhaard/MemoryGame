package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.jhaard.memorygame.repositories.StartRepository

/**
 * The viewModel for the StartScreen, loading the images from the api.
 *
 * @param startRepository The repository for fetching images.
 */
class StartViewModel(
    private val startRepository: StartRepository
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

            startRepository.fetchImages(key = key)

            _isLoading.value = false
        }
    }


}