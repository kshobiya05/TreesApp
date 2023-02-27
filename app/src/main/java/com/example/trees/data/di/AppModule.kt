package com.example.trees.data.di

import com.example.trees.data.remote.TreeApi
import com.example.trees.data.repository.TreeRepositoryImpl
import com.example.trees.domain.repository.TreeRepository
import com.example.trees.domain.usecase.getTreeUseCase
import com.example.trees.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTreeApi(): TreeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TreeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTreeRepository(api: TreeApi): TreeRepository {
        return TreeRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: TreeRepository): getTreeUseCase {
        return getTreeUseCase(repository)
    }

}