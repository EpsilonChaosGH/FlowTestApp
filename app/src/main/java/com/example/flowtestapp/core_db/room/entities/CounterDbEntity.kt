package com.example.flowtestapp.core_db.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "counter")
data class CounterDbEntity(
    @PrimaryKey val counter_key: String,
    @ColumnInfo(name = "number") val number: Int
)