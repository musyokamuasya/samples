package io.ciox.word.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.ciox.word.domain.dao.WordDao
import io.ciox.word.domain.entity.Word

@Database(entities = [Word::class], version = 1, exportSchema = false)

    public abstract class WordRoomDatabase : RoomDatabase() {
        abstract fun wordDao(): WordDao

        companion object{
            private const val DB_NAME = "word_database"


            @Volatile
            private var INSTANCE:WordRoomDatabase? = null

            fun getInstance(context: Context):WordRoomDatabase{
                synchronized(this){
                    var instance = INSTANCE
                    if (instance == null){
                        instance = Room.databaseBuilder(context.applicationContext, WordRoomDatabase::class.java, DB_NAME)
                            .fallbackToDestructiveMigration()
                            .build()
                        INSTANCE = instance
                    }
                    return instance
                }

            }
        }
    }
