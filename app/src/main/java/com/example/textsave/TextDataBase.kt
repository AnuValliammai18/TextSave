package com.example.textsave

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [TextData::class],
    version = 1)
abstract class TextDataBase :RoomDatabase() {
    abstract fun getTextDao():TextDao

    companion object {

        operator fun invoke(context: Context)=buildatabase(context)
        private fun buildatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TextDataBase::class.java,
            "textdatabase"
        ).build()

    }
}
