/*
George Leal
Final Exam
*/

-- Q1 [5pt]: Report the names of the professor whose office phone numbers end with 21.
SELECT prof_name
FROM Professors
WHERE officephone LIKE '%21';

-- Q2 [5pt]: Report the names of the professors who supervise more than 2 students. Use Inner Join method.
SELECT p.prof_name, COUNT(s.student_id) AS student_count
FROM Professors p
INNER JOIN Supervise s ON p.prof_id = s.prof_id
GROUP BY p.prof_id, p.prof_name
HAVING COUNT(s.student_id) > 2;

-- Q3 [5pt]: Report the number of students who entered in the same year, and the total number of students at the last row.
SELECT 
    YEAR(EntryDate) AS EntryYear, 
    COUNT(*) AS StudentCount
FROM Students
GROUP BY YEAR(EntryDate) WITH ROLLUP;

-- Q4 [6pt]: Report the department with the least number of professors, and the number of professors.
SELECT dept, COUNT(*)
FROM Professors
GROUP BY dept
HAVING COUNT(*) = (	SELECT MIN(DeptCount)
					FROM (	SELECT COUNT(*) AS DeptCount
							FROM Professors
							GROUP BY dept)AS Count);

-- Q5 [5pt]: For each project, list the project name, the names of the professors and students who work on the project. 
-- Sort the results by project name.
SELECT SR.project, P.prof_name, S.student_name
FROM Supervise SR
INNER JOIN Professors P ON P.prof_id = SR.prof_id
INNER JOIN Students S ON SR.student_id = S.student_id
ORDER BY SR.project;

-- Q6 [5pt]: Find the names of professors who do NOT supervise any student.
SELECT P.prof_name
FROM Professors P
WHERE P.prof_id NOT IN (SELECT S.prof_id
						FROM Supervise S);

-- Q7 [5pt]: Find the name(s) of the professor who has the longest name.
SELECT prof_name
FROM Professors
WHERE LENGTH(prof_name) = (	SELECT MAX(LENGTH(prof_name))
							FROM Professors);

-- Q8 [6pt]: Report the names of all students (only once) and whether they have a supervisor or not. The format of the output is as follows:
SELECT S.student_name,
	CASE
		WHEN SR.prof_id IS NOT NULL THEN 'YES'
        ELSE 'NO'
	END AS 'Supervisor'
FROM Students S
LEFT JOIN Supervise SR ON S.student_id = SR.student_id;

-- Q9 [6pt]: For each professor, display the name of the professor, 
-- the name of the student the professor supervises, followed on the next 
-- line by the total number of students the professor supervises.
SELECT P.prof_name, S.student_name
FROM Professors P
LEFT JOIN Supervise SR ON P.prof_id = SR.prof_id
LEFT JOIN Students S ON SR.student_id = S.student_id

UNION ALL

SELECT P.prof_name, CONCAT('Total ', COUNT(SR.student_id))
FROM Professors P
LEFT JOIN Supervise SR ON P.prof_id = SR.prof_id
GROUP BY P.prof_name
ORDER BY prof_name, student_name;

-- Q10 [5pt]: List the names of all students and projects they work on (if any).
SELECT S.student_name, SR.project
FROM Students S
LEFT JOIN Supervise SR ON S.student_id = SR.student_id
WHERE SR.project IS NOT NULL;

-- Q11 [5pt]: Add a new attribute cellphone to the Students table. The attribute is a string with 10 letters.
ALTER TABLE Students
ADD COLUMN cellphone VARCHAR(10);

-- Q12 [6pt]: Professor Charlie agrees to supervise student 0008 on the project 'project07' 
-- starting on 2023-08-21. Insert a new row into the Supervise table. Note: you can NOT use 
-- professor Charlie's prof_id directly in your query.
INSERT INTO Supervise (prof_id, student_id, project, startdate)
SELECT prof_id, 0008, 'project07', '2023-08-21'
FROM Professors
WHERE prof_name = 'Charlie';

