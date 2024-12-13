import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Notebook {
    private List<Note> notes;
    private static final String f_constant = "notes.ser";

    
    
    public Notebook() {
        notes = loadNotes();
    }

    public void add_to_note() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write the title of your note: ");
        String title = scanner.nextLine();

        for (Note note : notes) {
            if (note.getTitle().equalsIgnoreCase(title)) {
                System.out.println("A note with this title already exists.");
                return;
            }
        }

        System.out.print("Enter the content of the note: ");
        String content = scanner.nextLine();

        Note note = new Note(title, content);
        notes.add(note);
        saveNotes();
        System.out.println("Note added successfully.");
    }

    public void removeNote() {
        if (notes.isEmpty()) {
            System.out.println("No notes available to remove.");
            return;
        }

        listNotes();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the note to remove: ");
        String in = scanner.next();
        int index = 0;
        try {
             index = Integer.parseInt(in);
        }catch(NumberFormatException e){System.err.println("Please enter a valid number");return;}

        if (index < 0 || index >= notes.size()) {
            System.out.println("Invalid index.");
        } else {
            notes.remove(index);
            saveNotes();
            System.out.println("Note removed successfully.");
        }
    }

    public void listNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }

        System.out.println("+-----+----------------------+------------+");
        System.out.println("| No. | Title                | Date       |");
        System.out.println("+-----+----------------------+------------+");
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            System.out.printf("| %-3d | %-20s | %-10s |\n", i, note.getTitle(), note.getCreationDate());
        }
        System.out.println("+-----+----------------------+------------+");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the note to view its content (or -1 to exit): ");
        int index = scanner.nextInt();

        if (index == -1) {
            return; // Exit if the user chooses -1
        }

        if (index < 0 || index >= notes.size()) {
            System.out.println("Invalid index.");
        } else {
            Note note = notes.get(index);
            System.out.println("+----------------------+");
            System.out.println("| Note Details         |");
            System.out.println("+----------------------+");
            System.out.printf("| Title: %-15s |\n", note.getTitle());
            System.out.printf("| Date: %-16s |\n", note.getCreationDate());
            System.out.println("+----------------------+");
            System.out.println("| Content:             |");
            System.out.println("+----------------------+");
            System.out.println(note.getContent());
            System.out.println("+----------------------+");
        }
    }


    public void viewNote() {
        if (notes.isEmpty()) {
            System.out.println("No notes available to view.");
            return;
        }

        listNotes();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the note to view: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= notes.size()) {
            System.out.println("Invalid index.");
        } else {
            Note note = notes.get(index);
            System.out.println("+----------------------+");
            System.out.println("| Note Details         |");
            System.out.println("+----------------------+");
            System.out.printf("| Title: %-15s |\n", note.getTitle());
            System.out.printf("| Date: %-16s |\n", note.getCreationDate());
            System.out.println("+----------------------+");
            System.out.println("| Content:             |");
            System.out.println("+----------------------+");
            System.out.println(note.getContent());
            System.out.println("+----------------------+");
        }
    }


    public void exportNote() {
        if (notes.isEmpty()) {
            System.out.println("No notes available to export.");
            return;
        }

        listNotes();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the note to export: ");
        String ch = scanner.nextLine();
        int index = 0;
        try {
            index = Integer.parseInt(ch);
        }catch (NumberFormatException e){System.err.println("Please enter a valid number");return;}


        if (index < 0 || index >= notes.size()) {
            System.out.println("Invalid index.");
        } else {
            Note note = notes.get(index);
            File exportDir = new File("export");
            if (!exportDir.exists()) {
                exportDir.mkdir();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(exportDir, note.getTitle() + ".txt")))) {
                writer.write(note.toString());
                System.out.println("Note exported successfully.");
            } catch (IOException e) {
                System.out.println("Error exporting note: " + e.getMessage());
            }
        }
    }

    private List<Note> loadNotes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f_constant))) {
            return (List<Note>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveNotes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f_constant))) {
            oos.writeObject(notes);
        } catch (IOException e) {
            System.out.println("Error saving notes: " + e.getMessage());
        }
    }
}





















