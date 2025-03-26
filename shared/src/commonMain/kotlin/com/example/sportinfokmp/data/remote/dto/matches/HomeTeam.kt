package com.example.sportinfokmp.data.remote.dto.matches

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class HomeTeam(
    @Transient val bench: List<Unit> = emptyList(),
    val coach: Coach?,
    val crest: String? = "",
    val formation: String? = "",
    val id: Int,
    val leagueRank: Int?=null,
    @Transient val lineup: List<Unit> = emptyList(),
    val name: String? = "",
    val shortName: String? = "",
    val tla: String? = ""
) {
    constructor(
        crest: String,
        formation: String?,
        id: Int,
        leagueRank: Int,
        name: String?,
        shortName: String?,
        tla: String?
    ) : this(emptyList(), null, crest, formation, id, leagueRank, emptyList(), name, shortName, tla)
}