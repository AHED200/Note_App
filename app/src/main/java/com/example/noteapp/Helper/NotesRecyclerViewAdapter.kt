package com.example.noteapp.Helper

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.Models.Note
import com.example.noteapp.Views.MainActivity
import com.example.noteapp.Views.NoteDetails
import com.example.noteapp.databinding.NoteCardBinding

class NotesRecyclerViewAdapter(var allNotes: List<Note>, val activity: MainActivity) :
    RecyclerView.Adapter<NotesRecyclerViewAdapter.NoteViewHolder>() {

    class NoteViewHolder(binding: NoteCardBinding) : RecyclerView.ViewHolder(binding.root) {

        private val noteTitle = binding.noteTitle
        private val noteDescription = binding.noteDescription
        private val noteDate = binding.noteDate

        fun bind(note: Note) {
            noteTitle.text = note.noteTitle
            noteDescription.text = note.noteDescription
            noteDate.text = "Created: ${note.created_at}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = allNotes[position]

        holder.itemView.setOnClickListener {
            val context=holder.itemView.context
            val noteDetailsIntent = Intent(context, NoteDetails::class.java)
            noteDetailsIntent.putExtra("note", note)
            noteDetailsIntent.putExtra("deleted", 1)

            activity.startActivityForResult(noteDetailsIntent, 1)
        }

        holder.bind(note)
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

}