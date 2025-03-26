package com.example.sportinfokmp.data.remote.dto.matches

import kotlinx.serialization.Serializable

@Serializable
data class ResultSet(
    val count: Int,
    val first: String?=null,
    val last: String?=null,
    val played: Int?=null
)