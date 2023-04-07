package com.example.api.usecase

import com.example.api.models.Tree
import com.example.api.Resource
import com.example.api.models.FetchStrategy
import kotlinx.coroutines.flow.Flow

interface GetTreeUseCase {
    suspend operator fun invoke(start: Int, rows : Int, fetchStrategy: FetchStrategy): Flow<Resource<List<Tree>>>
}