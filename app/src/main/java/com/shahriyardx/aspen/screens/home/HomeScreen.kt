package com.shahriyardx.aspen.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shahriyardx.aspen.R
import com.shahriyardx.aspen.components.BottomNavigationBar
import com.shahriyardx.aspen.screens.home.components.CardContainer
import com.shahriyardx.aspen.screens.home.components.HomeHeader
import com.shahriyardx.aspen.screens.home.components.HotelCard
import com.shahriyardx.aspen.screens.home.components.RecommendedCard
import com.shahriyardx.aspen.screens.home.components.SearchBar
import com.shahriyardx.aspen.screens.home.components.Tabs

data class PopularCard(
    val name: String,
    val rating: String,
    val image: Painter
)

data class RecommendedCard(
    val name: String,
    val nights: Int,
    val days: Int,
    val image: Painter,
    val isTrending: Boolean = false,
)

@Composable
fun HomeScreen() {
    val popularCards = listOf(
        PopularCard("Alley Palace", "4.1", painterResource(R.drawable.hotel1)),
        PopularCard("Residential Hotel", "4.5", painterResource(R.drawable.hotel2))
    )

    val recommendedCards = listOf(
        RecommendedCard("Explore Aspen", 5, 4, painterResource(R.drawable.recommended1), true),
        RecommendedCard("Luxurious Aspen", 3, 2, painterResource(R.drawable.recommended2))
    )

    val scrollState = rememberScrollState()

    Scaffold(bottomBar = {
        BottomNavigationBar()
    }, topBar = {
        Box(
            modifier = Modifier
                .background(if (scrollState.value > 10) MaterialTheme.colorScheme.background else Color.Transparent)
                .padding(vertical = 10.dp)
                .padding(horizontal = 24.dp)
                .padding(WindowInsets.statusBars.asPaddingValues())
        ) {
            HomeHeader(scrollState = scrollState)
        }
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(horizontal = 24.dp)
                .padding(innerPadding)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {

            Spacer(modifier = Modifier.height(5.dp))
            SearchBar()
            Tabs()

            CardContainer("Popular") {
                popularCards.forEach { hotel ->
                    HotelCard(hotel = hotel)
                }
            }

            CardContainer("Recommended") {
                recommendedCards.forEach { data ->
                    RecommendedCard(data)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}