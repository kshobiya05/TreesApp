package com.example.trees.presentation.treesList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.api.injection.Dependencies
import com.example.api.injection.DependencyInjection
import com.example.trees.presentation.map.addMarker
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Marker
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun TreesListScreen(
    navigator: DestinationsNavigator
) {
    val viewModel = DependencyInjection.get<TreesListViewModel>(Dependencies.ViewModel.toString())
    val state by viewModel.dataState.collectAsState()
    val isLoading = remember { viewModel.isLoading }
    val isError = remember { viewModel.isError }
    val endOfgroup by remember { viewModel.endOfgroup }
    val mapviewModel = DependencyInjection.get<MapViewModel>(Dependencies.MapviewModel.toString())


    Column(modifier = Modifier.background(MaterialTheme.colors.background)) {

        BottomNavigationPreview(navigator)

        Spacer(modifier = Modifier.size(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Text(
                text = "LIST OF TREES",
                style = MaterialTheme.typography.h6,
                color = Color.White,
                modifier = Modifier
                    .background(MaterialTheme.colors.primaryVariant)
                    .padding(10.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.size(10.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background, RoundedCornerShape(8.dp))
        ) {
            items(state.data?.size ?: 0) {
                if (it >= (state.data?.size?.minus(1) ?: 0) && endOfgroup) {
                    viewModel.fetchTrees()
                }
                val tree = state.data.orEmpty()[it]
                Box(modifier = Modifier.padding(12.dp)) {
                    TreeListItem(tree = tree, navigator = navigator)
                }
            }
        }
        val markerOptionsList = state.data.orEmpty().map { tree ->
            addMarker(LocalContext.current, tree.adresse)
        }
        mapviewModel.updateMarkers(markerOptionsList)
    }
    if (isError) {
        Text(
            text = "an error occurred",
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
    if (isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }
}


