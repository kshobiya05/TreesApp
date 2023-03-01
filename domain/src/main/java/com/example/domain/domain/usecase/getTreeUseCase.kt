package com.example.domain.domain.usecase

import com.example.domain.domain.models.Tree
import com.example.domain.domain.repository.TreeRepository
import com.example.common.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class getTreeUseCase @Inject constructor(
    private val repository: TreeRepository
) {
    operator fun invoke(): Flow<Resource<List<Tree>>> = flow {
        try {
            emit(Resource.Loading<List<Tree>>())
            val tree = repository.getTrees()
            emit(Resource.Success<List<Tree>>(tree))
        } catch (e: Exception) {
            emit(Resource.Error<List<Tree>>(e.localizedMessage ?: "An error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error<List<Tree>>(
                    e.localizedMessage ?: "Internet error. Check your connection"
                )
            )
        }
    }
}