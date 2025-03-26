package com.example.sportinfokmp.data.datastore

import kotlinx.coroutines.flow.Flow


class DefaultUserDataRepository(private val preferencesDataSource: PreferencesDataSource):
    UserDataRepository {

   override val userData: Flow<UserData?> = preferencesDataSource.userData

    override suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        preferencesDataSource.setThemeBrand(themeBrand)
    }

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
      preferencesDataSource.setDarkThemeConfig(darkThemeConfig)
    }

}