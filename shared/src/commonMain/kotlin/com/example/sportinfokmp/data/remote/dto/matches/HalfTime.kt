package com.example.sportinfokmp.data.remote.dto.matches


import kotlinx.serialization.Serializable

@Serializable
data class HalfTime(
    val away: Int?=null,
    val home: Int?=null
)