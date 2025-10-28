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


        int[][] arr = new int[rows] [cols];
        int sum = 0;
        int sum1 = 0;
        
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]= (int) Math.ceil((Math.random()*1000));              
                System.out.format("%-5d",arr[i][j]);
                for(int num: arr[i]){
                    sum+=num;
                }
                for(int num1: arr[j]){
                    sum1+=num1;
                }
            }
            System.out.println();
        }
        System.out.print("Sum: " + (sum1+sum));
        System.out.println();
        System.out.print("Average: " + ((sum1+sum)/(cols+rows)));
        
        
    myScan.close();
        }
    
    }