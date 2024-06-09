import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
   // private Date date;
    private String title;

    public Note(String title) {
       // this.date = date;
        this.title = title;
    }

    public String makeDate() {
        Date currentDate = new Date();

        // Define a custom date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Format the current date using the formatter
        String formattedDate = dateFormat.format(currentDate);
        return formattedDate;
    }
    @Override
    public String toString(){
        return this.title + "      " + makeDate();
    }

    public String getTitle() {
        return title;
    }
}
