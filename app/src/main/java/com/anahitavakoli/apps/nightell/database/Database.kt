package com.anahitavakoli.apps.nightell.database

import androidx.room.Room
import com.anahitavakoli.apps.nightell.config.AppConfig

object Database {

    val db = Room.databaseBuilder(AppConfig.applicationContext()
        ,FavoriteDatabase::class.java,"favorite.db")
        .allowMainThreadQueries().build()

}