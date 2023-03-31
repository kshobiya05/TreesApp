package com.example.data.repository.remote

import com.example.api.models.Tree
import com.example.api.models.TreeEntity
import com.example.api.repository.RemoteRepository
import com.example.data.remote.TreeApi
import com.example.data.remote.dto.TreeResponse
import com.example.data.remote.dto.toTree
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor (

    private val api : TreeApi

) : RemoteRepository {

    override suspend fun getTrees(start: Int, rows: Int) : List<Tree> = api.getTrees(start,rows).records.map{ it.toTree() }

}