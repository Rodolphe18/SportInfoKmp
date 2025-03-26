package com.example.sportinfokmp.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class CurrentSeason(
    val currentMatchday: Int?=null,
    val endDate: String? = "",
    val currentSeasonId: Int,
    val startDate: String? = "",
    val winner: Winner?
)
