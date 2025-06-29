package org.jhaard.memorygame

import org.jhaard.memorygame.viewModels.GameViewModel

actual fun initGameViewModel(): GameViewModel = GameViewModel(ModuleDI.gameLogic)