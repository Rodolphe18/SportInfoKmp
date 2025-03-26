package com.example.sportinfokmp.data.remote.dto.matches

import kotlinx.serialization.Serializable

@Serializable
data class Odds(
    val awayWin: Double?=null,
    val draw: Double?=null,
    val homeWin: Double?=null
)