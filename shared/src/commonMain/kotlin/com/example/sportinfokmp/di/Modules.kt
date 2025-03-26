package com.example.sportinfokmp.di

import com.example.sportinfokmp.data.datastore.UserDataRepository
import com.example.sportinfokmp.data.remote.api.HttpClientFactory
import com.example.sportinfokmp.data.remote.api.SportInfoApi
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.example.sportinfokmp.data.remote.api.SportInfoDataSource
import com.example.sportinfokmp.data.datastore.DefaultUserDataRepository
import com.example.sportinfokmp.ui.competitions.matches.PagerViewmodel
import com.example.sportinfokmp.ui.competitions.CompetitionListViewModel
import com.example.sportinfokmp.ui.search.SearchViewModel
import com.example.sportinfokmp.ui.settings.SettingsViewModel
import com.example.sportinfokmp.ui.teams.TeamsByChampionshipViewModel
import com.example.sportinfokmp.ui.teams.TeamsListViewModel
import com.example.sportinfokmp.ui.today.TodayViewModel
import com.example.sportinfokmp.domain.repository.MatchRepository
import com.example.sportinfokmp.domain.repository.CompetitionRepository
import com.example.sportinfokmp.domain.repository.TeamRepository
import com.example.sportinfokmp.domain.repository.MatchRepositoryInterface
import com.example.sportinfokmp.domain.repository.CompetitionRepositoryInterface
import com.example.sportinfokmp.domain.repository.TeamRepositoryInterface
import com.example.sportinfokmp.ui.search.SearchContentsRepository
import com.example.sportinfokmp.ui.search.SearchContentsImpl

expect val platformModule: Module

expect val preferenceModule: Module

val sharedModule = module {

    single { HttpClientFactory.create(get()) }
    singleOf(::DefaultUserDataRepository).bind<UserDataRepository>()
    singleOf(::SportInfoDataSource).bind<SportInfoApi>()
    singleOf(::MatchRepository).bind<MatchRepositoryInterface>()
    singleOf(::CompetitionRepository).bind<CompetitionRepositoryInterface>()
    singleOf(::TeamRepository).bind<TeamRepositoryInterface>()
    singleOf(::SearchContentsImpl).bind<SearchContentsRepository>()
    viewModelOf(::PagerViewmodel)
    viewModelOf(::CompetitionListViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::TeamsByChampionshipViewModel)
    viewModelOf(::TeamsListViewModel)
    viewModelOf(::TodayViewModel)
}