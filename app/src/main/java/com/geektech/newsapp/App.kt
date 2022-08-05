package com.geektech.newsapp

import android.app.Application
import androidx.room.Room
import com.geektech.newsapp.room.AppDatabase

class App : Application() {

    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db =
            Room.databaseBuilder(this, AppDatabase::class.java, "database").allowMainThreadQueries()
                .build()
    }
}