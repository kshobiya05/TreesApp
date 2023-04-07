package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.Dao
import com.example.data.local.TreeDatabase

object DatabaseModule {
    fun provideTreeDao(context: Context): Dao {
        return Room.databaseBuilder(
            context,
            TreeDatabase::class.java,
            TreeDatabase.db_name
        ).build().dao
    }

}