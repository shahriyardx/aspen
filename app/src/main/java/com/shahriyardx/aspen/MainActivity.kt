package com.shahriyardx.aspen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import com.shahriyardx.aspen.navigation.Navigation
import com.shahriyardx.aspen.ui.theme.AspenTheme
import com.shahriyardx.aspen.utils.LaunchDatastore
import com.shahriyardx.aspen.utils.PreferenceHelper

class MainActivity : ComponentActivity() {
    private lateinit var launchDatastore: LaunchDatastore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        launchDatastore = LaunchDatastore(this)

//        WindowInsetsControllerCompat(window, window.decorView).apply {
//            hide(WindowInsetsCompat.Type.statusBars())
//            systemBarsBehavior =
//                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//        }

        setContent {
            AspenTheme(dynamicColor = true) {
                CompositionLocalProvider(LocalPreferenceHelper provides launchDatastore) {
                    Navigation()
                }
            }
        }
    }
}