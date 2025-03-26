package com.example.sportinfokmp.data.remote.dto.teams

import com.example.sportinfokmp.domain.model.Contract
import kotlinx.serialization.Serializable

@Serializable
data class NetworkContract(
    val start: String? = "",
    val until: String? = ""
)

fun NetworkContract.asExternalModel() = Contract(start, until)