package com.adedom.showkase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.adedom.ui_component.Greeting
import com.adedom.ui_component.ui.theme.SDUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SDUITheme {
                Greeting("Android")
            }
        }
    }
}
