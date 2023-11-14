package com.anahitavakoli.apps.nightell.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anahitavakoli.apps.nightell.model.Audio

@Database(entities = [Audio::class], version = 1)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract fun favoriteDao() : FavoriteDAO
}