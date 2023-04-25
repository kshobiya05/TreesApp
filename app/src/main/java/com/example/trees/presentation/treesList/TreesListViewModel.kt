package com.example.trees.presentation.treesList

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.Resource
import com.example.api.injection.Dependencies
import com.example.api.injection.DependencyInjection
import com.example.api.models.FetchStrategy
import com.example.api.models.Tree
import com.example.api.usecase.GetTreeUseCase
import com.example.trees.connection.NetworkStatusTracker
import com.example.trees.util.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TreesListViewModel () : ViewModel() {

    private val connectivityManager = DependencyInjection.get<NetworkStatusTracker>(Dependencies.Network.toString())
    private val getTreesUseCase = DependencyInjection.get<GetTreeUseCase>(Dependencies.UseCase.toString())

    var dataState : MutableStateFlow<DataState<List<Tree>>> = MutableStateFlow(DataStateIdle(emptyList()))
    private var index : Int = 0
    var endOfgroup = mutableStateOf(false)
    var endList : Boolean = false
    var isError : Boolean = false
    var isLoading : Boolean = false

    init {
             fetchTrees()
         }
  fun fetchTrees() {
      viewModelScope.launch {
          Log.d("OMG","fetch : ${getFetchStrategy()}")
              getTreesUseCase.invoke(
                  index * Constants.NUMBER_OF_ITEMS,
                  Constants.NUMBER_OF_ITEMS,
                  getFetchStrategy()
              ).collect {
                  val newList = mutableListOf<Tree>()
                  endList = false
                  when (it) {
                      is Resource.Success -> {
                          dataState.value.data?.let { daList -> newList.addAll(daList) }
                          it.data?.let { daList -> newList.addAll(daList) }
                          dataState.value = DataStateSuccess(newList)
                          endOfgroup.value = index * Constants.NUMBER_OF_ITEMS >= newList.size
                      }
                      is Resource.Error -> {
                          DataStateError(it.data)
                          isError = true
                      }
                      is Resource.Loading -> {
                          DataStateLoading(it.data)
                          isLoading = true
                      }
                  }
                  isLoading = false
                  isError = false
                  index += 1
                  endList = true
              }
         }
    }

    private fun getFetchStrategy() : FetchStrategy {
        return when(connectivityManager.isConnected) {
            true -> FetchStrategy.Remote
            false -> FetchStrategy.Local
        }
    }
}



