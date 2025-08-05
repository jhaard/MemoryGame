package org.jhaard.memorygame


import org.jhaard.memorygame.apiServices.ImageApiService
import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.viewModels.GameViewModel
import org.jhaard.memorygame.viewModels.StartViewModel

/**
 * Container for instances.
 */
sealed class Modules {

    companion object {

        private val imageApiService by lazy { ImageApiService() }
        private val localStorage by lazy { SettingsRepository() }
        private val gameLogic by lazy { GameLogic(localStorage = localStorage) }

        fun startViewModel() =
            StartViewModel(imageApiService = imageApiService, localStorage = localStorage)


        fun gameViewModel() =
            GameViewModel(gameLogic = gameLogic)

    }

}
