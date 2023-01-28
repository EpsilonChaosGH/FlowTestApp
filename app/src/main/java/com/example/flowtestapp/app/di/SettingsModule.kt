package com.example.flowtestapp.app.di

import com.example.flowtestapp.app.model.settings.AppSettings
import com.example.flowtestapp.app.model.settings.SharedPreferencesAppSettings
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