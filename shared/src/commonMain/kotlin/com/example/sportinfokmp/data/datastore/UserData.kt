package com.example.sportinfokmp.data.datastore

data class UserData(
    val themeBrand: ThemeBrand,
    val darkThemeConfig: DarkThemeConfig
)

enum class ThemeBrand {
    DEFAULT,
    ANDROID,
}

enum class DarkThemeConfig {
    FOLLOW_SYSTEM,
    LIGHT,
    DARK,
}