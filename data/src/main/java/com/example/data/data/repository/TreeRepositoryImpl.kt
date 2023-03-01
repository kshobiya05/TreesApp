package com.example.data.data.repository

import com.example.data.data.remote.TreeApi
import com.example.data.data.remote.dto.toTree
import com.example.domain.domain.models.Tree
import com.example.domain.domain.repository.TreeRepository
import javax.inject.Inject


class TreeRepositoryImpl @Inject constructor(
    private val api: TreeApi
) : TreeRepository {

    override suspend fun getTrees(): List<Tree> {
    return api.getTrees().records.map { it.toTree() }
    }

}