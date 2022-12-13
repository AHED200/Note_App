package com.example.noteapp.Views

import NoteViewModel
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.Helper.NotesRecyclerViewAdapter
import com.example.noteapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewModel: NoteViewModel? = null
    private var adapter: NotesRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        viewModel = NoteViewModel(this)
        adapter = NotesRecyclerViewAdapter(viewModel!!.getAllNotes(), this)
        //Bind RecyclerView with adapter
        binding.rvAllNote.layoutManager = LinearLayoutManager(this)
        binding.rvAllNote.adapter = adapter

        //Moving to create new note page
        binding.butCreateNote.setOnClickListener {
            val createNoteIntent = Intent(this, CreateNote::class.java)
            startActivityForResult(createNoteIntent, 0)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //1 equals the note is created done otherwise the note not created
        //2 means the note deleted successfully
        if (resultCode == 1) {
            adapter!!.allNotes = viewModel!!.getAllNotes()
            adapter!!.notifyDataSetChanged()
        }
    }

}