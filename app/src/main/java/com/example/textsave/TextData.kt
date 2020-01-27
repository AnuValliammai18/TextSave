package com.example.textsave

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TextData(
    var text:String)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}