package com.example.trees.connection

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import com.example.api.models.FetchStrategy
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NetworkStatusTracker(context: Context) {

    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    var isConnected = false

    init {
        getConnection()
    }
    private fun getConnection()  {

        connectivityManager.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
            override fun onUnavailable() {
                println("onUnavailable")
               // launch(NetworkStatus.Unavailable)
                isConnected = false
            }

            override fun onAvailable(network: Network) {
                println("onAvailable")
              //  offer(NetworkStatus.Available)
                isConnected = true
            }

            override fun onLost(network: Network) {
                println("onLost")
             //   offer(NetworkStatus.Unavailable)
                isConnected = false
            }
        })

    }

}
@FlowPreview
    inline fun <FetchStrategy> Flow<NetworkStatus>.map(
        crossinline onUnavailable: suspend() -> FetchStrategy,
        crossinline onAvailable: suspend () -> FetchStrategy,
    ): Flow<FetchStrategy> = map { status ->
        when (status) {
            NetworkStatus.Unavailable -> onUnavailable()
            NetworkStatus.Available -> onAvailable()
        }
    }

@FlowPreview
inline fun <FetchStrategy> Flow<NetworkStatus>.flatMap(
    crossinline onUnavailable: suspend () -> Flow<FetchStrategy>,
    crossinline onAvailable: suspend () -> Flow<FetchStrategy>,
): Flow<FetchStrategy> = flatMapConcat { status ->
    when (status) {
        NetworkStatus.Unavailable -> onUnavailable()
        NetworkStatus.Available -> onAvailable()
    }
}

