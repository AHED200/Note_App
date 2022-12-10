package com.example.noteapp.Repositories

import NoteDatabase
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.noteapp.Models.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NoteRepository(private var noteDatabase: NoteDatabase) {

    var allNotes: LiveData<List<Note>>? = null

    fun getAllNotes(context: Context): LiveData<List<Note>>? {
        allNotes = noteDatabase.noteDao().getAllNotes()

        return allNotes
    }

    fun insertNote(context: Context, note: Note) {
        CoroutineScope(IO).launch {
            noteDatabase.noteDao().insertNote(note)
        }
    }

    fun deleteNote(context: Context, note: Note) {

        CoroutineScope(IO).launch {
            noteDatabase.noteDao().deleteNote(note)
        }

    }
}