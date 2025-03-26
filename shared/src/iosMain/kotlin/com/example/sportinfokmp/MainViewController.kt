package com.example.sportinfokmp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.sportinfokmp.ui.App
import com.example.sportinfokmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }