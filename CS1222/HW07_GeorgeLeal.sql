/*
George Leal
HW 07: DML and DDL
*/

-- Q1: Use the CREATE TABLE statement to create a table Authors2 which has exactly the same fields as the `Authors` table.
CREATE TABLE Authors2 LIKE Authors;

-- Q2: Use INSERT INTO ... SELECT to populate Authors2 with the content of the `Authors` table.
INSERT INTO Authors2
SELECT *
FROM Authors;

-- Q3: We finally found out that the missing first name of Kellsey is "Buford". Write a query to update the information in Authors2. Note that there might be more than one author with the last name Kellsey.
UPDATE Authors2
SET au_fname = 'Buford'
WHERE au_lname = 'Kellsey';

-- Q4: Add a new column email to Authors2.
ALTER TABLE Authors2
ADD Email VARCHAR(255) NULL;

-- Q5: The email of an author is in the form: first letter of the first name in lower case, last name in lower case, @hotmail.com.
-- e.g. Sarah Buckman's email address would be sbuckman@hotmail.com. Write a query to fill in the email information in Authors2.
UPDATE Authors2
SET Email = CONCAT(LOWER(SUBSTRING(au_fname, 1, 1)), LOWER(au_lname), '@hotmail.com');

-- Q6: The area code 415 in San Francisco has changed to 475. Write a query to update the information in authors2.
-- You may assume that the phone numbers are in the form ###-###-####, where the first 3 digits are the area code.
UPDATE Authors2
SET phone = CONCAT('475-', SUBSTRING(phone, 5))
WHERE phone LIKE '415-%';

-- Q7: Delete from Authors2 all authors who have authored books published by 'Tenterhooks Press'
DELETE FROM Authors2
WHERE au_id IN 
(SELECT au_id FROM (SELECT A.au_id
					FROM Authors2 A
					LEFT JOIN Title_Authors TA ON A.au_id = TA.au_id
					LEFT JOIN Titles T ON TA.title_id = T.title_id
					LEFT JOIN Publishers P ON T.pub_id = P.pub_id
					WHERE P.pub_name = 'Tenterhooks Press')AS Query);

-- Q8: Delete the inserted column email from Authors2.
ALTER TABLE Authors2
DROP COLUMN Email;

