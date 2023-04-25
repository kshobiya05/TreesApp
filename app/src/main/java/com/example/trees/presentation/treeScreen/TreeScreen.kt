package com.example.trees.presentation.treeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.api.models.Tree
import com.example.trees.presentation.destinations.MapScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun TreeScreen(
    tree: Tree,
    navigator: DestinationsNavigator
) {     tree.let {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    item {
                            Spacer(modifier = Modifier.size(200.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth()
                                    .background(MaterialTheme.colors.surface, RoundedCornerShape(30.dp)),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = "ESPECE : ${it.espece}",
                                    style = MaterialTheme.typography.caption,
                                    color = Color.White,
                                    modifier = Modifier
                                        .background(MaterialTheme.colors.background)
                                        .padding(30.dp),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.size(15.dp))
                                Text(
                                    text = "Reférence : ${it.id}",
                                    style = MaterialTheme.typography.button,
                                    color = Color.White,
                                    modifier = Modifier
                                        .padding(5.dp),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                        text = "Hauteur : ${it.hauteurenm} m",
                                        style = MaterialTheme.typography.button,
                                        color = Color.White,
                                        modifier = Modifier
                                            .padding(5.dp),
                                        textAlign = TextAlign.Center
                                    )
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                        text = "Circonference : ${it.circonferenceencm} cm",
                                        style = MaterialTheme.typography.button,
                                        color = Color.White,
                                        modifier = Modifier
                                            .padding(5.dp),
                                        textAlign = TextAlign.Center
                                    )
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = "Adresse : ${it.adresse}",
                                    style = MaterialTheme.typography.button,
                                    color = Color.White,
                                    modifier = Modifier
                                        .padding(5.dp),
                                    textAlign = TextAlign.Center
                                )
                         }
                    }
                }
            }
    FloatingActionButton(
        onClick = {navigator.navigate (MapScreenDestination(tree)) },
        content = { Icon(Icons.Filled.Search, null) },
        backgroundColor = Color.White,
        modifier = Modifier.padding(10.dp)
    )
}

