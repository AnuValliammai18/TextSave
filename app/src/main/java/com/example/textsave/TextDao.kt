package com.example.textsave

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.w3c.dom.Text

@Dao
interface TextDao {

    @Insert
    suspend fun addText(textData:TextData)

    @Query("SELECT * FROM TextData ORDER By id DESC ")
    suspend fun getAllTexts():List<TextData>

    @Query("DELETE FROM TextData")
    suspend fun clearTable()
}