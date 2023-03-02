package com.example.flowtestapp.core_data

import com.example.flowtestapp.core_data.mappers.toCounter
import com.example.flowtestapp.core_data.mappers.toCounterDbEntity
import com.example.flowtestapp.core_data.models.Counter
import com.example.flowtestapp.core_data.models.TestValue
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
        appDatabase.counterDao().insertAll(
            Counter(
                "NUMBER_KEY",
                Random.nextInt(100),
                listOf(
                    TestValue(
                        Random.nextInt(1000),
                        Random.nextInt(1000)
                    ),
                    TestValue(
                        Random.nextInt(100),
                        Random.nextInt(100)
                    ),
                    TestValue(
                        Random.nextInt(100),
                        Random.nextInt(100)
                    )
                )
            ).toCounterDbEntity()
        )
    }
}