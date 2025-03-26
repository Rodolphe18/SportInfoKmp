package com.example.sportinfokmp.data.remote.dto.teams

import com.example.sportinfokmp.domain.model.Coach
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCoach(
    val contract: NetworkContract?,
    val dateOfBirth: String? = "",
    val firstName: String? = "",
    val id: Int,
    val lastName: String? = "",
    val name: String? ="",
    val nationality: String? = ""
)

fun NetworkCoach.asExternalModel() = Coach(contract?.asExternalModel(), dateOfBirth, firstName, id, lastName, name, nationality)