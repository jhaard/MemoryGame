package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import org.jhaard.memorygame.gameLogic.GameLogic


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class GameViewModel actual constructor(private val gameLogic: GameLogic) : ViewModel() {
    actual fun printMessage(): String {
        return gameLogic.printAnotherMessage()
    }

}