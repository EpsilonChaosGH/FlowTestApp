package com.example.flowtestapp.di

import android.content.Context
import androidx.room.Room
import com.example.flowtestapp.core_db.room.AppDatabase
import com.example.flowtestapp.core_db.room.dao.CounterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "Flow-Test-App-DB"
        ).build()

    @Provides
    @Singleton
    fun provideLocationDao(db: AppDatabase): CounterDao = db.counterDao()
}