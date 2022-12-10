import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapp.Models.Note

class NoteViewModel() : ViewModel() {
    lateinit var database: NoteDatabase
    var allNotes= MutableLiveData<ArrayList<Note>>()

    suspend fun insertNote(note: Note){
        database.noteDao().insertNote(note)
    }

    suspend fun deleteNote(note: Note){
        database.noteDao().deleteNote(note)
    }

}