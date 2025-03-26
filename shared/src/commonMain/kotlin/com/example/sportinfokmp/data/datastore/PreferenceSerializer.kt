package com.example.sportinfokmp.data.datastore

import androidx.datastore.core.okio.OkioSerializer
import com.example.sportinfokmp.UserPreferences
import kotlinx.io.IOException
import okio.BufferedSink
import okio.BufferedSource

object PreferenceSerializer : OkioSerializer<UserPreferences> {
        override val defaultValue: UserPreferences
            get() = UserPreferences()

        override suspend fun readFrom(source: BufferedSource): UserPreferences {
            try {
                return UserPreferences.ADAPTER.decode(source)
            } catch (exception: IOException) {
                throw Exception(exception.message ?: "Serialization Exception")
            }
        }

        override suspend fun writeTo(t: UserPreferences, sink: BufferedSink) {
            sink.write(t.encode())
        }
}
