package com.example.domain.domain.repository

import com.example.domain.domain.models.Tree

interface TreeRepository {
    suspend fun getTrees(): List<Tree>
}