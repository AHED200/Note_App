package com.example.noteapp.Repositories

import NoteDatabase
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.noteapp.Models.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NoteRepository {

    companion object{
        var noteDatabase:NoteDatabase?=null
        var allNotes:MutableLiveData<Note>?=null

        fun initializeDB(context: Context):NoteDatabase{
            return NoteDatabase.createDatabase(context)
        }

        fun getAllNotes(context: Context):MutableLiveData<Note>?{
            noteDatabase= initializeDB(context)
            allNotes= noteDatabase!!.noteDao().getAllNotes()

            return allNotes
        }

        fun insertNote(context: Context, note:Note){
            noteDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                noteDatabase!!.noteDao().insertNote(note)
            }
        }

        fun deleteNote(context: Context, note:Note){
            noteDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                noteDatabase!!.noteDao().deleteNote(note)
            }
        }
    }
}