package org.jhaard.memorygame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App(startViewModel = remember { Modules.startViewModel() })
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(startViewModel = remember { Modules.startViewModel() })
}