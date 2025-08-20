package org.jhaard.memorygame.navigation


/**
 * The different screens of the game.
 *
 * @param route The string route to navigate to.
 */
sealed class Screens(val route: String) {
    data object StartScreen: Screens("start_screen")
    data object GameScreen: Screens("game_screen")

    fun withArguments(vararg args: String): String {
        val argRoute = buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
        return argRoute
    }
}