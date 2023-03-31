package com.example.api.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.api.models.Tree
import java.sql.Timestamp
import java.util.*

@Entity
data class TreeEntity (
  @PrimaryKey  (autoGenerate = false)
    val id : String,
    val adresse : String,
    val circonferenceencm : Int,
    val espece : String,
    val hauteurenm : Int,
    val timestamp : Long
)