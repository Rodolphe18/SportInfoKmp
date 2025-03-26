package com.example.sportinfokmp.domain.model

data class Coach(
    val contract: Contract?,
    val dateOfBirth: String? = "",
    val firstName: String? = "",
    val id: Int,
    val lastName: String? = "",
    val name: String? ="",
    val nationality: String? = ""
)