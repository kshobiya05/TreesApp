package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.api.models.DateConverter
import com.example.api.models.TreeEntity

@Database(
    entities = [TreeEntity::class],
    version = 2
)

//@TypeConveter(DateConverter::class)
abstract class TreeDatabase : RoomDatabase() {

    abstract val dao : Dao

    companion object {
    const val db_name = "tree_db"
    }
}