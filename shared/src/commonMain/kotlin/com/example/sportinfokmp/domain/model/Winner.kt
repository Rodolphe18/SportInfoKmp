package com.example.sportinfokmp.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class Winner(
    val address: String?,
    val clubColors: String?,
    val crest: String?,
    val founded: Int?,
    val winnerId: Int,
    val lastUpdated: String?,
    val name: String?,
    val shortName: String?,
    val tla: String?,
    val venue: String?,
    val website: String?
)

