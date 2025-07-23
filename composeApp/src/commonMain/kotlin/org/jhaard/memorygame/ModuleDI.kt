package org.jhaard.memorygame

import io.ktor.client.HttpClient
import org.jhaard.memorygame.gameLogic.GameLogic
import org.jhaard.memorygame.httpClient.createHttpClient
import org.jhaard.memorygame.viewModels.GameViewModel

/**
 * Dependency container for certain single instances.
 */
object ModuleDI {

    private val client: HttpClient = createHttpClient()

    private val gameLogic: GameLogic = GameLogic()

    val gameViewModel = GameViewModel(gameLogic)

}