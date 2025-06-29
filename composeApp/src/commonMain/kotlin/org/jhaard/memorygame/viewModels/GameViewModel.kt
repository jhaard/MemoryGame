package org.jhaard.memorygame.viewModels

import org.jhaard.memorygame.gameLogic.GameLogic


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class GameViewModel(gameLogic: GameLogic) {
    fun printMessage(): String
}