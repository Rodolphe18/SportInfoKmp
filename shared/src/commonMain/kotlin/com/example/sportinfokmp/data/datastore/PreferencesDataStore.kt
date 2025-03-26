package com.example.sportinfokmp.data.datastore

import androidx.datastore.core.DataStore
import com.example.sportinfokmp.DarkThemeConfigProto
import com.example.sportinfokmp.ThemeBrandProto
import com.example.sportinfokmp.UserPreferences
import kotlinx.coroutines.flow.map

class PreferencesDataSource (
    private val userPreferences: DataStore<UserPreferences>,
) {
    val userData = userPreferences.data
        .map {
            UserData(
                themeBrand = when (it.theme_brand) {
                    ThemeBrandProto.THEME_BRAND_UNSPECIFIED,
                    ThemeBrandProto.THEME_BRAND_DEFAULT -> ThemeBrand.DEFAULT
                    ThemeBrandProto.THEME_BRAND_ANDROID -> ThemeBrand.ANDROID
                },
                darkThemeConfig = when (it.dark_theme_config) {
                    DarkThemeConfigProto.DARK_THEME_CONFIG_UNSPECIFIED,
                    DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM,
                        ->
                        DarkThemeConfig.FOLLOW_SYSTEM
                    DarkThemeConfigProto.DARK_THEME_CONFIG_LIGHT ->
                        DarkThemeConfig.LIGHT
                    DarkThemeConfigProto.DARK_THEME_CONFIG_DARK -> DarkThemeConfig.DARK
                }
            )
        }



    suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        userPreferences.updateData {
            when (themeBrand) {
                    ThemeBrand.DEFAULT -> UserPreferences(ThemeBrandProto.THEME_BRAND_DEFAULT)
                    ThemeBrand.ANDROID -> UserPreferences(ThemeBrandProto.THEME_BRAND_ANDROID)
                }
            }
    }


    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        userPreferences.updateData {
            when (darkThemeConfig) {
                    DarkThemeConfig.FOLLOW_SYSTEM ->
                       UserPreferences(ThemeBrandProto.THEME_BRAND_DEFAULT, DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM)
                    DarkThemeConfig.LIGHT -> UserPreferences(ThemeBrandProto.THEME_BRAND_DEFAULT,DarkThemeConfigProto.DARK_THEME_CONFIG_LIGHT)
                    DarkThemeConfig.DARK -> UserPreferences(ThemeBrandProto.THEME_BRAND_DEFAULT,DarkThemeConfigProto.DARK_THEME_CONFIG_DARK)
                }
            }
        }
}