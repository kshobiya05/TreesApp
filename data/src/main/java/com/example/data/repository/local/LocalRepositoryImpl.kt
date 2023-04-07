package com.example.data.repository.local


import com.example.api.injection.Dependencies
import com.example.api.injection.DependencyInjection
import com.example.api.models.TreeEntity
import com.example.api.repository.LocalRepository
import com.example.data.local.Dao

class LocalRepositoryImpl () : LocalRepository {

    private val dao = DependencyInjection.get<Dao>(Dependencies.Database.toString())
    override suspend fun getLocalTrees(start : Int, rows : Int): List<TreeEntity> = dao.getTrees(start,rows)

    override suspend fun deleteTree(id : String) = dao.deleteTree(id)

    override suspend fun insertAll(list : List<TreeEntity>) = dao.insertAll(list)

    override suspend fun reload(tree : TreeEntity) = dao.updateTree(tree)

    override suspend fun getAllTrees(): List<TreeEntity> = dao.getAllTrees()

}
