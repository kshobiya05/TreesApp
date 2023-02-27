package com.example.trees.domain.repository

import com.example.trees.domain.models.Tree

interface TreeRepository {
    suspend fun getTrees(): List<Tree>
}