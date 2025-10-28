package homework3;
import java.util.Scanner;

public class homework3 {

    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        int rows = 0;
        int cols = 0;

        while (rows == 0 || cols == 0) {

            System.out.print("Please enter the number of rows: ");
            if (myScan.hasNextInt() ) {

                int input = myScan.nextInt();

                if(input >= 5 && input <= 10 ) {
                    rows = input;
                }else {
                    System.out.println("The input was not valid...");
                    myScan.next();
                }
            }


        System.out.print("Please enter the number of cols: ");
        if (myScan.hasNextInt()) {
        	
            int input = myScan.nextInt();

            if(input >= 5 && input <= 10 ) {
                cols = input;
            }else {
                System.out.println("The input was not valid...");
                myScan.next();
            }
            
        } 
        
        }
        int[][] arr = create2DArr(rows,cols);
        print2DArr(arr);
        
        int concentricRings = (int) Math.ceil(Math.min(rows, cols) / 2.0);
        
        int[] topRow = new int [arr[0].length];
        for(int c = 0; c < arr.length; c++) {
        	topRow[c] = arr[0][c];
        }
        
        int[]leftCol = new int [arr.length];
        for (int r = 0; r < arr.length; r++) {
        	
        }
        
        
        
        int[] bottomrow = new int[arr[0].length];
        for(int c = 0; )
        }
    
}

		