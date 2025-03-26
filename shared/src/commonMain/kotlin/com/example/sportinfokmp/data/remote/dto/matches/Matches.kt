package com.example.sportinfokmp.data.remote.dto.matches

import com.example.sportinfokmp.data.remote.dto.competitions.NetworkLightCompetition
import kotlinx.serialization.Serializable

@Serializable
data class Matches(
    val competition: NetworkLightCompetition?=null,
    val filters: Filters?,
    val matches: List<Match>? = emptyList(),
    val resultSet: ResultSet?=null
)

