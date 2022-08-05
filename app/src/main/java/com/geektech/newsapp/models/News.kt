package com.geektech.newsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "news")
data class News(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    val title: String,
    val createdAd: Long
) : Serializable
