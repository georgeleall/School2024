package SumAverage;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SumAverage {

	public static void main(String[] args) throws FileNotFoundException {

		File myFile = new File("/Users/george/Documents/CS2012/ExercisesWeek1/src/SumAverage/Numbers");
		Scanner myScan = new Scanner(myFile);
		
		int count = 0;
		double average = 0.0;
		int sum = 0;
		
		while (myScan.hasNext()) {
			sum += myScan.nextInt();
			count++;
		}
		
		System.out.println("The bymber of values in numbers.txt was: " + count);
		System.out.println("The sum of all values in numbers.txt was: " + sum);
		
		average = (double) sum/count;
		System.out.println("The average of all values in numbers.txt was: " + average);
		
		
		File newFile = new File ("results.txt");
		PrintWriter pwt = new PrintWriter(newFile);
		
		pwt.println("Sum: " + sum + "Average: " + average);
		while (myScan.hasNext()) {
		pwt.println(myScan.nextInt());
		}
		
		pwt.close();
		myScan.close();
	}

}
