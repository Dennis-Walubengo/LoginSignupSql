package com.walu.loginsignupsql.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.walu.loginsignupsql.model.NotesData

@Database(entities = [NotesData::class], version = 1)
abstract class NotesDb:RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object {
        private var database: NotesDb? = null

        fun getDataBase(context: Context): NotesDb {
            if (database == null) {
                database = Room
                    .databaseBuilder(context, NotesDb::class.java, "ContactDb")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as NotesDb
        }
    }
}