import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * /**
     */
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu();
            String ch = scanner.next();
            int choice = 0;
            try {
                choice = Integer.parseInt(ch);
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    notebook.add_to_note();
                    break;
                case 2:
                    notebook.removeNote();
                    break;
                case 3:
                    notebook.listNotes();
                    break;
                case 4:
                    notebook.exportNote();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void menu() {
        System.out.println("Welcome to the Notebook");
        System.out.println("Please choice one of the following options: ");
        System.out.println("1. Add note");
        System.out.println("2. Remove note");
        System.out.println("3. Notes");
        System.out.println("4. Exports");
        System.out.println("5. Exit");

    }
}