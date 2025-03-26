package com.example.sportinfokmp.domain.model


import kotlinx.serialization.Serializable

@Serializable
data class Area(
    val id: Int?,
    val name : String?,
    val countryCode: String?,
    val flag: String?,
    val parentAreaId: Int?,
    val parentArea: String?
)




