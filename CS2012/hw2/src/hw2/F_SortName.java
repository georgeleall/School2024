package hw2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class F_SortName {

    public static void main(String[] args) {
        String inputFilePath = "/Users/george/Documents/CS2012/hw2/randomPeople.txt";
        String outputFilePath = "/Users/george/Documents/CS2012/hw2/namesList.txt";

        String[] names = namess(inputFilePath);
        if (names != null && names.length > 0) {
            snames(names, outputFilePath);
        } 
    }

    public static String[] namess(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            scanner.close();

            String[] names = new String[count];
            scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextLine()) {
                names[index++] = scanner.nextLine().trim();
            }
            scanner.close();
            return names;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void snames(String[] names, String outputFilePath) {
        try {
            // Sort names alphabetically by last name
            lname(names);

            // Remove duplicates
            String[] uniquenames = dupes(names);

            // Write sorted unique names to file
            FileWriter pwt = new FileWriter(outputFilePath);
            for (String name : uniquenames) {
                pwt.write(name + "\n");
            }
            pwt.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to write sorted unique names to namesList.txt.");
        }
    }

    public static void lname(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = i + 1; j < names.length; j++) {
                String lastName1 = names[i].substring(names[i].lastIndexOf(' ') + 1);
                String lastName2 = names[j].substring(names[j].lastIndexOf(' ') + 1);
                if (lastName1.compareTo(lastName2) > 0) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
    }

    public static String[] dupes(String[] names) {
        int uniqueCount = 0;
        for (int i = 0; i < names.length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueCount++;
            }
        }
        String[] uniquenames = new String[uniqueCount];
        int index = 0;
        for (String name : names) {
            boolean isDuplicate = false;
            for (int i = 0; i < index; i++) {
                if (name.equals(uniquenames[i])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniquenames[index++] = name;
            }
        }
        return uniquenames;
    }
}
