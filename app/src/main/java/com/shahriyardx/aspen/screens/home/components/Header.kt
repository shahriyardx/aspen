package com.shahriyardx.aspen.screens.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val dropdownMenuItems = listOf("Dhaka", "Rangpur", "Sylhet")

@Composable
fun HomeHeader(
    scrollState: ScrollState = ScrollState(0)
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    var expanded by remember { mutableStateOf(false) }

    val from = MaterialTheme.typography.titleLarge
    val to = MaterialTheme.typography.displaySmall

    val targetFontSize = if (scrollState.value <= 10) to.fontSize else from.fontSize

    val animatedFontSize by animateFloatAsState(
        targetValue = targetFontSize.value,
        label = "fontSizeAnim"
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            AnimatedVisibility(scrollState.value <= 10) {
                Text(text = "Explore", style = MaterialTheme.typography.titleMedium)
            }

            Text(
                text = "Aspen",
                fontSize = animatedFontSize.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box() {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.clickable {
                    expanded = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.PinDrop,
                    contentDescription = "Pin Drop",
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(text = dropdownMenuItems[selectedIndex])
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Pin",
                    tint = MaterialTheme.colorScheme.primary
                )

            }
            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }) {
                dropdownMenuItems.forEachIndexed { index, title ->
                    DropdownMenuItem(text = { Text(title) }, onClick = {
                        selectedIndex = index
                        expanded = false
                    })
                }
            }
        }

    }
}