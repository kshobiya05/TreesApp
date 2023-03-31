package com.example.data.remote.dto

data class Fields(
    val adresse: String,
    val arrondissement: String,
    val circonferenceencm: Int,
    val domanialite: String,
    val espece: String,
    val genre: String,
    val geo_point_2d: List<Double>,
    val hauteurenm: Int,
    val idbase: Int,
    val idemplacement: String,
    val libellefrancais: String,
    val remarquable: String,
    val typeemplacement: String,
    val varieteoucultivar: String
)