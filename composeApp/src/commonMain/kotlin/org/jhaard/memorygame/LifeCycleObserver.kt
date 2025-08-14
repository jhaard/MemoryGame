package org.jhaard.memorygame

import androidx.compose.runtime.Composable

@Composable
expect fun RememberLifecycleObserver(
    onStart: () -> Unit,
    onStop: () -> Unit
)