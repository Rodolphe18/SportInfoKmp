package com.example.sportinfokmp.domain.repository


import com.example.sportinfokmp.data.remote.api.SportInfoApi
import com.example.sportinfokmp.data.remote.dto.matches.Match
import com.example.sportinfokmp.domain.model.Competition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class MatchRepository (private val sportInfoApi: SportInfoApi):MatchRepositoryInterface {

   override fun getTodayMatchList(): Flow<List<Match>> {
        return flow {
            val matches =
                try {
                    sportInfoApi.getTodayMatches().matches
                } catch (e: Exception) {
                    null
                }
            matches?.let {
                emit(it)
            }
        }.flowOn(Dispatchers.IO)
    }

   override fun getCompetitionMatchList(competitionId: String, matchDay:Int): Flow<List<Match>?> {
        return flow {
            val matches =
                try {
                    sportInfoApi.getCompetitionMatches(competitionId, matchDay).matches
                } catch (e: Exception) {
                    null
                }
            matches?.let {
                emit(it)
            }
        }.flowOn(Dispatchers.IO)
    }

}

interface MatchRepositoryInterface {

    fun getTodayMatchList(): Flow<List<Match>>
    fun getCompetitionMatchList(competitionId: String, matchDay:Int): Flow<List<Match>?>
}
