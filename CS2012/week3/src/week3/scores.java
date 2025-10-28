package week3;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class scores {

	public static void main(String[] args) throws IOException {
		File myFile = new File("/Users/george/Documents/CS2012/week3/src/list-of-students-and-scores.txt");
		Scanner scan = new Scanner(myFile);
		
		double [] grade = new double [20];
		String[] studentNames = new String[20];
		
		
		int idx = 0;
		while(scan.hasNextLine()) {
			
			String[] student = scan.nextLine().split(" ");
			studentNames[idx] = student[0];
			grade[idx] = Double.parseDouble(student[1]);
			idx++;
		}
		scan.close();
		

		double best = grade[0];
		
		for (int i = 1; i < grade.length; i++) {
			if (grade[i] > best) {
				best = grade[i];
			}

		}
		String[] letterGrades = new String [20];
		for(int i = 0; i <letterGrades.length; i++) {
			letterGrades[i] = letterGrade(grade[i],best);
		}
		printNameLetter(studentNames,letterGrades, best, grade);
	}
	
	public static String letterGrade(double grade, double best) {
		if(grade >= best - 10) {
			return "A";
		} else if (grade >= best - 20) {
			return "B";
		}else if (grade >= best - 30) {
			return "C";
		}else if (grade >= best - 40) {
			return "D";
		}else {
			return "F";
		}
		
	}
	
    public static void printNameLetter(String[] names, String[] letterGrades, double best, double[] grades) throws IOException {
        String[] tempNames = names.clone();
        String[] tempLetterGrades = letterGrades.clone();
        double[] tempGrades = grades.clone();

        Arrays.sort(tempNames);
        Arrays.sort(tempLetterGrades);
        
        for (int i=0; i<tempNames.length; i++) {
        }
        for (int i=0; i<tempLetterGrades.length; i++) {
        }

        FileWriter pwt = new FileWriter("/Users/george/Documents/CS2012/week3/src/list-of-students-and-scores.txt");
       
        pwt.write("--------------------------------------------------------"+"\n");
        pwt.write("Name and Letter-Grade sorted by Name"+"\n");
        pwt.write("--------------------------------------------------------"+"\n");
        
        for (int i = 0; i < tempNames.length; i++) {
            pwt.write(tempNames[i] + " " + tempLetterGrades[i]+"\n");
        }

       // sorter(tempLetterGrades, tempNames);
        pwt.write("--------------------------------------------------------"+"\n");
        pwt.write("Letter-Grade and Name sorted by Letter-Grade"+"\n");
        pwt.write("--------------------------------------------------------"+"\n");
        
        for (int i = 0; i < tempNames.length; i++) {
            pwt.write(tempLetterGrades[i] + " " + tempNames[i]+"\n");
        }  

        pwt.close();
    }
    


    public static void sorter(double[] grades, String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;

                    double tempGrade = grades[i];
                    grades[i] = grades[j];
                    grades[j] = tempGrade;
	                }
	            }
	        }
		
	}
	
}
