package com.example.sportinfokmp.data.remote.dto.competitions

import com.example.sportinfokmp.domain.model.CurrentSeason
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class NetworkCurrentSeason(
    val currentMatchday: Int?=null,
    val endDate: String? = null,
    @SerialName("id") val seasonId: Int,
    val startDate: String ? = null,
    @SerialName("winner") val winner: NetworkWinner?
)

fun NetworkCurrentSeason.asExternalModel() = CurrentSeason(currentMatchday, endDate.orEmpty(), seasonId, startDate.orEmpty(), winner?.asExternalModel())
