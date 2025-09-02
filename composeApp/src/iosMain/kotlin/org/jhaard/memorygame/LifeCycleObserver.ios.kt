package org.jhaard.memorygame

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSOperationQueue
import platform.UIKit.UIApplicationDidBecomeActiveNotification
import platform.UIKit.UIApplicationDidEnterBackgroundNotification
import platform.UIKit.UIApplicationWillEnterForegroundNotification

@Composable
actual fun RememberLifecycleObserver(
    onStart: () -> Unit,
    onStop: () -> Unit
) {
    DisposableEffect(Unit) {
        val notificationCenter = NSNotificationCenter.defaultCenter

        onStart()

        val didBecomeActiveObserver = notificationCenter.addObserverForName(
            name = UIApplicationDidBecomeActiveNotification,
            `object` = null,
            queue = NSOperationQueue.mainQueue
        ) { _ -> onStart() }

        val willEnterForegroundObserver = notificationCenter.addObserverForName(
            name = UIApplicationWillEnterForegroundNotification,
            `object` = null,
            queue = NSOperationQueue.mainQueue
        ) { _ -> onStart() }

        val didEnterBackgroundObserver = notificationCenter.addObserverForName(
            name = UIApplicationDidEnterBackgroundNotification,
            `object` = null,
            queue = NSOperationQueue.mainQueue
        ) { _ -> onStop() }

        onDispose {
            onStop()
            notificationCenter.removeObserver(didBecomeActiveObserver)
            notificationCenter.removeObserver(willEnterForegroundObserver)
            notificationCenter.removeObserver(didEnterBackgroundObserver)
        }
    }

}