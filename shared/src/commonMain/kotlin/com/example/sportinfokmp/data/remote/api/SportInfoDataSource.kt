package com.example.sportinfokmp.data.remote.api

import com.diamondedge.logging.logging
import com.example.sportinfokmp.data.remote.api.HttpClientFactory.API_KEY_NAME
import com.example.sportinfokmp.data.remote.api.HttpClientFactory.API_KEY_VALUE
import com.example.sportinfokmp.data.remote.dto.competitions.NetworkCompetitions
import com.example.sportinfokmp.data.remote.dto.matches.Matches
import com.example.sportinfokmp.data.remote.dto.teams.NetworkTeams
import com.example.sportinfokmp.data.remote.dto.teams.NetworkTeamsByCompetition
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter


const val API_FOOTBALL_DATA = "https://api.football-data.org/v4"

class SportInfoDataSource(private val httpClient: HttpClient) : SportInfoApi {

    override suspend fun getCompetitions(): NetworkCompetitions {
        return httpClient.get("$API_FOOTBALL_DATA/competitions") {
            header(API_KEY_NAME, API_KEY_VALUE)
        }.body<NetworkCompetitions>()
    }

    override suspend fun getTodayMatches() : Matches {
        return httpClient.get("$API_FOOTBALL_DATA/matches") {
            header(API_KEY_NAME, API_KEY_VALUE)
        }.body<Matches>()
    }

    override suspend fun getPremierLeagueTeams() : NetworkTeamsByCompetition {
        return httpClient.get("$API_FOOTBALL_DATA/competitions/PL/teams") {
            header(API_KEY_NAME, API_KEY_VALUE)
        }.body<NetworkTeamsByCompetition>()
    }

    override suspend fun getLigaTeams() : NetworkTeamsByCompetition {
        return httpClient.get("$API_FOOTBALL_DATA/competitions/PD/teams") {
            header(API_KEY_NAME, API_KEY_VALUE)
        }.body<NetworkTeamsByCompetition>()
    }

    override suspend fun getLigue1Teams() : NetworkTeamsByCompetition {
        return httpClient.get("$API_FOOTBALL_DATA/competitions/FL1/teams") {
            header(API_KEY_NAME, API_KEY_VALUE)
        }.body<NetworkTeamsByCompetition>()
    }

    override suspend fun getPrimeiraLigue() : NetworkTeamsByCompetition {
        return httpClient.get("$API_FOOTBALL_DATA/competitions/PPL/teams") {
            header(API_KEY_NAME, API_KEY_VALUE)
        }.body<NetworkTeamsByCompetition>()
    }

    override suspend fun getSerieATeams() : NetworkTeamsByCompetition {
        return httpClient.get("$API_FOOTBALL_DATA/competitions/SA/teams") {
            header(API_KEY_NAME, API_KEY_VALUE)
        }.body<NetworkTeamsByCompetition>()
    }

    override suspend fun getBundesligaTeams() : NetworkTeamsByCompetition {
        return httpClient.get("$API_FOOTBALL_DATA/competitions/BL1/teams") {
            header(API_KEY_NAME, API_KEY_VALUE)
        }.body<NetworkTeamsByCompetition>()
    }


    override suspend fun getCompetitionMatches(competitionId : String, status: Int) : Matches {
        return httpClient.get("$API_FOOTBALL_DATA/competitions/$competitionId/matches") {
            header(API_KEY_NAME, API_KEY_VALUE)
            parameter("matchday", status)
        }.body<Matches>()
    }


   override suspend fun getTeams(limit: Int, offset: Int) : NetworkTeams {
        return httpClient.get("$API_FOOTBALL_DATA/teams") {
            header(API_KEY_NAME, API_KEY_VALUE)
            parameter("limit", limit)
            parameter("offset", offset)
        }.body<NetworkTeams>()
    }

    companion object {
        val log = logging()
    }
}
