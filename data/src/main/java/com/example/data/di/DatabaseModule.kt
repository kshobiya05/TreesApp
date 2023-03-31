package com.example.data.di

import android.app.Application
import androidx.room.Room
import com.example.data.local.Dao
import com.example.data.local.TreeDatabase
import com.example.data.local.TreeDatabase.Companion.db_name
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideTreeDatabase(app: Application) : TreeDatabase {
    return Room.databaseBuilder(
    app, TreeDatabase::class.java,db_name
    ).build()
}
    @Singleton
    @Provides
    fun provideTreesDao(app: Application): Dao {
        return Room.databaseBuilder(
            app,
            TreeDatabase::class.java,
            db_name
        ).build().dao
    }
}