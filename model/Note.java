package personal.model;

// Базовый класс записок
public class Note {
    private String id = "";
    private String pledges;
    private String text;
    private String date;

    
    public Note(String pledges, String text, String date) {
        this.pledges = pledges;
        this.text = text;
        this.date = date;
    }

    public Note(String id, String pledges, String text, String date) {
        this(pledges, text, date);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPledges() {
        return pledges;
    }

    public void setPledges(String pledges) {
        this.pledges = pledges;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Идентификатор: %s Заголовок: %s, Текст: %s, Дата: %s", id, pledges, text, date);
    }
}
