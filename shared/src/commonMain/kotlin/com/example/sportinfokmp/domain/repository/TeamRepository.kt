package com.example.sportinfokmp.domain.repository

import com.example.sportinfokmp.data.remote.api.SportInfoApi
import com.example.sportinfokmp.data.remote.dto.teams.asExternalModel
import com.example.sportinfokmp.domain.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.IO

class TeamRepository (private val sportInfoApi: SportInfoApi):TeamRepositoryInterface {


   override fun getTeamsList(offSet:Int): Flow<List<Team>> {
        return flow {
            val remoteTeamsList = try {
                val result =  sportInfoApi.getTeams(offset = offSet)
                result
            } catch (e: Exception) {
                null
            }
            remoteTeamsList?.let { remoteList ->
                emit(remoteList.teams.map { it.asExternalModel() }) }
        }.flowOn(Dispatchers.IO)
    }

   override fun getPremierLeagueTeams(): Flow<List<Team>> {
        return flow {
            val remoteTeamsList = try {
                sportInfoApi.getPremierLeagueTeams()
            } catch (e: Exception) {
                null
            }
            remoteTeamsList?.let { remoteList ->
                emit(remoteList.teams.map { it.asExternalModel() }) }
        }.flowOn(Dispatchers.IO)
    }

   override fun getLigue1Teams(): Flow<List<Team>> {
        return flow {
            val remoteTeamsList = try {
                sportInfoApi.getLigue1Teams()
            } catch (e: Exception) {
                null
            }
            remoteTeamsList?.let { remoteList ->
                emit(remoteList.teams.map { it.asExternalModel() }) }
        }.flowOn(Dispatchers.IO)
    }

   override fun getSerieATeams(): Flow<List<Team>> {
        return flow {
            val remoteTeamsList = try {
                sportInfoApi.getSerieATeams()
            } catch (e: Exception) {
                null
            }
            remoteTeamsList?.let { remoteList ->
                emit(remoteList.teams.map { it.asExternalModel() }) }
        }.flowOn(Dispatchers.IO)
    }

   override fun getLigaTeams(): Flow<List<Team>> {
        return flow {
            val remoteTeamsList = try {
                sportInfoApi.getLigaTeams()
            } catch (e: Exception) {
                null
            }
            remoteTeamsList?.let { remoteList ->
                emit(remoteList.teams.map { it.asExternalModel() }) }
        }.flowOn(Dispatchers.IO)
    }

   override fun getBundesligaTeams(): Flow<List<Team>> {
        return flow {
            val remoteTeamsList = try {
                sportInfoApi.getBundesligaTeams()
            } catch (e: Exception) {
                null
            }
            remoteTeamsList?.let { remoteList ->
                emit(remoteList.teams.map { it.asExternalModel() }) }
        }.flowOn(Dispatchers.IO)
    }

   override fun getPrimeiraDivisionTeams(): Flow<List<Team>> {
        return flow {
            val remoteTeamsList = try {
                sportInfoApi.getPrimeiraLigue()
            } catch (e: Exception) {
                null
            }
            remoteTeamsList?.let { remoteList ->
                emit(remoteList.teams.map { it.asExternalModel() }) }
        }.flowOn(Dispatchers.IO)
    }

}

interface TeamRepositoryInterface {

    fun getTeamsList(offSet: Int): Flow<List<Team>>
    fun getPremierLeagueTeams(): Flow<List<Team>>
    fun getLigue1Teams(): Flow<List<Team>>
    fun getSerieATeams(): Flow<List<Team>>
    fun getLigaTeams(): Flow<List<Team>>
    fun getBundesligaTeams(): Flow<List<Team>>
    fun getPrimeiraDivisionTeams(): Flow<List<Team>>
}