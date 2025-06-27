package com.shahriyardx.aspen.screens

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shahriyardx.aspen.components.BottomNavigationBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {
    Scaffold(bottomBar = {
        BottomNavigationBar()
    }) { innerPadding ->

    }
}