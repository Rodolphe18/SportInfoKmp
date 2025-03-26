package com.example.sportinfokmp.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.sportinfokmp.ui.teams.TeamsNavigationRoute
import com.example.sportinfokmp.ui.today.TodayNavigationRoute
import com.example.sportinfokmp.ui.competitions.CompetitionsNavigationRoute
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import sportinfokmp.shared.generated.resources.Res
import sportinfokmp.shared.generated.resources.competition
import sportinfokmp.shared.generated.resources.team
import sportinfokmp.shared.generated.resources.today
import kotlin.reflect.KClass

@Composable
fun RowScope.SportsNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
    )
}

@Composable
fun SportsNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    NavigationBar(
        modifier = modifier,
        tonalElevation = 0.dp,
        content = content
    )
}

@Composable
fun SportsBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    SportsNavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            SportsNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    when (icon) {
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )

                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(icon.id),
                            contentDescription = null
                        )
                    }
                },
               label = { Text(stringResource(destination.titleTextId), fontWeight = FontWeight.SemiBold) }
            )
        }
    }
}

enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val titleTextId: StringResource,
    val route: KClass<*>
) {
    COMPETITIONS(
        selectedIcon = Icon.ImageVectorIcon(SportsIcons.Competition),
        unselectedIcon = Icon.ImageVectorIcon(SportsIcons.Competition),
        titleTextId = Res.string.competition,
        route = CompetitionsNavigationRoute::class
    ),
    TODAY(
        selectedIcon = Icon.ImageVectorIcon(Icons.Filled.Today),
        unselectedIcon = Icon.ImageVectorIcon(Icons.Filled.Today),
        titleTextId = Res.string.today,
        route = TodayNavigationRoute::class
    ),
    TEAMS(
        selectedIcon = Icon.ImageVectorIcon(Icons.Filled.Flag),
        unselectedIcon = Icon.ImageVectorIcon(Icons.Filled.Flag),
        titleTextId = Res.string.team,
        route = TeamsNavigationRoute::class
    )
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false