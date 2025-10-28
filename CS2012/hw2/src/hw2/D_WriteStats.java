package hw2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class D_WriteStats {

    public static void main(String[] args) {
        String inputFilePath = "/Users/george/Documents/CS2012/hw2/numberGrid.txt";
        String outputFilePath = "/Users/george/Documents/CS2012/hw2/gridStats.txt";
        
        int[][] numberGrid = numbers(inputFilePath);
        if (numberGrid != null) {
            int grandTotal = total(numberGrid);
            int[] rowTotals = rtotals(numberGrid);
            int[] columnTotals = ctotals(numberGrid);
            double average = average(numberGrid);
            int countOf17 = seventeen(numberGrid, 17);
            
            finalfile(outputFilePath, grandTotal, rowTotals, columnTotals, average, countOf17);
        } 
    }

    public static int[][] numbers(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            int[][] array = new int[10][10];
            int row = 0;
            while (scanner.hasNextLine()) {
                String[] numbers = scanner.nextLine().trim().split("\\s+");
                for (int col = 0; col < numbers.length; col++) {
                    array[row][col] = Integer.parseInt(numbers[col]);
                }
                row++;
            }
            scanner.close();
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int total(int[][] numberGrid) {
        int grandTotal = 0;
        for (int i = 0; i < numberGrid.length; i++) {
            for (int j = 0; j < numberGrid[i].length; j++) {
                grandTotal += numberGrid[i][j];
            }
        }
        return grandTotal;
    }

    public static int[] rtotals(int[][] numberGrid) {
        int[] rowTotals = new int[numberGrid.length];
        for (int i = 0; i < numberGrid.length; i++) {
            for (int j = 0; j < numberGrid[i].length; j++) {
                rowTotals[i] += numberGrid[i][j];
            }
        }
        return rowTotals;
    }

    public static int[] ctotals(int[][] numberGrid) {
        int[] columnTotals = new int[numberGrid[0].length];
        for (int i = 0; i < numberGrid[0].length; i++) {
            for (int j = 0; j < numberGrid.length; j++) {
                columnTotals[i] += numberGrid[j][i];
            }
        }
        return columnTotals;
    }

    public static double average(int[][] numberGrid) {
        int total = 0;
        for (int i = 0; i < numberGrid.length; i++) {
            for (int j = 0; j < numberGrid[i].length; j++) {
                total += numberGrid[i][j];
            }
        }
        return (double) total / (numberGrid.length * numberGrid[0].length);
    }

    public static int seventeen(int[][] numberGrid, int target) {
        int count = 0;
        for (int i = 0; i < numberGrid.length; i++) {
            for (int j = 0; j < numberGrid[i].length; j++) {
                if (numberGrid[i][j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void finalfile(String outputFilePath, int grandTotal, int[] rowTotals,
            int[] columnTotals, double average, int countOf17) {
        try {
            FileWriter pwt = new FileWriter(outputFilePath);
            pwt.write("Grand Total: " + grandTotal + "\n");
            pwt.write("Totals by Row:\n");
            for (int i = 0; i < rowTotals.length; i++) {
                pwt.write("Row " + (i + 1) + ": " + rowTotals[i] + "\n");
            }
            pwt.write("Totals by Column:\n");
            for (int i = 0; i < columnTotals.length; i++) {
                pwt.write("Column " + (i + 1) + ": " + columnTotals[i] + "\n");
            }
            pwt.write("Average: " + average + "\n");
            pwt.write("Count of 17: " + countOf17 + "\n");
            pwt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
