package org.jhaard.memorygame


import org.jhaard.memorygame.apiServices.ImageApiService
import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.viewModels.GameViewModel
import org.jhaard.memorygame.viewModels.StartViewModel

/**
 * Container for instances.
 */
object ModuleDI {

    private val gameLogic: GameLogic = GameLogic()
    private val imageApiService: ImageApiService = ImageApiService()
    private val localStorage: SettingsRepository = SettingsRepository()

    val startViewModel =
        StartViewModel(imageApiService = imageApiService, localStorage = localStorage)
    val gameViewModel = GameViewModel(gameLogic = gameLogic, localStorage = localStorage)

}