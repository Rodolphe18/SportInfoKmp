package com.example.sportinfokmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.sportinfokmp.ui.competitions.BaseRoute
import com.example.sportinfokmp.ui.competitions.competitionsScreen
import com.example.sportinfokmp.ui.competitions.matches.competitionMatchesScreen
import com.example.sportinfokmp.ui.competitions.matches.navigateToCompetitionMatches
import com.example.sportinfokmp.ui.search.searchScreen
import com.example.sportinfokmp.ui.teams.teamsScreen
import com.example.sportinfokmp.ui.today.todayScreen

@Composable
fun SportsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: Any = BaseRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        competitionsScreen(onCompetitionClick = navController::navigateToCompetitionMatches) {
            competitionMatchesScreen(onBackClick = navController::popBackStack)
        }
        todayScreen()
        teamsScreen()
        searchScreen(navController::popBackStack, {}, {})
    }
}


