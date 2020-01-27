package com.example.textsave

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.w3c.dom.Text


@Database(
    entities = [TextData::class],
    version = 1)
abstract class TextDataBase :RoomDatabase() {
    abstract fun getTextDao():TextDao

    companion object {

        private var instance: TextDataBase? = null
        operator fun invoke(context: Context): TextDataBase {
            if (instance != null)
                return instance as TextDataBase
            else {
                instance = buildatabase(context)
                return instance as TextDataBase
            }
        }

        private fun buildatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TextDataBase::class.java,
            "textdatabase"
        ).build()
    }
}
