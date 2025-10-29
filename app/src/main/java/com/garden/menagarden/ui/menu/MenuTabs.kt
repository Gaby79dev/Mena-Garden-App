package com.garden.menagarden.ui.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.garden.menagarden.R


@Composable
fun MenuTabs(selectedTab: String? = null) {
    val tabs = listOf(stringResource(id = R.string.tab_food), stringResource(id = R.string.tab_drinks))
    
    // Corrected Logic: Check for the language-independent key "drinks"
    val initialTabIndex = if (selectedTab == "drinks") 1 else 0
    var selectedTabIndex by remember { mutableStateOf(initialTabIndex) }

    // Corrected Logic: Check for the language-independent key "drinks"
    LaunchedEffect(selectedTab) {
        val newIndex = if (selectedTab == "drinks") 1 else 0
        if (newIndex != selectedTabIndex) {
            selectedTabIndex = newIndex
        }
    }

    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = BackgroundDark,
            contentColor = PrimaryColor,
            indicator = { tabPositions: List<TabPosition> ->
                if (selectedTabIndex < tabPositions.size) {
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = PrimaryColor
                    )
                }
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) },
                    selectedContentColor = PrimaryColor,
                    unselectedContentColor = TextColorSecondary
                )
            }
        }

        val screenModifier = Modifier.clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))

        when (selectedTabIndex) {
            0 -> Box(modifier = screenModifier) {
                FoodMenuScreen()
            }
            1 -> Box(modifier = screenModifier) {
                DrinksMenuScreen()
            }
        }
    }
}
