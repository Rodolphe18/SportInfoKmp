package com.example.sportinfokmp.data.remote.dto.players

import com.example.sportinfokmp.data.remote.dto.players.NetworkCurrentTeam
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPlayer(
    val networkCurrentTeam: NetworkCurrentTeam?,
    val dateOfBirth: String? = "",
    val firstName: String? = "",
    val id: Int,
    val lastName: String? = "",
    val lastUpdated: String? = "",
    val name: String? = "",
    val nationality: String?= "",
    val position: String? = "",
    val shirtNumber: Int
)