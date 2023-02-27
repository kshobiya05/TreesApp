package com.example.trees.data.remote.dto

data class TreeFullInfo(
    val facet_groups: List<FacetGroup>,
    val nhits: Int,
    val parameters: Parameters,
    val records: List<Record>
)

