package com.example.sportinfokmp.di

import com.example.sportinfokmp.DATA_STORE_FILE_NAME
import com.example.sportinfokmp.createDataStore
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import okio.FileSystem
import okio.Path.Companion.toPath
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { OkHttp.create() } }

actual val preferenceModule: Module = module {
    single {
        val producePath = { androidContext().filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath.toPath() }
        createDataStore(fileSystem = FileSystem.SYSTEM, producePath = producePath) }
}


