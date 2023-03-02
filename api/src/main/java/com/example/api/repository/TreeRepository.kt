package com.example.api.repository

import com.example.api.models.Tree

interface TreeRepository {
    suspend fun getTrees(): List<Tree>
}