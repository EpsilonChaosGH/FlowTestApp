package com.example.flowtestapp.app.model

import kotlinx.coroutines.flow.Flow

interface Repository {

    fun listenCurrentNumber(): Flow<Int>

    suspend fun getRandomNumber()

}