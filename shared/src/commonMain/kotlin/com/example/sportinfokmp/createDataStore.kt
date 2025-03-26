package com.example.sportinfokmp

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.okio.OkioStorage
import com.example.sportinfokmp.data.datastore.PreferenceSerializer
import okio.FileSystem
import okio.Path


internal const val DATA_STORE_FILE_NAME = "proto_datastore.preferences_pb"


fun createDataStore(
    fileSystem: FileSystem,
    producePath: () -> Path
): DataStore<UserPreferences> =
    DataStoreFactory.create(
        storage = OkioStorage(
            fileSystem = fileSystem,
            producePath = producePath,
            serializer = PreferenceSerializer,
        ),
    )