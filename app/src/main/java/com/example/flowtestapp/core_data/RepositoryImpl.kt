package com.example.flowtestapp.core_data

import com.example.flowtestapp.core_data.mappers.toCounter
import com.example.flowtestapp.core_data.mappers.toCounterDbEntity
import com.example.flowtestapp.core_data.models.Counter
import com.example.flowtestapp.core_db.settings.AppSettings
import com.example.flowtestapp.core_db.room.AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class RepositoryImpl @Inject constructor(
    private val appSettings: AppSettings,
    private val appDatabase: AppDatabase
) : Repository {

    override fun listenCurrentNumber(): Flow<Counter?> {
        return appDatabase.counterDao().get("NUMBER_KEY").map { counterDbEntity ->
            counterDbEntity?.toCounter()
        }
    }

    override suspend fun getRandomNumber() {
        val x = Random.nextInt(100)
        appDatabase.counterDao().insertAll(Counter("NUMBER_KEY", x).toCounterDbEntity())
    }
}