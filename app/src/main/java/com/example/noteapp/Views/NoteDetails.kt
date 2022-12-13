package com.example.noteapp.Views

import NoteViewModel
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.noteapp.Models.Note
import com.example.noteapp.databinding.ActivityNoteDetailsBinding

class NoteDetails : AppCompatActivity() {

    var isNoteDeleted=0

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityNoteDetailsBinding.inflate(layoutInflater)
        val note: Note? = this.intent.getSerializableExtra("note", Note::class.java)

        setContentView(binding.root)

        binding.topAppBar.title=note!!.noteTitle
        binding.noteDescription.text=note.noteDescription
        binding.noteDate.text=note.created_at

        binding.butDeleteNote.setOnClickListener{
            val viewModel=NoteViewModel(this)
            viewModel.deleteNote(note)
            isNoteDeleted=1

            Toast.makeText(this, "The note is deleted successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun finish() {
        setResult(isNoteDeleted)
        super.finish()
    }
}