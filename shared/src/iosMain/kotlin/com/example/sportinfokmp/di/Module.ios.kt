package com.example.sportinfokmp.di


import com.example.sportinfokmp.DATA_STORE_FILE_NAME
import com.example.sportinfokmp.createDataStore
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import kotlinx.cinterop.ExperimentalForeignApi
import okio.FileSystem
import okio.Path.Companion.toPath
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask


actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { Darwin.create() }
    }

actual val preferenceModule: Module = module {
    @OptIn(ExperimentalForeignApi::class)
    val producePath = {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        requireNotNull(documentDirectory).path + "/$DATA_STORE_FILE_NAME"
    }
    single { createDataStore(fileSystem = FileSystem.SYSTEM, producePath = { producePath().toPath() }) }
}
