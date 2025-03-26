package com.example.sportinfokmp.data.remote.dto.areas


import com.example.sportinfokmp.domain.model.Area
import kotlinx.serialization.Serializable

@Serializable
data class NetworkArea(
   val id: Int?,
   val name : String?,
   val countryCode: String?,
   val flag: String?,
   val parentAreaId: Int?,
   val parentArea: String?
)


fun NetworkArea.asExternalModel() = Area(id ?: 0, name ?: "", countryCode ?: "", flag ?: "", parentAreaId ?: 0, parentArea ?: "")
