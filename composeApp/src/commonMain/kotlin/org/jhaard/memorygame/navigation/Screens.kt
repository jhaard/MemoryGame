package org.jhaard.memorygame.navigation


/**
 * The different screens of the game.
 *
 * @param route The string route to navigate to.
 */
open class Screens(val route: String) {
    object StartScreen: Screens("start_screen")
    object GameScreen: Screens("game_screen")
}