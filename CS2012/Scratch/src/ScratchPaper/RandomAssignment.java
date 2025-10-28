package ScratchPaper;
import java.util.Scanner;

public class RandomAssignment {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("Good morning, please tell us how you did on your 3 quizzes!");
		
		System.out.println("How did you do on Quiz 1?");
		int quiz1 = keyboard.nextInt();
		System.out.print("On Quiz 1, I got: ");
		System.out.println(quiz1 + "%");
		System.out.println();
		
		System.out.println("How did you do on Quiz 2?");
		int quiz2 = keyboard.nextInt();
		System.out.print("On Quiz 2, I got: ");
		System.out.println(quiz2 + "%");
		System.out.println();

		System.out.println("How did you do on Quiz 3?");
		int quiz3 = keyboard.nextInt();
		System.out.print("On Quiz 3, I got: ");
		System.out.println(quiz3 + "%");
		System.out.println();
		
		int average = (quiz1+quiz2+quiz3)/3;
		System.out.println("The average of your past 3 quizzes is: " + average);
		String grade;
		if(average >= 90) {
			grade = "A";
		}
		else if(average >= 80) {
			grade = "B";
		}
		else if(average >= 70) {
			grade = "C";
		}
		else if(average >= 60) {
			grade = "D";
		}
		else {
			grade = "F";
		}
		
		System.out.println("Your current grade is a " + grade + ".");
		
		if(grade == "A" || grade == "B" || grade == "C") {
			System.out.println("Congratulations, you are currently passing!");
		}
		else {
			System.out.println("Unfortunately, you are failing.");
		}
		
	}

}
