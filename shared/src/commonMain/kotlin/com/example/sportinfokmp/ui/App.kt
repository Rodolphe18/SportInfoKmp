package com.example.sportinfokmp.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.sportinfokmp.navigation.SportsBottomBar
import com.example.sportinfokmp.navigation.SportsIcons
import com.example.sportinfokmp.navigation.SportsNavHost
import com.example.sportinfokmp.navigation.SportsTopAppBar
import com.example.sportinfokmp.navigation.TopLevelDestination
import com.example.sportinfokmp.ui.competitions.navigateToCompetitions
import com.example.sportinfokmp.ui.search.navigateToSearch
import com.example.sportinfokmp.ui.settings.SettingsDialog
import com.example.sportinfokmp.ui.teams.navigateToTeams
import com.example.sportinfokmp.ui.theme.SportInfoTheme
import com.example.sportinfokmp.ui.today.navigateToToday
import org.jetbrains.compose.resources.stringResource
import sportinfokmp.shared.generated.resources.Res
import sportinfokmp.shared.generated.resources.settings


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    SportInfoTheme {

        val navController: NavHostController = rememberNavController()
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination
        val currentTopLevelDestination =
            TopLevelDestination.entries.firstOrNull { topLevelDestination ->
                currentDestination?.hasRoute(route = topLevelDestination.route) == true
            }

        var shouldShowSettingsDialog by mutableStateOf(false)
        val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

        fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                TopLevelDestination.COMPETITIONS -> navController.navigateToCompetitions(
                    topLevelNavOptions
                )

                TopLevelDestination.TODAY -> navController.navigateToToday(topLevelNavOptions)
                TopLevelDestination.TEAMS -> navController.navigateToTeams(topLevelNavOptions)
            }
        }

        fun onBackClick() {
            navController.popBackStack()
        }

        fun navigateToSearch() = navController.navigateToSearch()
        val snackbarHostState = remember { SnackbarHostState() }

        if (shouldShowSettingsDialog) {
            SettingsDialog(
                onDismiss = { shouldShowSettingsDialog = false },
            )
        }
        Scaffold(
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                // Show the top app bar on top level destinations.
                val destination = currentTopLevelDestination

                if (destination != null) {
                    SportsTopAppBar(
                        modifier = Modifier.fillMaxWidth(),
                        titleRes = destination.titleTextId,
                        actionIcon = SportsIcons.Settings,
                        actionIconContentDescription = stringResource(Res.string.settings),
                        onActionClick = { shouldShowSettingsDialog = true },
                        onNavigationClick = { navigateToSearch() }
                    )
                }
            },
            bottomBar = {
                SportsBottomBar(
                    destinations = topLevelDestinations,
                    onNavigateToDestination = ::navigateToTopLevelDestination,
                    currentDestination = currentDestination
                )
            }
        ) { padding ->
            Row(
                Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal
                        )
                    )
            ) {

                SportsNavHost(
                    navController = navController,
                    modifier = Modifier
                        .padding(padding)
                        .consumeWindowInsets(padding)
                )
            }
        }
    }
}
