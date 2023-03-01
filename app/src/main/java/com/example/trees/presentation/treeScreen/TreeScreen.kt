package com.example.trees.presentation.treeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.domain.models.Tree
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun TreeScreen(
    tree: com.example.domain.models.Tree
) {     tree.let {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    item {
                            Spacer(modifier = Modifier.size(200.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth()
                                    .background(Color.White, RoundedCornerShape(30.dp)),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = "Espèce : ${it.espece}",
                                    style = MaterialTheme.typography.caption,
                                    color = Color.Black,
                                    modifier = Modifier
                                        .background(MaterialTheme.colors.surface, RoundedCornerShape(60.dp))
                                        .padding(30.dp),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.size(15.dp))
                                Text(
                                    text = "Reference : ${it.id}",
                                    style = MaterialTheme.typography.button,
                                    color = MaterialTheme.colors.primaryVariant,
                                    modifier = Modifier
                                        .background(Color.White, RoundedCornerShape(10.dp))
                                        .padding(5.dp),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                        text = "Hauteur : ${it.hauteurenm} m",
                                        style = MaterialTheme.typography.button,
                                        color = MaterialTheme.colors.primaryVariant,
                                        modifier = Modifier
                                            .background(Color.White, RoundedCornerShape(10.dp))
                                            .padding(5.dp),
                                        textAlign = TextAlign.Center
                                    )
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                        text = "Circonference : ${it.circonferenceencm} cm",
                                        style = MaterialTheme.typography.button,
                                        color = MaterialTheme.colors.primaryVariant,
                                        modifier = Modifier
                                            .background(Color.White, RoundedCornerShape(10.dp))
                                            .padding(5.dp),
                                        textAlign = TextAlign.Center
                                    )
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(
                                    text = "Adresse : ${it.adresse}",
                                    style = MaterialTheme.typography.button,
                                    color = MaterialTheme.colors.primaryVariant,
                                    modifier = Modifier
                                        .background(Color.White, RoundedCornerShape(10.dp))
                                        .padding(5.dp),
                                    textAlign = TextAlign.Center
                                )
                         }
                    }
                }
            }
}

