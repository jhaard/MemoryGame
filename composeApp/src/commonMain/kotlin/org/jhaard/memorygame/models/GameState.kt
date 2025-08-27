package org.jhaard.memorygame.models

sealed class GameState {
    data object Initial : GameState()

    data class Playing(
        val timer: Int,
        val score: Int,
        val currentScore: Int,
        val clickCount: Int
    ) : GameState()

    data class GameOver(
        val score: Int
    ) : GameState()

    data class Error(
        val message: String
    ) : GameState()
}