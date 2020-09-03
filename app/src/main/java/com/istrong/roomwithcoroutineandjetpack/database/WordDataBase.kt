package com.istrong.roomwithcoroutineandjetpack.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.istrong.roomwithcoroutineandjetpack.database.dao.WordDao
import com.istrong.roomwithcoroutineandjetpack.database.entity.Word

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = true)
public abstract class WordDataBase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: WordDataBase? = null

        fun getDatabase(context: Context): WordDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordDataBase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}