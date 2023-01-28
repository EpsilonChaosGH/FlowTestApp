package com.example.flowtestapp.app.model

import com.example.flowtestapp.app.model.settings.AppSettings
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class RepositoryImpl @Inject constructor(
    private val appSettings: AppSettings
) : Repository {

    private var numberFlow = MutableStateFlow(appSettings.getCurrentNumber())

    override fun listenCurrentNumber(): Flow<Int> = numberFlow

    override suspend fun getRandomNumber() {
        val x = Random.nextInt(100)
        appSettings.setCurrentNumber(x)
        numberFlow.emit(x)
    }
}