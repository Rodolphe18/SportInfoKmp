package com.example.sportinfokmp.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class Competition(
    val area: Area?,
    val code: String?,
    val currentSeason: CurrentSeason?,
    val emblem: String?,
    val id : Int?,
    val lastUpdated: String?,
    val name: String?,
    val seasons: List<Season>? = emptyList(),
    val type: String?,
    val isFavorite: Boolean = false,
)

