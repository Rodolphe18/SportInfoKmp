package com.example.sportinfokmp.data.remote.api

import com.example.sportinfokmp.data.remote.dto.competitions.NetworkCompetitions
import com.example.sportinfokmp.data.remote.dto.matches.Matches
import com.example.sportinfokmp.data.remote.dto.teams.NetworkTeams
import com.example.sportinfokmp.data.remote.dto.teams.NetworkTeamsByCompetition

interface SportInfoApi {

    suspend fun getCompetitions() : NetworkCompetitions

    suspend fun getCompetitionMatches(competitionId : String, status: Int) : Matches

    suspend fun getTodayMatches() : Matches

    suspend fun getTeams(limit: Int = 20, offset: Int) : NetworkTeams

    suspend fun getPremierLeagueTeams() : NetworkTeamsByCompetition

    suspend fun getLigaTeams() : NetworkTeamsByCompetition

    suspend fun getLigue1Teams() : NetworkTeamsByCompetition

    suspend fun getPrimeiraLigue() : NetworkTeamsByCompetition

    suspend fun getSerieATeams() : NetworkTeamsByCompetition

    suspend fun getBundesligaTeams() : NetworkTeamsByCompetition


}