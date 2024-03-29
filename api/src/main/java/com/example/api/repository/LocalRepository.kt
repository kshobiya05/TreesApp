package com.example.api.repository

import com.example.api.models.Tree
import com.example.api.models.TreeEntity

interface LocalRepository {

    suspend fun getLocalTrees(start :Int, rows : Int) : List<TreeEntity>

    suspend fun deleteTree(id: String)

    suspend fun insertAll(list :List<TreeEntity>)

    suspend fun reload(tree: TreeEntity)

    suspend fun getAllTrees() : List<TreeEntity>

}