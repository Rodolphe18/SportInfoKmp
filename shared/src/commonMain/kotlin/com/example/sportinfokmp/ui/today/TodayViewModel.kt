package com.example.sportinfokmp.ui.today

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportinfokmp.data.remote.dto.matches.Match
import com.example.sportinfokmp.domain.repository.MatchRepository
import com.example.sportinfokmp.domain.repository.MatchRepositoryInterface
import com.example.sportinfokmp.util.WhileUiSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class TodayViewModel(matchRepository: MatchRepositoryInterface) : ViewModel() {

    val state: StateFlow<TodayUiState> = matchRepository
        .getTodayMatchList().map { TodayUiState.Success(it) }.stateIn(viewModelScope, WhileUiSubscribed,
            TodayUiState.Loading
        )

}


sealed interface TodayUiState {

    data object Loading : TodayUiState
    data class Success(
        val matches:List<Match>
    ) : TodayUiState
}