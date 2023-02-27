package com.example.trees.data.repository

import com.example.trees.data.remote.TreeApi
import com.example.trees.data.remote.dto.toTree
import com.example.trees.domain.models.Tree
import com.example.trees.domain.repository.TreeRepository
import javax.inject.Inject


class TreeRepositoryImpl @Inject constructor(
    private val api: TreeApi
) : TreeRepository {

    override suspend fun getTrees(): List<Tree> {

    return api.getTrees().records.map { it.toTree() }

    }

}