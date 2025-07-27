package org.jhaard.memorygame


import org.jhaard.memorygame.apiServices.ImageApiService
import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.viewModels.GameViewModel
import org.jhaard.memorygame.viewModels.StartViewModel

/**
 * Dependency container for certain single instances.
 */
object ModuleDI {

    private val gameLogic: GameLogic = GameLogic()
    private val imageApiService: ImageApiService = ImageApiService()

    val startViewModel = StartViewModel(imageApiService = imageApiService)
    val gameViewModel = GameViewModel(gameLogic = gameLogic)

}