package com.example.sportinfokmp.domain.repository

import com.example.sportinfokmp.data.remote.api.SportInfoApi
import com.example.sportinfokmp.data.remote.dto.competitions.asExternalModel
import com.example.sportinfokmp.domain.model.Competition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CompetitionRepository(private val sportInfoApi: SportInfoApi):CompetitionRepositoryInterface {

   override fun getCompetitionsList(): Flow<List<Competition>> {
        return flow {
            val remoteCompetitionsList = try {
                sportInfoApi.getCompetitions().competitions
            } catch (e: Exception) {
                null
            }
            remoteCompetitionsList?.let { remoteList ->
                emit(remoteList.map { it.asExternalModel() }) }
        }.flowOn(Dispatchers.IO)
    }
}

interface CompetitionRepositoryInterface {

    fun getCompetitionsList(): Flow<List<Competition>>
}

