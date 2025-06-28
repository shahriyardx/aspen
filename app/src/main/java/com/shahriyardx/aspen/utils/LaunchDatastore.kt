package com.shahriyardx.aspen.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class LaunchDatastore(
    private val context: Context
) {
    val Context.dataStore by preferencesDataStore("launch_info")

    suspend fun saveLaunchInfo(isFirstLaunch: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[stringPreferencesKey("isFirstLaunch")] = isFirstLaunch.toString()
        }
    }

    suspend fun getLaunchInfo(): String {
        return context.dataStore.data.map { preferences ->
            preferences[stringPreferencesKey("isFirstLaunch")] ?: "true"
        }.first()
    }
}