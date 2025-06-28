package com.shahriyardx.aspen.screens.home.components

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

val dropdownMenuItems = listOf("Dhaka", "Rangpur", "Sylhet")

@Composable
fun HomeHeader() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(text = "Explore", style = MaterialTheme.typography.titleMedium)
            Text(
                text = "Aspen",
                style = MaterialTheme.typography.displaySmall,
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