//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class NoteBOOK {
//private List<Note> notes;
//private static final String fileName = "notebook.ser";
//
//public NoteBOOK() {
//    notes = loadnotes();
//}
//
//public void add() {
//    Scanner sc = new Scanner(System.in);
//    System.out.print("Enter title: ");
//    String title = sc.nextLine();
//    for (Note note : notes) {
//        if (note.getTitle().equals(title)) {
//            System.out.println("Title already exists");
//            return;
//        }
//
//    }
//    System.out.print("Enter Your note : ");
//    String note = sc.nextLine();
//    Note newNote = new Note(title, note);
//    notes.add(newNote);
//    save();
//}
//public void remove() {
//    if(notes.isEmpty()) {
//        System.out.println("Nothig to remove");
//        return;
//    }
//    listN();
//    Scanner sc = new Scanner(System.in);
//
//    System.out.print("Enter the number of note that you want to remove: ");
//    int num = sc.nextInt();
//    if (num > notes.size() || num < 1) {
//        System.out.println("Invalid note number");
//    }else{
//        notes.remove(num);
//        save();
//        System.out.println("Note removed");
//    }
//}
//public void listN() {
//    if (notes.size() == 0) {
//        System.out.println("Nothig to list");
//    }
//    for (int i = 0; i < notes.size(); i++) {
//        System.out.println(i + "." + notes.get(i).getTitle());
//    }
//}
//public void show(){
//    if (notes.size() == 0) {
//        System.out.println("Nothig to show");
//    }
//    listN();
//    Scanner sc = new Scanner(System.in);
//    System.out.print("Enter the number of note that you want to show: ");
//    int num = sc.nextInt();
//    if (num > notes.size() || num < 1) {
//        System.out.println("Invalid note number");
//    }else {
//        System.out.println(notes.get(num));
//
//    }
//
//}
//public void export(){
//    if (notes.size() == 0) {
//        System.out.println("Nothig to export");
//    }
//    listN();
//    Scanner sc = new Scanner(System.in);
//    System.out.print("Enter the number of note that you want to export: ");
//    int num = sc.nextInt();
//    if (num > notes.size() || num < 1) {
//        System.out.println("Invalid note number");
//    }else {
//        Note note = notes.get(num);
//        File DIR = new File("EXPORTS");
//        if (!DIR.exists()) {
//            DIR.mkdir();
//        }
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DIR + File.separator + note.getTitle() + ".srz"))) {
//            bw.write(note.toString());
//            System.out.println("Exported to " + DIR + File.separator + note.getTitle() + ".srz");
//
//    } catch (IOException e) {
//            System.out.println("Error exporting to " + DIR + File.separator + note.getTitle() + ".srz");
//
//        }
//    }
//}
//public List<Note> loadnotes() {
//    File f = new File(fileName);
//    if(!f.exists()){
//        try {
//            f.createNewFile();
//        } catch (IOException e) {
//        throw new RuntimeException(e);
//        }
//        return new ArrayList<>();
//    }
//    try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(fileName))){
//    return (List<Note>) o.readObject();
//    } catch (ClassNotFoundException | IOException e) {
//        throw new RuntimeException(e);
//    }
//}
//    public void importn(){
//        File dir = new File("EXPORTS");
//        if(dir.isDirectory()){
//            File[] files = dir.listFiles();
//            if(files != null && files.length > 0){
//                System.out.println("Available exports:");
//                for (int i = 0; i < files.length; i++){
//                    System.out.println((i+1)+". "+files[i].getName());
//                }
//                Scanner sc = new Scanner(System.in);
//                System.out.print("Enter the number of the note to import: ");
//                int num = sc.nextInt();
//                if (num > 0 && num <= files.length) {
//                    File fileToImport = files[num - 1];
//                    try (BufferedReader br = new BufferedReader(new FileReader(fileToImport))) {
//                        String title = fileToImport.getName().replace(".srz", "");
//                        String content = br.readLine();
//                        Note importedNote = new Note(title, content);
//                        notes.add(importedNote);
//                        save();
//                        System.out.println("Note imported successfully");
//                    } catch (IOException e) {
//                        System.out.println("Error importing note");
//                    }
//                } else {
//                    System.out.println("Invalid number");
//                }
//            } else {
//                System.out.println("No files to import");
//            }
//        } else {
//            System.out.println("EXPORTS directory does not exist");
//        }
//    }
//private void save() {
//    try(ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(fileName))) {
//        ob.writeObject(notes);
//    } catch (FileNotFoundException e) {
//        throw new RuntimeException(e);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//
//
//}
