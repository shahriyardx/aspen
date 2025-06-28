package com.shahriyardx.aspen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import com.shahriyardx.aspen.navigation.Navigation
import com.shahriyardx.aspen.ui.theme.AspenTheme

class MainActivity : ComponentActivity() {
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        preferenceHelper = PreferenceHelper(this)

//        WindowInsetsControllerCompat(window, window.decorView).apply {
//            hide(WindowInsetsCompat.Type.statusBars())
//            systemBarsBehavior =
//                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//        }

        setContent {
            AspenTheme(dynamicColor = true) {
                CompositionLocalProvider(LocalPreferenceHelper provides preferenceHelper) {
                    Navigation()
                }
            }
        }
    }
}