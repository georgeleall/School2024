package WhileIntegerLoop;
import java.util.Scanner;

public class WhileIntegerLoop {

	public static void main(String []args) {
        Scanner scan = new Scanner (System.in);
		
		int val = 0;
        boolean isRun = true;
        String quitter = "";
		
		
		while(isRun) {
			System.out.println("Please select an integer of your choosing or type quit to quit the program");
			if (scan.hasNextInt()) {
				System.out.println("Your value is " + scan.nextInt());
			} else {
				quitter = scan.nextLine();
				if (quitter.equals("quit")) {
					
					isRun = false;

				} else {
					System.out.println("The end");
				}
			}
		}
	}
	
}
