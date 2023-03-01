package com.example.trees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.trees.presentation.NavGraphs
import com.example.trees.presentation.theme.TreeAppTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            TreeAppTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}