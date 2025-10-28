package FloatSquare;
import java.util.Scanner;

public class FloatSquare {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a float to square: ");
		float fl = scan.nextFloat();
		
		
		System.out.println("Your float squared is: " +squareFloat(fl));

	}
	
	public static float squareFloat (float fl) {
		return fl * fl;
	}

}
