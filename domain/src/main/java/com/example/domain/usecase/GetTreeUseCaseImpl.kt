package com.example.domain.usecase

import com.example.api.models.Tree
import com.example.api.usecase.GetTreeUseCase
import com.example.api.Resource
import com.example.api.models.FetchStrategy
import com.example.api.models.toTree
import com.example.api.models.toTreeEntity
import com.example.api.repository.LocalRepository
import com.example.api.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetTreeUseCaseImpl @Inject constructor (
    private val RemoteRepository: RemoteRepository,
    private val LocalRepository: LocalRepository
) : GetTreeUseCase {

override suspend operator fun invoke(start : Int, rows : Int, fetchStrategy: FetchStrategy): Flow<Resource<List<Tree>>> = flow {

       when (fetchStrategy) {
            FetchStrategy.Remote -> {
                try {
                    emit(Resource.Loading<List<Tree>>())
                    val trees = RemoteRepository.getTrees(start,rows)
                    LocalRepository.insertAll(trees.map { it.toTreeEntity() })
                    emit(Resource.Success<List<Tree>>(trees))
                    val localTreeList = LocalRepository.getAllTrees()

                    trees.forEach {
                    for(item in localTreeList) {
                        if ( item.timestamp - System.currentTimeMillis() > 60 && item.id == it.id)
                        {
                            LocalRepository.reload(it.toTreeEntity())
                            println("db reloaded")
                        }
                      }
                    }

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

            FetchStrategy.Local -> {
                try {
                    emit(Resource.Loading<List<Tree>>())
                    val tree = LocalRepository.getLocalTrees(start, rows).map{ it.toTree() }
                    emit(Resource.Success<List<Tree>>(tree))
                    if(tree.isEmpty())
                    {
                        emit(Resource.Error<List<Tree>>("Connect to internet to charge more trees"))
                    }
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
    }
}
