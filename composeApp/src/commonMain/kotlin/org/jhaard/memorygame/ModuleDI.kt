package org.jhaard.memorygame

import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.viewModels.GameViewModel

object ModuleDI {

    private val gameLogic: GameLogic = GameLogic()

    val gameViewModel = GameViewModel(gameLogic)

}