package com.example.flowtestapp.core_db.room.dao

import androidx.room.*
import com.example.flowtestapp.core_db.room.entities.CounterDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CounterDao {
    @Query("SELECT * FROM counter WHERE counter_key = :key")
    fun get(key: String): Flow<CounterDbEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg numbers: CounterDbEntity)

    @Query("DELETE FROM counter WHERE counter_key = :key")
    suspend fun delete(key: String)
}