-- Q13 [5pt]: Add a primary key constraint to the Supervise table. 
-- The primary key is the combination of prof_id, student_id, and project. 
-- Please use the proper naming conventions.
ALTER TABLE Supervise
ADD CONSTRAINT pk_supervise PRIMARY KEY (prof_id, student_id, project);

-- Q14 [5pt]: Add a foreign key constraint to the Supervise table. 
-- The prof_id in the Supervise table refers to prof_id in the Professors table.
-- Use the proper naming conventions. 
-- Note: you should make prof_id the primary key of the Professors table before you create the foreign key constraint. 
ALTER TABLE Professors
ADD CONSTRAINT pk_professors PRIMARY KEY (prof_id);

ALTER TABLE Supervise
ADD CONSTRAINT fk_supervise FOREIGN KEY (prof_id) REFERENCES Professors (prof_id);

-- Q15 [6pt]: Create an updatable view that reports the department of CE and the professor names of the department.
--  Make sure that no other department than CE can be inserted into the Professors table through the view.
CREATE OR REPLACE VIEW ce_professors AS
SELECT prof_id, prof_name, dept
FROM Professors
WHERE dept = 'CE';

DELIMITER $$

CREATE TRIGGER before_insert_professors
BEFORE INSERT ON Professors
FOR EACH ROW
BEGIN
    IF NEW.dept != 'CE' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Only department CE can be inserted';
    END IF;
END $$

DELIMITER ;


-- Q16 [10pt]: Create a trigger called before_supervise_update. 
-- Before any row in the Supervise table is updated, the trigger should insert a tuple into the 
-- Supervise_Audit table to keep the prof_id, student_id, project, startdate, and the timestamp of the update.  
-- The following is the definition of the Supervise_Audit table.

DELIMITER $$

CREATE TRIGGER before_supervise_update
BEFORE UPDATE ON Supervise
FOR EACH ROW
BEGIN
    INSERT INTO Supervise_Audit (prof_id, student_id, project, startdate, changedate, action)
    VALUES (OLD.prof_id, OLD.student_id, OLD.project, OLD.startdate, NOW(), 'UPDATE');
END $$

DELIMITER ;


CREATE TABLE Supervise_Audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prof_id INT NOT NULL, 
    student_id INT NOT NULL,
    project VARCHAR(10) NOT NULL,
    startdate DATE NOT NULL,
    changedate DATETIME DEFAULT NULL,
    action VARCHAR(25) DEFAULT 'UPDATE'
);
-- Q17 [10pt]: Create a trigger called before_supervise_insert. Before a new row is inserted into the Supervise table,
-- the Supervise_Total table is updated to reflect the total number of students the corresponding supervisor has. 
-- Note: If the supervisor is NOT in the Supervise table, you should insert a new tuple into the Supervise_Total table. 
-- Otherwise, just update the Supervise_Total table. The following is the definition of the Supervise_Total table.
DELIMITER $$

CREATE TRIGGER before_supervise_insert
BEFORE INSERT ON Supervise
FOR EACH ROW
BEGIN
    DECLARE student_count INT;
    
    SELECT COUNT(*)
    INTO student_count
    FROM Supervise_Total
    WHERE prof_id = NEW.prof_id;

    IF student_count > 0 THEN
        UPDATE Supervise_Total
        SET total = total + 1
        WHERE prof_id = NEW.prof_id;
    ELSE
        INSERT INTO Supervise_Total (prof_id, total, action)
        VALUES (NEW.prof_id, 1, 'INSERT');
    END IF;
END $$

DELIMITER ;



CREATE TABLE Supervise_Total(
    id INT AUTO_INCREMENT PRIMARY KEY,
    prof_id INT NOT NULL,
    total INT NOT NULL,
    action VARCHAR(25) DEFAULT 'INSERT'
);

-- Populate the table with the following queries:
INSERT INTO Supervise_Total(prof_id, total)
SELECT prof_id, count(*)
FROM Supervise
GROUP BY prof_id;
