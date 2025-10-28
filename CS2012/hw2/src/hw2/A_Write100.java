package hw2;
import java.io.File;
import java.io.PrintWriter;
import java.util.Random;



public class A_Write100 {

	public static void main(String[] args) {
		
		int[] randomnumbs = new int [100];
		
		randomnums(randomnumbs);
		
		try {
			// create a File instance object that connects to the named file and path
			// use File(pathString , true) to append to the file, default is to overwrite
			File aFile = new File("numberRow.txt");
			// create a PrintWriter for easy interaction with the FileWriter instance object
			PrintWriter pwt = new PrintWriter(aFile);
			// print this text into the file
			for (int i = 0; i < randomnumbs.length; i++) {
	           pwt.print(randomnumbs[i]);
	            }
			// make sure that all pending print operations were sent to the file before closing
			pwt.flush();
			// clean up the resources used, close the PrintWriter
			pwt.close();
			} 
		
		catch (Exception e) {
			// if something breaks catch and print out what went wrong
			System.err.print(e);
			}
			
		}
	public static void randomnums(int[]randomnumbs) {
		Random random = new Random();
	
		 for (int i = 0; i < randomnumbs.length; i++) {
	            randomnumbs[i] = random.nextInt(1001);
		 }
		

	}	
}

