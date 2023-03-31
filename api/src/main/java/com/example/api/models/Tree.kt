package com.example.api.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tree (
    val id: String,
    val adresse: String,
    val circonferenceencm: Int,
    val espece: String,
    val hauteurenm: Int
) : Parcelable

    fun Tree.toTreeEntity() : TreeEntity = TreeEntity (
        id = id,
        adresse = adresse,
        circonferenceencm = circonferenceencm,
        hauteurenm = hauteurenm,
        espece = espece,
        timestamp = System.currentTimeMillis()
    )

    fun TreeEntity.toTree() : Tree = Tree (
        id = id,
        adresse = adresse,
        circonferenceencm = circonferenceencm,
        hauteurenm = hauteurenm,
        espece = espece
    )