/*
George Leal

Midterm 1
*/

-- Q1: Report the student id, student name, email, and entrydate of all female students.
SELECT student_id AS 'Student ID' ,student_name AS 'Student Name', EMail AS 'Email Address' , EntryDate AS 'Entry Date'
FROM Students
WHERE Gender = 'F';

-- Q2: Report all information of the students who entered in January 2004 and are older than 20.
SELECT *
FROM Students
WHERE age > 20 AND (EntryDate BETWEEN '2004-01-01' AND '2004-01-31');

-- Q3: For each professor, report the professor id and the number of students supervised by the professor.
SELECT prof_id, COUNT(DISTINCT student_id)
FROM Supervise
GROUP BY prof_id;

-- Q4: Report the name of the student who has the latest entry date.
SELECT student_name
FROM Students
WHERE EntryDate = (	SELECT MAX(EntryDate)
					FROM Students);

-- Q5: Report the student names and age of all students who have a 'calstatela' email address.
-- Sort the results by age.
SELECT student_name, age
FROM Students
WHERE EMail LIKE '%calstatela%'
ORDER BY age;

-- Q6: Report the names of the professors who work on 'project04' or 'project05'
SELECT P.prof_name
FROM Professors P
INNER JOIN Supervise S ON P.prof_id = S.prof_id
WHERE S.project = 'project04' OR S.project = 'project05';

-- Q7: Report the names of the students who need a supervisor.
SELECT student_name
FROM Students
WHERE student_id NOT IN (SELECT student_id
						 FROM Supervise);
                         
-- Q8: Report the names of the male students who are older than all female students.
SELECT student_name
FROM Students
WHERE Gender = 'M' AND age > (	SELECT MAX(age)
								FROM Students
                                WHERE Gender = 'F');

-- Q9: Report each department and the number of professors for each department.
SELECT dept, COUNT(*)
FROM Professors
GROUP BY dept;

-- Q10: Report the department that has the most number of professors and the number of professors.
SELECT dept, COUNT(*)
FROM Professors
GROUP BY dept
HAVING COUNT(*) >= 	ALL (SELECT COUNT(*)
					FROM Professors
                    GROUP BY dept);

-- Q11: Report the professor id and name who supervises more than one student.
SELECT P.prof_id, P.prof_name, COUNT(DISTINCT S.student_id)
FROM Professors P 
INNER JOIN Supervise S ON P.prof_id = S.prof_id
GROUP BY P.prof_id, P.prof_name
HAVING COUNT(DISTINCT S.student_id) > 1;
-- FORGOT TO ADD DISTINCT INTO THE CONDITIONS. THEY CHANGE THE RESULTS.

-- Q12: Report the professor id, professor name, and the student names they supervised.
-- Sort the results by professor id and student name (IN ASCENDING ORDER). List the results
-- only once (NO DUPLICATES)
SELECT DISTINCT P.prof_id, P.prof_name, S.student_name
FROM Professors P
INNER JOIN Supervise SE
ON P.prof_id = SE.prof_id
INNER JOIN Students S
ON S.student_id = SE.student_id
ORDER BY prof_id,student_name ASC;

-- Q13: Report the names of the students who work on more than 1 project, the age of the students
-- and the number of projects.
SELECT S.student_name, S.age, COUNT(SE.project) AS Number_of_Projects
FROM Students S, Supervise SE
WHERE S.student_id = SE.student_id
GROUP BY S.student_name, S.age
HAVING COUNT(SE.project) > 1;

-- Q14: Report the names of the professors who work on the most number of projects, and the number of projects.
SELECT P.prof_name, COUNT(SE.project) AS Number_of_Projects
FROM Professors P
INNER JOIN Supervise SE ON P.prof_id = SE.prof_id
GROUP BY P.prof_id, P.prof_name
HAVING COUNT(SE.project) = (SELECT MAX(ProjectCount)
							FROM (	SELECT COUNT(project) AS ProjectCount
									FROM Supervise
									GROUP BY prof_id) AS ProjectCounts);

-- Q15: Report each project name, and the professor's contact info(name, office phone number, email)
-- who work on the project. Sort the results by project name.
SELECT DISTINCT S.project, P.prof_name, P.officephone, P.EMail
FROM Supervise S
INNER JOIN Professors P
ON S.prof_id=P.prof_id
ORDER BY S.project;
