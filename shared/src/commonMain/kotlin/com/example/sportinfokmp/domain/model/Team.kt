package com.example.sportinfokmp.domain.model

import com.example.sportinfokmp.domain.model.Area
import com.example.sportinfokmp.domain.model.Coach
import com.example.sportinfokmp.domain.model.RunningCompetition
import com.example.sportinfokmp.domain.model.Squad

data class Team(
    val address: String? = "",
    val area: Area?,
    val clubColors: String? = "",
    val coach: Coach?,
    val crest: String? = "",
    val founded: Int?,
    val id: Int,
    val lastUpdated: String? = "",
    val marketValue: Int?=null,
    val name: String? = "",
    val runningCompetitions: List<RunningCompetition?> = emptyList(),
    val shortName: String? = "",
    val squad: List<Squad?> = emptyList(),
    val tla: String? = "",
    val venue: String? = "",
    val website: String? = "",
    val isFavorite: Boolean = false
)