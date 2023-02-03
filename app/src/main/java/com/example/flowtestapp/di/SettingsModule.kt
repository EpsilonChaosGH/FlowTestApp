package com.example.flowtestapp.di

import com.example.flowtestapp.core_db.settings.AppSettings
import com.example.flowtestapp.core_db.settings.SharedPreferencesAppSettings
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {

    @Binds
    abstract fun binsAppSettings(
        sharedPreferencesAppSettings: SharedPreferencesAppSettings
    ): AppSettings
}