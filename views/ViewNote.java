package personal.views;

import personal.controllers.NoteController;
import personal.model.Fields;
import personal.model.Note;
import personal.utils.Notebook;
import java.util.Scanner;

public class ViewNote {
    private final NoteController noteController;
   

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;        
    }

    public void run() {
        Commands com = Commands.NONE;
        showHelp();
        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT)
                    return;
                switch (com) {
                    case CREATE:
                        create();
                        break;
                    case READ:
                        read();
                        break;
                    case DELETE:
                        delete(); 
                        break;  
                    case UPDATE:
                        update();
                        break;
                    case LIST:
                        list();
                        break;                    
                    case HELP:
                        showHelp();
                        break;                                        
                }
            } catch (Exception ex) {
                System.out.println("Произошла ошибка " + ex.toString());
            }
        }
    }

    private void read() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        Note note_ = noteController.readNote(id);
        System.out.println(note_);
    }

    private void update() throws Exception {
        String noteid = prompt("Идентификатор пользователя: ");
        String field_name = prompt("Какое поле (PLEDGES, TEXT, DATE): ").toUpperCase();
        String param = null;
        if (Fields.valueOf(field_name) == Fields.PLEDGES) {
            param = catchDate(param);
            if (param == null) {
                return;
            }
        } else {
            param = prompt("Введите новые данные. ");
        }
        Note _note = noteController.readNote(noteid);
        noteController.updateNote(_note, Fields.valueOf(field_name.toUpperCase()), param);
    }  


    public String catchDate(String date) throws Exception {
        while (true) {
            date = prompt("Введите дату: ");                          
            return date;
        }
    }

    private void list() throws Exception {
        for (Note note : noteController.getNotes()) {
            System.out.println(note);
        }
    }

    private void create() throws Exception {
        String pledges = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        String date = null;
        date = catchDate(date);
        if (date == null) {
            return;
        }

        noteController.saveNote(new Note(pledges, text, date));
    }

    private void showHelp() {
        System.out.println("Список команд:");
        for (Commands c : Commands.values()) {
            System.out.println(c);
        }
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in); 
        System.out.print(message);
        return in.nextLine();
        //in.close();        
    }

    private void delete() throws Exception {
        String noteid = prompt("Введите идентификатор записи для удаления: ");
        System.out.println(noteController.readNote(noteid));
        if (noteid.equals(noteid)) {
            System.out.println("Происходит удаление записи...");
            noteController.deleteNote(noteid); 
        } else {
            System.out.println("Пожалуйста введите корректный идентификатор");
        }
    }
    
}
