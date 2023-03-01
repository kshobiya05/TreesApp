package com.example.domain.usecase

import com.example.common.common.Resource
import com.example.domain.models.Tree
import com.example.domain.repository.TreeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class getTreeUseCase @Inject constructor(
    private val repository: com.example.domain.repository.TreeRepository
) {
    operator fun invoke(): Flow<Resource<List<com.example.domain.models.Tree>>> = flow {
        try {
            emit(Resource.Loading<List<com.example.domain.models.Tree>>())
            val tree = repository.getTrees()
            emit(Resource.Success<List<com.example.domain.models.Tree>>(tree))
        } catch (e: Exception) {
            emit(Resource.Error<List<com.example.domain.models.Tree>>(e.localizedMessage ?: "An error occurred"))
        } catch (e: IOException) {
            emit(
                Resource.Error<List<com.example.domain.models.Tree>>(
                    e.localizedMessage ?: "Internet error. Check your connection"
                )
            )
        }
    }
}