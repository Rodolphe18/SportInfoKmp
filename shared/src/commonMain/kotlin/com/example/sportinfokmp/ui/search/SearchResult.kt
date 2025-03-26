package com.example.sportinfokmp.ui.search

import com.example.sportinfokmp.domain.model.Competition
import com.example.sportinfokmp.domain.model.Team

/** An entity that holds the search result */
data class SearchResult(
    val teams: List<Team> = emptyList(),
    val competitions: List<Competition> = emptyList(),
)
