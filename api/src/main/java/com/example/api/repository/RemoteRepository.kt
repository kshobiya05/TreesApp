package com.example.api.repository

import com.example.api.models.Tree

interface RemoteRepository {

    suspend fun getTrees(start : Int, rows : Int) : List<Tree>

}