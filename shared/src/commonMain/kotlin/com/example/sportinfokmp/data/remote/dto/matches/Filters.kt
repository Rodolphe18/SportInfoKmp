package com.example.sportinfokmp.data.remote.dto.matches

import kotlinx.serialization.Serializable

@Serializable
data class Filters(
    val matchday: String?=null,
    val season: String?=null,
    val dateFrom : String?=null,
    val dateTo : String?=null,
    val stage : String?=null,
    val status : String?=null,
    val group : String?=null
)


