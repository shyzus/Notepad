package nl.hva.fdmci.mad.notepad.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import nl.hva.fdmci.mad.notepad.database.NoteRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application.applicationContext)

    val note = noteRepository.getNotepad()

}
