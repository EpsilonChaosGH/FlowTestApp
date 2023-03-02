package com.example.flowtestapp.core_data.mappers

import com.example.flowtestapp.core_data.models.Counter
import com.example.flowtestapp.core_db.room.entities.CounterDbEntity

fun CounterDbEntity.toCounter() = Counter(
    key = counter_key,
    number = number,
    testValueList = testValueList
)

fun Counter.toCounterDbEntity() = CounterDbEntity(
    counter_key = key,
    number = number,
    testValueList = testValueList
)