package com.example.android.navigation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuizzesData::class], version = 1, exportSchema = false)

abstract class QuizzesDatabase : RoomDatabase() {

    abstract val questionDataDao: questionDataDao

    companion object {
        @Volatile
        private var INSTANCE: QuizzesDatabase? = null
        fun getInstance(context: Context): QuizzesDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            QuizzesDatabase::class.java,
                            "quizzes_database"
                    )
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
