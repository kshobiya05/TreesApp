package com.example.data.local

import androidx.room.*
import com.example.api.models.TreeEntity

@androidx.room.Dao
interface Dao {

    @Query("SELECT * FROM TreeEntity LIMIT :start, :rows")
    suspend fun getTrees(start :Int, rows : Int): List<TreeEntity>

    @Query("SELECT * FROM TreeEntity")
    suspend fun getAllTrees(): List<TreeEntity>

    @Query("DELETE FROM TreeEntity WHERE id= :tree_id")
    suspend fun deleteTree(tree_id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(myEntities: List<TreeEntity>)

    @Update
    suspend fun updateTree(tree: TreeEntity)

}