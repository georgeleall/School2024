package hw2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B_ReadWrite100 {

    public static void main(String[] args) {
        String inputFilePath = "/Users/george/Documents/CS2012/hw2/numberRow.txt";
        String outputFilePath = "/Users/george/Documents/CS2012/hw2/numbersColumn.txt";

        try {

            Scanner scanner = new Scanner(new File(inputFilePath));

            PrintWriter pwt = new PrintWriter(outputFilePath);

            while (scanner.hasNextLine()) {
            	
                String line = scanner.nextLine();
                
                for (int i = 0; i < line.length(); i++) {
                    pwt.println(line.charAt(i));
                }
            }

            scanner.close();
            pwt.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
