package com.example.data.remote.dto

import com.example.api.models.Tree

data class Record(
    val datasetid: String,
    val fields: Fields,
    val geometry: Geometry,
    val record_timestamp: String,
    val recordid: String
)

fun Record.toTree(): Tree = Tree (
    id = recordid,
    adresse = "${fields.adresse}, ${fields.arrondissement}",
    circonferenceencm = fields.circonferenceencm,
    hauteurenm = fields.hauteurenm,
    espece = fields.espece
)
