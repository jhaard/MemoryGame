package org.jhaard.memorygame


import com.russhwolf.settings.Settings
import io.ktor.client.HttpClient
import org.jhaard.memorygame.apiServices.ImageApiService
import org.jhaard.memorygame.httpClient.createHttpClient
import org.jhaard.memorygame.localStorage.SettingsRepository
import org.jhaard.memorygame.services.AudioService
import org.jhaard.memorygame.services.GameService
import org.jhaard.memorygame.services.TimerService
import org.jhaard.memorygame.viewModels.GameViewModel
import org.jhaard.memorygame.viewModels.StartViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.bindSingleton
import org.kodein.di.factory
import org.kodein.di.instance

/**
 * DI-Container med Kodein.
 */
fun createAppDI(platform: DI.Module? = null) = DI {
    platform?.let { import(it) }

    bindSingleton<HttpClient> { createHttpClient() }
    bindSingleton<ImageApiService> { ImageApiService(instance()) }

    bindSingleton<Settings> { Settings() }
    bindSingleton<SettingsRepository> { SettingsRepository(instance()) }

    bindSingleton<GameService> { GameService(instance()) }
    bindSingleton<AudioService> { AudioService(instance()) }
    bindSingleton<TimerService> { TimerService() }

    bindSingleton<StartViewModel> { StartViewModel(instance(), instance()) }
    bind<GameViewModel>() with factory { GameViewModel(instance(), instance(), instance()) }

}
