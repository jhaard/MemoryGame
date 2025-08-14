package org.jhaard.memorygame

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSOperationQueue
import platform.UIKit.UIApplicationDidBecomeActiveNotification
import platform.UIKit.UIApplicationDidEnterBackgroundNotification

@Composable
actual fun RememberLifecycleObserver(
    onStart: () -> Unit,
    onStop: () -> Unit
) {
    DisposableEffect(Unit) {
        val notificationCenter = NSNotificationCenter.defaultCenter

        val didBecomeActiveObserver = notificationCenter.addObserverForName(
            name = UIApplicationDidBecomeActiveNotification,
            `object` = null,
            queue = NSOperationQueue.mainQueue
        ) { _ ->
            onStart()
        }

        val didEnterBackgroundObserver = notificationCenter.addObserverForName(
            name = UIApplicationDidEnterBackgroundNotification,
            `object` = null,
            queue = NSOperationQueue.mainQueue
        ) { _ ->
            onStop()
        }

        onDispose {
            notificationCenter.removeObserver(didBecomeActiveObserver)
            notificationCenter.removeObserver(didEnterBackgroundObserver)
        }
    }
}