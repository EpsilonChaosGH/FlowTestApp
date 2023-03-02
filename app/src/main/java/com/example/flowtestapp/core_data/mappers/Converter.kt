package com.example.flowtestapp.core_data.mappers

import androidx.room.TypeConverter
import com.example.flowtestapp.core_data.models.TestValue
import com.google.gson.Gson


class Converter {

    @TypeConverter
    fun listToJsonString(value: List<TestValue>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<TestValue>::class.java).toList()
}