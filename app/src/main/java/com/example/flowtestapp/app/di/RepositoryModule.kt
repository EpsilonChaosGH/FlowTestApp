package com.example.flowtestapp.app.di

import com.example.flowtestapp.app.model.Repository
import com.example.flowtestapp.app.model.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(
    repositoryImpl: RepositoryImpl
    ): Repository
}