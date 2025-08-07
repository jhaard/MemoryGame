package org.jhaard.memorygame.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import org.jhaard.memorygame.gameService.GameService
import kotlin.reflect.KClass


class NewGameViewModelFactory(private val param: GameService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
        @Suppress("UNCHECKED_CAST")
        return when {
            modelClass == GameViewModel::class -> GameViewModel(param) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")

        }
    }

}
