package com.geektech.newsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.geektech.newsapp.models.News

@Dao
interface Dao {
    @Query("SELECT*FROM news order by createdAd")
    fun getAll(): List<News>

    @Insert
    fun insert(news: News)

    @Delete(entity = News::class)
    fun delete(news: News)

    @Query("SELECT * FROM news WHERE title LIKE '%'||:search|| '%'")
    fun getSearch(search: String): List<News>
}