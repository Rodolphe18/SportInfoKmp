package com.example.sportinfokmp.ui.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object SearchRoute

fun NavController.navigateToSearch(navOptions: NavOptions? = null) = navigate(SearchRoute, navOptions)

fun NavGraphBuilder.searchScreen(
    onBackClick: () -> Unit,
    onInterestsClick: () -> Unit,
    onTopicClick: (String) -> Unit,
) {
    // TODO: Handle back stack for each top-level destination. At the moment each top-level
    // destination may have own search screen's back stack.
    composable<SearchRoute> {
        SearchRoute(
            onBackClick = onBackClick,
          //  onInterestsClick = onInterestsClick,
          //  onTopicClick = onTopicClick,
        )
    }
}