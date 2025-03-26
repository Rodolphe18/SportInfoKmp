package com.example.sportinfokmp.ui.competitions

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportinfokmp.domain.model.Competition
import com.example.sportinfokmp.domain.repository.CompetitionRepository
import com.example.sportinfokmp.domain.repository.CompetitionRepositoryInterface
import kotlinx.coroutines.launch


class CompetitionListViewModel (
    private val repositoryInterface: CompetitionRepositoryInterface
) : ViewModel() {

    var state by mutableStateOf(CompetitionsListState())

    init {
        viewModelScope.launch {
            repositoryInterface
                .getCompetitionsList()
                .collect { competitionList ->
                competitionList
                    .filter { it.type == "LEAGUE" }
                    .sortedBy { it.area?.parentArea == "EUROPE" }
                    .reversed()
                    .let { list ->
                    state = state.copy(competitions = list)
                }
            }
            state = state.copy(isLoading = false)
        }
    }
}

data class CompetitionsListState(
    val competitions : List<Competition> = emptyList(),
    val isLoading: Boolean = true,
    val isRefreshing : Boolean = false,
    val searchQuery: String = ""
)
