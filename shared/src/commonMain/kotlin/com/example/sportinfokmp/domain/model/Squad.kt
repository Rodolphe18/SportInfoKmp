package com.example.sportinfokmp.domain.model

import com.example.sportinfokmp.domain.model.Contract

data class Squad(
    val contract: Contract?,
    val dateOfBirth: String? = "",
    val firstName: String? = "",
    val id: Int,
    val lastName: String? = "",
    val marketValue: Int,
    val name: String? = "",
    val nationality: String? = "",
    val position: String? = "",
    val shirtNumber: Int
)