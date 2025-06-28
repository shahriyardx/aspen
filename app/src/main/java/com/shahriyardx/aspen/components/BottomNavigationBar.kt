package com.shahriyardx.aspen.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shahriyardx.aspen.LocalNavController
import com.shahriyardx.aspen.navigation.NavItem
import com.shahriyardx.aspen.navigation.defaultNavItems

@Composable
fun BottomNavigationBar(
    navItems: List<NavItem> = defaultNavItems,
) {
    val navController = LocalNavController.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 60.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        navItems.forEachIndexed { index, item ->
            val isSelected = item.route == currentDestination

            val iconSize by animateDpAsState(
                targetValue = if (isSelected) 40.dp else 30.dp,
                animationSpec = tween(durationMillis = 300),
                label = "IconSizeAnimation"
            )

            val iconColor by animateColorAsState(
                targetValue = if (isSelected) MaterialTheme.colorScheme.primary else Color.LightGray,
                animationSpec = tween(durationMillis = 300),
                label = "BackgroundColorAnimation"
            )

            BadgedBox(
                badge = {
                    if (item.hasBadge) {
                        Badge {
                            if (item.badgeCount > 0) {
                                Text(item.badgeCount.toString())

                            }
                        }
                    }

                }) {
                IconButton(onClick = {
                    navController.navigate(item.route)
                }) {
                    Icon(
                        modifier = Modifier.size(iconSize),
                        imageVector = if (isSelected && item.selectedIcon != null) item.selectedIcon else item.icon,
                        contentDescription = item.route,
                        tint = iconColor
                    )
                }
            }

        }
    }
}