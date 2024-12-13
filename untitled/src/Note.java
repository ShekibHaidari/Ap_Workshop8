import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {
    private String title;
    private String content;
    private LocalDate date;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = LocalDate.now();
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public LocalDate getDate() {
        return LocalDate.now();
    }
    @Override
    public String toString() {
        return "NoteBook{" + "title=" + title + ", content=" + content + ", date=" + date + '}';
    }
}
