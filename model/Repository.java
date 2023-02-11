package personal.model;
import java.util.List;

public interface Repository {
    List<Note> getAllNotes();
    String CreateNote(Note note);
    void UpdateNote(Note note, Fields field, String param);
    void deleteNote(List notes);    
}
