package com.example.trees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.api.injection.Dependencies
import com.example.api.injection.DependencyInjection
import com.example.api.repository.LocalRepository
import com.example.api.repository.RemoteRepository
import com.example.api.usecase.GetTreeUseCase
import com.example.data.di.ApiModule
import com.example.data.di.DatabaseModule
import com.example.data.local.Dao
import com.example.data.repository.local.LocalRepositoryImpl
import com.example.data.repository.remote.RemoteRepositoryImpl
import com.example.domain.usecase.GetTreeUseCaseImpl
import com.example.trees.di.ConnectionManagerModule
import com.example.trees.presentation.NavGraphs
import com.example.trees.presentation.theme.TreeAppTheme
import com.example.trees.presentation.treesList.TreesListViewModel
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerImplementation()

        setContent {
            TreeAppTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }

    private fun registerImplementation()
    {
        DependencyInjection.register(Dependencies.Database.toString(),DatabaseModule.provideTreeDao(applicationContext))
        DependencyInjection.register(Dependencies.Api.toString(),ApiModule.provideTreeApi())
        DependencyInjection.register(Dependencies.Network.toString(),ConnectionManagerModule.provideConnectionManager(applicationContext))
        DependencyInjection.register(Dependencies.Remote.toString(), RemoteRepositoryImpl())
        DependencyInjection.register(Dependencies.Local.toString(), LocalRepositoryImpl())
        DependencyInjection.register(Dependencies.UseCase.toString(), GetTreeUseCaseImpl())
        DependencyInjection.register(Dependencies.viewModel.toString(),TreesListViewModel())
    }
}