package com.example.sportinfokmp.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class Season(
    val currentMatchday: Int,
    val endDate: String? = "",
    val id: Int,
    val startDate: String? = "",
    val winner: Winner? = null
)