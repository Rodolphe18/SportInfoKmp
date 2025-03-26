package com.example.sportinfokmp.ui.competitions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sportinfokmp.ui.composable.CompetitionItem
import com.example.sportinfokmp.ui.theme.LocalGradientColors
import com.example.sportinfokmp.ui.theme.SportInfoGradientBackground
import org.koin.compose.viewmodel.koinViewModel


@Composable
internal fun CompetitionsRoute(
    viewModel: CompetitionListViewModel = koinViewModel<CompetitionListViewModel>(),
    onCompetitionClick: (String, String, Int) -> Unit
) {
    val competitionState = viewModel.state

    SportInfoGradientBackground(gradientColors = LocalGradientColors.current) {
        CompetitionsListScreen(competitionState, onCompetitionClick)
    }
}

@Composable
fun CompetitionsListScreen(
    competitionsListState: CompetitionsListState,
    onCompetitionClick: (String, String, Int) -> Unit
) {
    if (competitionsListState.isLoading) {
        Surface(Modifier.fillMaxSize()) {
            Box { CircularProgressIndicator(Modifier.align(Alignment.Center)) }
        }
    } else {
        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 4.dp),
            columns = GridCells.Fixed(1),
            state = rememberLazyGridState(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(items = competitionsListState.competitions) { competition ->
                CompetitionItem(competition = competition, onCompetitionClick = onCompetitionClick)
            }
        }
    }
}