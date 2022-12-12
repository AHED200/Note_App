package com.example.noteapp.Repositories__Delete

import android.content.Context
import com.example.noteapp.Models.Note
import com.example.noteapp.Models.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NoteRepository(private var noteDatabase: NoteDatabase) {

    var allNotes: List<Note> ?= null



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