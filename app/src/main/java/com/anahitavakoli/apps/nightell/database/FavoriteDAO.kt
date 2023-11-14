package com.anahitavakoli.apps.nightell.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.anahitavakoli.apps.nightell.model.Audio

@Dao
interface FavoriteDAO {

    @Insert
    fun addAudio(audio : Audio) : Long

    @Query("select * from audio")
    fun showFavorites() : List<Audio>

    @Query("SELECT Exists(SELECT * FROM audio WHERE id= :id)")
    fun isAudioExist(id : String) : Boolean

    @Delete
    fun delete(audio: Audio)
}