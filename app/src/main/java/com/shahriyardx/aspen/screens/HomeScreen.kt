package com.shahriyardx.aspen.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shahriyardx.aspen.components.BottomNavigationBar


@Composable
fun HomeScreen() {
    Scaffold(bottomBar = {
        BottomNavigationBar()
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(horizontal = 24.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            HomeHeader()
            SearchBar()
            Tabs()
        }
    }
}

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
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp), modifier = Modifier.clickable {
                expanded = true
            }) {
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

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = "Search") },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        maxLines = 1,
        shape = CircleShape,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainer,
            focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        )
    )
}

@Preview
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