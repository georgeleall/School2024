package UserInput;
import java.util.Scanner;

public class userinput{
    public static void main (String []args){

        Scanner scan = new Scanner (System.in);
        System.out.print("Please enter a string of your choosing.");
        String myString = scan.nextLine();
        System.out.println ("Your string is " + myString);
        
        System.out.print("Please enter an integer:");
        int myNum = scan.nextInt();
        System.out.println("Your number is " + myNum);
        
        System.out.print("Please enter whatever value you want: ");
        if(scan.hasNextInt()) {
        	System.out.println("Your value was an integer");
        }
        else if (scan.hasNextFloat()){
        	System.out.println("Your value was a float.");
        	
        } else {
        	System.out.println();
        }
        
    }
}