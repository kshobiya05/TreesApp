package com.example.trees.presentation.treesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trees.common.*
import com.example.trees.domain.models.Tree
import com.example.trees.domain.usecase.getTreeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TreesListViewModel @Inject constructor(
    private val getTreesUseCase: getTreeUseCase
) : ViewModel() {
    var dataState: MutableStateFlow<DataState<List<Tree>>> = MutableStateFlow(DataStateIdle(emptyList()))

    init {
        fetchTrees()
    }

    private fun fetchTrees() {
        viewModelScope.launch {
            getTreesUseCase().collect {
                when (it) {
                    is Resource.Success -> {
                        dataState.value = DataStateSuccess(it.data)
                    }
                    is Resource.Error -> {
                        DataStateError(it.data)
                    }
                    is Resource.Loading -> {
                        DataStateLoading(it.data)
                    }
                }
            }
        }
    }
}