package com.shahriyardx.aspen

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController

val LocalNavController = compositionLocalOf<NavController> {
    error("CompositionLocal LocalNavController not present")
}