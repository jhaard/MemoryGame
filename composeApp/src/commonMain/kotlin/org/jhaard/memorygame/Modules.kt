package org.jhaard.memorygame


import org.jhaard.memorygame.apiServices.ImageApiService
import org.jhaard.memorygame.gameService.GameService
import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.viewModels.StartViewModel

/**
 * Container for instances.
 */
sealed class Modules {

    companion object {

        private val imageApiService by lazy { ImageApiService() }
        private val localStorage by lazy { SettingsRepository() }

        val gameService by lazy { GameService(localStorage = localStorage) }

        fun startViewModel() =
            StartViewModel(imageApiService = imageApiService, localStorage = localStorage)

    }

}
