package com.example.domain.usecase

import com.example.api.models.Tree
import com.example.api.repository.TreeRepository
import com.example.api.usecase.GetTreeUseCase
import com.example.api.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetTreeUseCaseImpl @Inject constructor(
    private val repository: TreeRepository
) : GetTreeUseCase {

override suspend operator fun invoke(): Flow<Resource<List<Tree>>> = flow {
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