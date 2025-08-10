package org.jhaard.memorygame


import com.russhwolf.settings.Settings
import io.ktor.client.HttpClient
import org.jhaard.memorygame.apiServices.ImageApiService
import org.jhaard.memorygame.gameService.GameService
import org.jhaard.memorygame.httpClient.createHttpClient
import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.viewModels.GameViewModel
import org.jhaard.memorygame.viewModels.StartViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory
import org.kodein.di.instance
import org.kodein.di.singleton

/**
 * DI-Container med Kodein.
 */
fun createAppDI(platform: DI.Module? = null) = DI {
    platform?.let { import(it) }

    bind<HttpClient>() with singleton { createHttpClient() }
    bind<ImageApiService>() with singleton { ImageApiService(instance()) }

    bind<Settings>() with singleton { Settings() }
    bind<SettingsRepository>() with singleton { SettingsRepository(instance()) }

    bind<GameService>() with singleton { GameService(instance()) }

    bind<StartViewModel>() with singleton { StartViewModel(instance(), instance()) }
    bind<GameViewModel>() with factory { GameViewModel(instance(), instance()) }

}
