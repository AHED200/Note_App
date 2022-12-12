package com.example.noteapp.Models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.Models.Interfaces.NoteDao

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        // Singleton prevents multiple
        // instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(context) {
                val instance =
                    Room.databaseBuilder(context, NoteDatabase::class.java, "note_database").allowMainThreadQueries()
                        .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}