package org.jhaard.memorygame

import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.viewModels.GameViewModel

object ModuleDI {

    val gameViewModel: GameViewModel by lazy {
        initGameViewModel()
    }
    val gameLogic: GameLogic = GameLogic()

}

expect fun initGameViewModel(): GameViewModel