package com.example.domain.usecase

import com.example.api.models.Tree
import com.example.api.usecase.GetTreeUseCase
import com.example.api.Resource
import com.example.api.injection.Dependencies
import com.example.api.injection.DependencyInjection
import com.example.api.models.FetchStrategy
import com.example.api.models.toTree
import com.example.api.models.toTreeEntity
import com.example.api.repository.LocalRepository
import com.example.api.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetTreeUseCaseImpl() : GetTreeUseCase {

    private val RemoteRepository = DependencyInjection.get<RemoteRepository>(Dependencies.Remote.toString())
    private val LocalRepository = DependencyInjection.get<LocalRepository>(Dependencies.Local.toString())

override suspend operator fun invoke(start : Int, rows : Int, fetchStrategy: FetchStrategy): Flow<Resource<List<Tree>>> = flow {

       when (fetchStrategy) {

            FetchStrategy.Remote -> {
                try {
                    emit(Resource.Loading())
                    val trees = RemoteRepository.getTrees(start,rows)
                    LocalRepository.insertAll(trees.map { it.toTreeEntity() })
                    emit(Resource.Success(trees))
                    val localTreeList = LocalRepository.getAllTrees()

                    trees.forEach {
                    for(item in localTreeList) {
                        if (item.timestamp - System.currentTimeMillis() > 60 && item.id == it.id)
                        {
                            LocalRepository.reload(it.toTreeEntity())
                        }
                      }
                    }

                } catch (e: Exception) {
                    emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
                } catch (e: IOException) {
                    emit(
                        Resource.Error(
                            e.localizedMessage ?: "Internet error. Check your connection"
                        )
                    )
                }
            }

            FetchStrategy.Local -> {
                try {
                    emit(Resource.Loading())
                    val tree = LocalRepository.getLocalTrees(start, rows).map{ it.toTree() }
                    emit(Resource.Success(tree))
                    if(tree.isEmpty())
                    {
                        emit(Resource.Error("Connect to internet to charge more trees"))
                    }
                } catch (e: Exception) {
                    emit(Resource.Error(e.localizedMessage ?: "An error occurred"))
                } catch (e: IOException) {
                    emit(
                        Resource.Error(
                            e.localizedMessage ?: "Internet error. Check your connection"
                        )
                    )
                }
            }
        }
    }
}
