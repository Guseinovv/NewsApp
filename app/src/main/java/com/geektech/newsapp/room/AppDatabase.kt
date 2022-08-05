package com.geektech.newsapp.room

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.geektech.newsapp.models.News


@Database(entities = [News::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun dao(): Dao
}