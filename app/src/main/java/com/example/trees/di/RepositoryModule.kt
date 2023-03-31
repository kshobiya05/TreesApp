package com.example.trees.di

import com.example.api.repository.LocalRepository
import com.example.api.repository.RemoteRepository
import com.example.data.local.TreeDatabase
import com.example.data.remote.TreeApi
import com.example.data.repository.local.LocalRepositoryImpl
import com.example.data.repository.remote.RemoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLocalTreeRepository(db : TreeDatabase): LocalRepository = LocalRepositoryImpl(db.dao)

    @Provides
    @Singleton
    fun provideRemoteTreeRepository(api : TreeApi): RemoteRepository = RemoteRepositoryImpl(api)


}