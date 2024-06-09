import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // ArrayList<String> listOfTitles = new ArrayList<>();
        ArrayList<Note> notes = new ArrayList<>();
        while (true) {
            System.out.println("1-Add\n" + "2-Remove\n" + "3-Notes\n" + "4-Export");
            int a = sc.nextInt();
            String str = "";
            int i = 1;
            switch (a) {
                case 1: {
                    System.out.println("please choose a title for the note!");
                    String string = sc.nextLine();
                    String title;
                    title = sc.nextLine();
                    FileWriter fileWriter = new FileWriter(title + ".txt");
                    //  System.out.println(title + "\n\n");
                    fileWriter.write(title);
                    //listOfTitles.add(title);
                    System.out.println("ok. fell free to write!\nenter '#' to finish!");
                    while (!str.contains("#")) {
                        str = sc.nextLine();
                        fileWriter.write(str);
                    }
                    // System.out.println("\n\n");
                    // Get the current date
                    Note note = new Note(title);
                    notes.add(note);
                    fileWriter.write(note.makeDate());
                    System.out.println("The new note has been added successfully!\n");
                    fileWriter.close();
                    //fileWriter.close();
                    //sdf = sc.nextLine();
                    break;
                }
                case 2: {
                    System.out.println("choose one of the notes to remove or enter '0' to get back to main menu!");
                    if (!notes.isEmpty()) {
                        for (Note note : notes) {
                            System.out.println(i + "- " + note.toString());
                            i++;
                        }

                        int b = sc.nextInt();
                        if (b <= notes.size()) {
                            notes.remove(b - 1);
                            System.out.println("the note has been removed successfully!");
                        } else {
                            System.out.println("note not existed!");
                        }
                    } else {
                        System.out.println("no note available");
                    }
                    break;

                }
                case 3: {
                    System.out.println("choose a note to show:\n");
                    if (!notes.isEmpty()) {
                        for (Note note : notes) {
                            System.out.println(i + "- " + note.toString());
                            i++;
                        }
                    } else {
                        System.out.println("no note available");
                    }
                    int c = sc.nextInt();
                    System.out.println("--------        " + notes.get(c - 1).getTitle() + "        --------\n\n");
                    try {
                        FileReader fileReader = new FileReader(notes.get(c - 1).getTitle() + ".txt");
                        //  FileReader fileReader = new FileReader("test.txt");
                        int j;
                        while ((j = fileReader.read()) != -1) {
                            System.out.print((char) j);
                        }
                        fileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4: {
                    System.out.println("choose a note to export:\n");
                    if (!notes.isEmpty()) {
                        for (Note note : notes) {
                            System.out.println(i + "- " + note.toString());
                            i++;
                        }
                    } else {
                        System.out.println("no note available");
                    }
                    int c = sc.nextInt();
                    FileWriter fileWriter = new FileWriter(notes.get(c - 1).getTitle() + ".txt");
                }
            }
        }
    }
}