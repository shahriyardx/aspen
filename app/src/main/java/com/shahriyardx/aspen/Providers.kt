package com.shahriyardx.aspen

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import com.shahriyardx.aspen.utils.LaunchDatastore
import com.shahriyardx.aspen.utils.PreferenceHelper

val LocalNavController = compositionLocalOf<NavController> {
    error("CompositionLocal LocalNavController not present")
}

val LocalPreferenceHelper = compositionLocalOf<LaunchDatastore> {
    error("CompositionLocal LocalPreferenceHelper not present")
}