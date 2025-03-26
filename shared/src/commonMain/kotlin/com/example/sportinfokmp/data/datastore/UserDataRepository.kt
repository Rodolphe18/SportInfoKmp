package com.example.sportinfokmp.data.datastore


import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    val userData: Flow<UserData?>

    suspend fun setThemeBrand(themeBrand: ThemeBrand)

    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)

}