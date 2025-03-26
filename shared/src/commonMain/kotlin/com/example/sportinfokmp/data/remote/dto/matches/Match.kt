package com.example.sportinfokmp.data.remote.dto.matches

import com.example.sportinfokmp.data.remote.dto.areas.NetworkArea
import com.example.sportinfokmp.data.remote.dto.competitions.NetworkLightCompetition
import com.example.sportinfokmp.data.remote.dto.competitions.NetworkSeason
import kotlinx.serialization.Serializable


@Serializable
data class Match(
    val area: NetworkArea,
    val attendance: Int?=null,
    val awayTeam: AwayTeam,
    val competition: NetworkLightCompetition,
    val goals: List<Goal>?,
    val homeTeam: HomeTeam,
    val id: Int,
    val injuryTime: Int?=null,
    val lastUpdated: String? = "",
    val matchday: Int,
    val minute: Int = 0,
    val odds: Odds,
    val penalties: List<Penalty> = emptyList(),
    val referees: List<Referee> = emptyList(),
    val score: Score?,
    val season: NetworkSeason,
    val stage: String? = "",
    val status: String? = "",
    val utcDate: String? = "",
    val venue: String? = ""
) {
    constructor(
        area: NetworkArea,
        attendance: Int,
        awayTeam: AwayTeam,
        competition: NetworkLightCompetition,
        goals: List<Goal>,
        homeTeam: HomeTeam,
        id: Int,
        injuryTime: Int,
        lastUpdated: String,
        matchday: Int,
        minute: Int,
        odds: Odds,
        score: Score,
        season: NetworkSeason,
        stage: String,
        status: String,
        utcDate: String,
        venue: String?
    ) : this(
        area, attendance, awayTeam, competition, goals,
        homeTeam,
        id,
        injuryTime,
        lastUpdated,
        matchday,
        minute,
        odds,
        emptyList(),
        emptyList(),
        score,
        season,
        stage,
        status,
        utcDate,
        venue
    )

    override fun hashCode(): Int {
        return id * 31
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Match

        if (attendance != other.attendance) return false
        if (id != other.id) return false
        if (injuryTime != other.injuryTime) return false
        if (matchday != other.matchday) return false
        if (minute != other.minute) return false
        if (area != other.area) return false
        if (awayTeam != other.awayTeam) return false
        if (competition != other.competition) return false
        if (goals != other.goals) return false
        if (homeTeam != other.homeTeam) return false
        if (lastUpdated != other.lastUpdated) return false
        if (odds != other.odds) return false
        if (penalties != other.penalties) return false
        if (referees != other.referees) return false
        if (score != other.score) return false
        if (season != other.season) return false
        if (stage != other.stage) return false
        if (status != other.status) return false
        if (utcDate != other.utcDate) return false
        if (venue != other.venue) return false

        return true
    }


}

