package com.example.domain.repository

import com.example.domain.models.Tree

interface TreeRepository {
    suspend fun getTrees(): List<com.example.domain.models.Tree>
}