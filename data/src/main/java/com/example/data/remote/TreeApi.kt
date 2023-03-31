package com.example.data.remote

import com.example.data.remote.dto.TreeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TreeApi {

    @GET("api/records/1.0/search/?dataset=les-arbres&q=&facet=typeemplacement&facet=domanialite&facet=arrondissement&facet=libellefrancais&facet=genre&facet=espece&facet=circonferenceencm&facet=hauteurenm")
    suspend fun getTrees(@Query("start") start:Int, @Query("rows") rows : Int) : TreeResponse

    @GET("api/records/1.0/search/?dataset=les-arbres&q=&facet=domanialite&facet=arrondissement&facet=libellefrancais&facet=genre&facet=espece&facet=circonferenceencm&facet=hauteurenm&facet=recordid")
    suspend fun getTreeToUpdate(@Query("recordid") treeid: String) : TreeResponse
}
