package org.jhaard.memorygame

import org.jhaard.memorygame.viewModels.GameViewModel

object ModuleDI {

    val gameViewModel: GameViewModel by lazy {
        initGameViewModel()
    }

}

expect fun initGameViewModel(): GameViewModel