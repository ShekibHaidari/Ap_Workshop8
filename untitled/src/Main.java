import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        menu();
        System.out.println("Please enter the note: ");
        String ch = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int note = Integer.parseInt(ch);

    }
    public static void menu() throws IOException {
        System.out.println("Welcome to the Notebook");
        System.out.println("Please choice one of the following options: ");
        System.out.println("1. Add note");
        System.out.println("2. Remove note");
        System.out.println("3. Notes");
        System.out.println("4. Exports");
    }
}