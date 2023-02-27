package com.example.trees.data.remote

import com.example.trees.data.remote.dto.TreeFullInfo
import retrofit2.http.GET

interface TreeApi {

    @GET("/api/records/1.0/search/?dataset=les-arbres&q=&rows=20&facet=domanialite&facet=arrondissement&facet=libellefrancais&facet=genre&facet=espece&facet=circonferenceencm&facet=hauteurenm&facet=remarquable")
    suspend fun getTrees() : TreeFullInfo
}