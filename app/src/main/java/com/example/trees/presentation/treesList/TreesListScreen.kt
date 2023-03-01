package com.example.trees.presentation.treesList.components.treesListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trees.presentation.treesList.TreesListViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun TreesListScreen(
    viewModel: TreesListViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
        val state by viewModel.dataState.collectAsState()
        Column (modifier = Modifier.background(MaterialTheme.colors.background)) {
            Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "LIST OF TREES",
                    style = MaterialTheme.typography.h6,
                    color = Color.White,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )
            Spacer(modifier = Modifier.size(10.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background, RoundedCornerShape(8.dp))
                ) {
                    items(state.data?.size ?: 0) {
                        Box(modifier = Modifier.padding(12.dp)) {
                            TreeListItem(tree = state.data.orEmpty()[it], navigator = navigator)
                        }
                    }
                }
        }
}