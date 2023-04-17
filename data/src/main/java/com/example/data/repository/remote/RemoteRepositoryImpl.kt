package com.example.data.repository.remote

import com.example.api.injection.Dependencies
import com.example.api.injection.DependencyInjection
import com.example.api.models.Tree
import com.example.api.repository.RemoteRepository
import com.example.data.remote.TreeApi
import com.example.data.remote.dto.toTree

class RemoteRepositoryImpl () : RemoteRepository {

    private val api = DependencyInjection.get<TreeApi>(Dependencies.Api.toString())
    override suspend fun getTrees(start: Int, rows: Int) : List<Tree> = api.getTrees(start,rows).records.map{ it.toTree() }

}