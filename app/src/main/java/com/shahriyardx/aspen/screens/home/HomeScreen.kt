package com.shahriyardx.aspen.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shahriyardx.aspen.R
import com.shahriyardx.aspen.components.BottomNavigationBar
import com.shahriyardx.aspen.screens.home.components.CardContainer
import com.shahriyardx.aspen.screens.home.components.HomeHeader
import com.shahriyardx.aspen.screens.home.components.HotelCard
import com.shahriyardx.aspen.screens.home.components.SearchBar
import com.shahriyardx.aspen.screens.home.components.Tabs

data class PopularCard(
    val name: String,
    val rating: String,
    val image: Painter
)

@Composable
fun HomeScreen() {
    val popularCards = listOf(
        PopularCard("Alley Palace", "4.1", painterResource(R.drawable.hotel1)),
        PopularCard("Residential Hotel", "4.5", painterResource(R.drawable.hotel2))
    )

    Scaffold(bottomBar = {
        BottomNavigationBar()
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(horizontal = 24.dp)
                .padding(top = 24.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            HomeHeader()
            SearchBar()
            Tabs()

            CardContainer("Popular") {
                popularCards.forEach { hotel ->
                    HotelCard(hotel = hotel)
                }
            }
        }
    }
}