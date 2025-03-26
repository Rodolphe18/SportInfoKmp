package com.example.sportinfokmp.data.remote.dto.players

import com.example.sportinfokmp.data.remote.dto.areas.NetworkArea
import com.example.sportinfokmp.data.remote.dto.teams.NetworkContract
import com.example.sportinfokmp.data.remote.dto.teams.NetworkRunningCompetition
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCurrentTeam(
    val address: String? = "",
    val area: NetworkArea?,
    val clubColors: String? = "",
    val contract: NetworkContract?,
    val crest: String?,
    val founded: Int?,
    val id: Int,
    val name: String?,
    val runningCompetitions: List<NetworkRunningCompetition> = emptyList(),
    val shortName: String? = "",
    val tla: String? = "",
    val venue: String? = "",
    val website: String? = ""
)