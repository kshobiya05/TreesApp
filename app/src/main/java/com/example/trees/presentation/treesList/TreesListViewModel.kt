package com.example.trees.presentation.treesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.Resource
import com.example.common.common.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TreesListViewModel @Inject constructor(
    private val getTreesUseCase: com.example.domain.usecase.GetTreeUseCaseImpl
) : ViewModel() {
    var dataState: MutableStateFlow<DataState<List<com.example.api.models.Tree>>> = MutableStateFlow(
        DataStateIdle(emptyList())
    )

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