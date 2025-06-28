package com.shahriyardx.aspen.screens.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun Tabs() {
    val scrollState = rememberScrollState()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val items = listOf(
        "Location", "Hotels", "Food", "Adventure", "Attractions", "Activities"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
        ) {
            items.forEachIndexed { index, title ->
                val selected = selectedIndex == index
                Button(
                    onClick = {
                        selectedIndex = index
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = if (selected) MaterialTheme.colorScheme.surface else Color.Transparent,
                        contentColor = if (selected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onBackground,
                    )
                ) {
                    Text(title, fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal)
                }
            }
        }

        AnimatedVisibility(
            scrollState.value == 0, enter = fadeIn(), exit = fadeOut(),
            modifier = Modifier
                .fillMaxHeight()
                .width(20.dp)
                .align(Alignment.CenterEnd),
        ) {
            Icon(

                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = "Right"
            )
        }
    }
}