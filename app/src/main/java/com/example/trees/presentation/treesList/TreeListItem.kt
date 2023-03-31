package com.example.trees.presentation.treesList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.api.models.Tree
import com.example.trees.presentation.destinations.TreeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun TreeListItem(
    tree: Tree,
    navigator: DestinationsNavigator
) {
        Column(
            modifier = Modifier
                .padding(6.dp)
                .background(
                    MaterialTheme.colors.background
                )
        ) {
            Button(
                onClick = {
                    navigator.navigate(TreeScreenDestination(tree))
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
            ) {
                Text(
                    text = "${tree.espece}",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .fillMaxWidth()

                )
            }
        }

}