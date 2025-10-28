package hw2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class E_WriteName {

    public static void main(String[] args) {
        String firstNamesFilePath = "/Users/george/Documents/CS2012/hw2/src/hw2/firstNames.txt";
        String lastNamesFilePath = "/Users/george/Documents/CS2012/hw2/src/hw2/lastNames.txt";
        String outputFilePath = "/Users/george/Documents/CS2012/hw2/src/hw2/randomPeople.txt";

        String[] firstNames = names(firstNamesFilePath);
        String[] lastNames = names(lastNamesFilePath);

        if (firstNames != null && lastNames != null) {
            rnames(firstNames, lastNames, outputFilePath);
        } 
    }

    public static String[] names(String fileName) {
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

    public static void rnames(String[] firstNames, String[] lastNames, String outputFilePath) {
        try {
            FileWriter pwt = new FileWriter(outputFilePath);
            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                String randomFirstName = firstNames[random.nextInt(firstNames.length)];
                String randomLastName = lastNames[random.nextInt(lastNames.length)];
                String fullName = randomFirstName + " " + randomLastName;
                pwt.write(fullName + "\n");
            }
            pwt.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to write random names to randomPeople.txt.");
        }
    }
}
