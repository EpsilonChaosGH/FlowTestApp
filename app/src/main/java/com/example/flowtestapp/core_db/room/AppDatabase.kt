package com.example.flowtestapp.core_db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flowtestapp.core_db.room.dao.CounterDao
import com.example.flowtestapp.core_db.room.entities.CounterDbEntity

@Database(entities = [CounterDbEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun counterDao(): CounterDao
}