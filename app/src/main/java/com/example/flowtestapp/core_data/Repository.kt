package com.example.flowtestapp.core_data

import com.example.flowtestapp.core_data.models.Counter
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun listenCurrentNumber(): Flow<Counter?>

    suspend fun getRandomNumber()

}