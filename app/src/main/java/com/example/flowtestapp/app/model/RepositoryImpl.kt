package com.example.flowtestapp.app.model

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class RepositoryImpl @Inject constructor(): Repository {

    var numberFlow = MutableSharedFlow<Int>(
        replay = 1,
        extraBufferCapacity = 0,
        BufferOverflow.DROP_OLDEST
    )

    override fun listenCurrentNumber(): Flow<Int> = numberFlow

    override suspend fun getRandomNumber() {
        numberFlow.emit(Random.nextInt(100))
    }
}