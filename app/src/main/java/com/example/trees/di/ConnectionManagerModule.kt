package com.example.trees.di

import android.content.Context
import com.example.trees.connection.NetworkStatusTracker

object ConnectionManagerModule {
 fun provideConnectionManager(appContext: Context) : NetworkStatusTracker {
            return NetworkStatusTracker(appContext)
        }
}
