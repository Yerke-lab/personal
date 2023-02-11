package personal.controllers;
import personal.model.Fields;
import personal.model.Repository;
import personal.model.Note;
import java.util.List;

public class NoteController {
    private final Repository repository;
    public NoteController(Repository repository) {
        this.repository = repository;        
    }

    public void saveNote(Note note) throws Exception {        
        repository.CreateNote(note);
    }

    public void updateNote(Note note, Fields field, String param) throws Exception {        
        repository.UpdateNote(note, field, param);

    }
    public Note readNote(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("Note not found");
    }

    public Note deleteNote(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                notes.remove(note);
                repository.deleteNote(notes);
                return note;
            }
        }
        throw new Exception("Note not found");
    }

    public List<Note> getNotes() throws Exception {
        return repository.getAllNotes();
    }
   
}
