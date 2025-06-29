package org.jhaard.memorygame.viewModels

import org.jhaard.memorygame.gameLogic.GameLogic


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class GameViewModel actual constructor(private val gameLogic: GameLogic) {
    actual fun printMessage(): String {
       return gameLogic.printAnotherMessage()
    }
}