package com.example.sportinfokmp.data.remote.dto.matches


import kotlinx.serialization.Serializable


@Serializable
data class Goal(
    val assist: Assist?,
    val injuryTime: Int,
    val minute: Int,
    val score: LightScore?,
    val scorer: Scorer?,
    val team: Team?,
    val type: String? = null
)