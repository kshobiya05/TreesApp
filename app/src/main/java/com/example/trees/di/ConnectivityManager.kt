package com.example.trees.di

import android.content.Context
import com.example.trees.connection.NetworkStatusTracker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object ConnectivityManager {
    @Module
    @InstallIn(SingletonComponent::class)
    object ConnectionManagerModule {

        @Singleton
        @Provides
        fun provideConnectionManager(@ApplicationContext appContext: Context) : NetworkStatusTracker {
            return NetworkStatusTracker(appContext)
        }
    }
}