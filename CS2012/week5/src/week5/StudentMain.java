package week5;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StudentMain {

	public static void main(String[] args) throws FileNotFoundException { 
	Student[] studentArr = new Student[4];
	
	File myFile = new File ("/Users/george/Documents/CS2012/week5/src/week5/Students");
	Scanner myScan = new Scanner(myFile);
	
	int idx = 0;
	myScan.nextLine();
	
	while(myScan.hasNext()) {
		String [] temp = myScan.nextLine().split(",");
		studentArr[idx] = new Student(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
		idx++;
	}

	myScan.close();
	System.out.println(studentArr[0].toString());
	System.out.println(studentArr[1].toString());
	System.out.println(studentArr[2].toString());
	System.out.println(studentArr[3].toString());
	}
}