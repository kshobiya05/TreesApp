package com.example.domain.di

import com.example.api.repository.LocalRepository
import com.example.api.repository.RemoteRepository
import com.example.api.usecase.GetTreeUseCase
import com.example.domain.usecase.GetTreeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(RemoteRepository: RemoteRepository, LocalRepository: LocalRepository): GetTreeUseCase = GetTreeUseCaseImpl(RemoteRepository,LocalRepository)

}