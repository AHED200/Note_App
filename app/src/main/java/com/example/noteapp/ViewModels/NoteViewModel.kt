
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.noteapp.Models.Note
import com.example.noteapp.Models.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(context: Context) : ViewModel() {
    private var database: NoteDatabase

    init {
        database = NoteDatabase.getDatabase(context)
    }

    fun getAllNotes(): List<Note> {
        return database.noteDao().getAllNotes()
    }

    fun insertNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            database.noteDao().insertNote(note)
        }
    }

    fun deleteNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            database.noteDao().deleteNote(note)
        }
    }

}