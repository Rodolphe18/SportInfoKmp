package com.example.sportinfokmp.data.remote.dto.competitions

import com.example.sportinfokmp.domain.model.Season
import kotlinx.serialization.Serializable

@Serializable
data class NetworkSeason(
    val currentMatchday: Int,
    val endDate: String? = "",
    val id: Int,
    val startDate: String? = "",
    val winner: NetworkWinner? = null
) {
    constructor(currentMatchday: Int, endDate: String, id : Int, startDate: String) : this(currentMatchday, endDate, id, startDate, null)
}

fun NetworkSeason.asExternalModel() = Season(currentMatchday, endDate, id, startDate, winner?.asExternalModel())
