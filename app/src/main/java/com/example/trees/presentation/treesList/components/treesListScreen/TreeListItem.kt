package com.example.trees.presentation.treesList.components.treesListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.trees.domain.models.Tree
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
                    .background(MaterialTheme.colors.primary, RoundedCornerShape(50.dp))
            ) {
                Text(
                    text = "${tree.espece} : ",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = "${tree.id}",
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
     }
}