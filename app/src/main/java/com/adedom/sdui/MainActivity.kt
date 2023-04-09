package com.adedom.sdui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.adedom.home.presentation.component.HomeScreen
import com.adedom.ui_component.ui.theme.SDUITheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SDUITheme {
                HomeScreen(koinViewModel())
            }
        }
    }
}
