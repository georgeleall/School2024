SELECT *
FROM Students;

SELECT *
FROM Students
WHERE EntryDate BETWEEN '2003-01-01' AND '2003-12-31';

SELECT student_name
FROM Students
WHERE student_name LIKE '%in%';

SELECT student_name, age
FROM Students
WHERE EntryDate = (	SELECT MIN(EntryDate)
					FROM Students);
                    
SELECT Gender, COUNT(*) AS Number_Of_Gender
FROM Students
GROUP BY Gender
-- Sort by Gender is ORDER BY
ORDER BY Gender DESC; -- DO NOT FORGET TO LOOK AT HOW SHE WANTS IT ORDERED!

SELECT prof_name
FROM Professors
WHERE dept = 'CS';

SELECT *
FROM Professors
WHERE officephone LIKE '%3112';

SELECT dept, COUNT(*)
FROM Professors
GROUP BY dept
HAVING COUNT(*) <= 	ALL (SELECT COUNT(*)
					FROM Professors
                    GROUP BY dept);
                    
SELECT * 
FROM Supervise;

SELECT prof_id, COUNT(DISTINCT student_id)
FROM Supervise
GROUP BY prof_id;

SELECT DISTINCT student_id, COUNT(DISTINCT prof_id)
FROM Supervise
GROUP BY student_id;

SELECT S.student_name, COUNT(DISTINCT SE.project)
FROM Students S, Supervise SE
WHERE S.student_id = SE.student_id
GROUP BY S.student_name;

SELECT S.student_name, COUNT(DISTINCT SE.project)
FROM Students S
INNER JOIN Supervise SE
ON S.student_id = SE.student_id
GROUP BY S.student_name;

SELECT student_name
FROM Students
WHERE student_id NOT IN (SELECT student_id
						 FROM Supervise);
                         -- NOT IN works here because the table doesn't show where students dont have a project so
                         -- NOT IN will show which students arent in the table of projects.