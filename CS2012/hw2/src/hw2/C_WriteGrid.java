package hw2;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class C_WriteGrid {

    public static void main(String[] args) {
        int[] random100 = new int[100];
        randomhundred(random100);
        transfer(random100);
    }

    public static void randomhundred(int[] random100) {
        Random random = new Random();
        for (int i = 0; i < random100.length; i++) {
            random100[i] = random.nextInt(21); 
        }
    }

    public static void transfer(int[] random100) {
        try {
            FileWriter pwt = new FileWriter("numberGrid.txt");
            int count = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    pwt.write(random100[count] + " ");
                    count++;
                }
                pwt.write("\n"); 
            }
            pwt.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
