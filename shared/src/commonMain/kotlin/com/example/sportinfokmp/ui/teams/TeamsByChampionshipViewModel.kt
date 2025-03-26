package com.example.sportinfokmp.ui.teams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportinfokmp.domain.model.Team
import com.example.sportinfokmp.domain.repository.TeamRepositoryInterface
import com.example.sportinfokmp.util.WhileUiSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn


class TeamsByChampionshipViewModel (teamRepository: TeamRepositoryInterface): ViewModel() {


    private val ligue1Teams =
        teamRepository.getLigue1Teams().stateIn(viewModelScope, WhileUiSubscribed, null)
    private val bundesligaTeams =
        teamRepository.getBundesligaTeams().stateIn(viewModelScope, WhileUiSubscribed, emptyList())
    private val seriaATeams =
        teamRepository.getSerieATeams().stateIn(viewModelScope, WhileUiSubscribed, emptyList())
    private val ligaTeams =
        teamRepository.getLigaTeams().stateIn(viewModelScope, WhileUiSubscribed, emptyList())
    private val premierLeagueTeams = teamRepository.getPremierLeagueTeams()
        .stateIn(viewModelScope, WhileUiSubscribed, emptyList())
    private val primeiraDivisionTeams = teamRepository.getPrimeiraDivisionTeams()
        .stateIn(viewModelScope, WhileUiSubscribed, emptyList())

    val uiState: StateFlow<SortedTeamsUiState> = combine(
        ligue1Teams,
        bundesligaTeams,
        seriaATeams,
        ligaTeams,
        premierLeagueTeams,
        primeiraDivisionTeams
    ) { input ->
        SortedTeamsUiState.Success(input.flatMap { it.orEmpty() })
    }.stateIn(viewModelScope, WhileUiSubscribed, SortedTeamsUiState.Loading)


}

sealed interface SortedTeamsUiState {
    data object Loading : SortedTeamsUiState
    data class Success(val teams:List<Team>): SortedTeamsUiState
}