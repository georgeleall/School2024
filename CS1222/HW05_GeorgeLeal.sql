/*
George Leal
HW 05: Functions

*/

-- Q1: List the books published in May in the last 30 years. 
-- Note that your query should remain correct in the future, 
-- which means the numbers 2020 and 2010 should not appear anywhere in the query.
SELECT title_name, pubdate
FROM Titles
WHERE MONTH(pubdate) = 5
AND YEAR(pubdate) BETWEEN YEAR(CURDATE()) - 30 AND YEAR(CURDATE());


-- Q2: List the author names in the form <first initial>, period, space,< last name>, e.g. 'K. Hull'.
-- Order the results first by the last name, then by the first name. 
-- Only list those authors who have both first name and last name in the database.
SELECT CONCAT(LEFT(au_fname, 1), '. ', au_lname) AS 'Author Name'
FROM Authors
WHERE au_fname IS NOT NULL AND au_fname <> '' 
AND au_lname IS NOT NULL AND au_lname <> ''
ORDER BY au_lname, au_fname;

-- Q3: Display the name of those publishers whose name ends with 'Press'.
-- Note: ONLY display the name without 'Press' in it (i.e. OMIT 'Press' in your displayed publisher names).
SELECT LEFT(pub_name, LENGTH(pub_name) - 6) AS Publishers
FROM Publishers
WHERE RIGHT(pub_name, 5) = 'Press';

-- Q4: List the name(s) of the author(s) that wrote the book with the longest title name.
SELECT CONCAT_WS(' ', A.au_fname, A.au_lname) AS 'Author Name'
FROM Authors A
INNER JOIN Title_Authors TA ON A.au_id = TA.au_id
INNER JOIN Titles T ON TA.title_id = T.title_id
WHERE LENGTH(T.title_name) = (	SELECT MAX(LENGTH(title_name))
								FROM Titles);

-- Q5: For each author, list the author id, area code, and the phone number without the area code.
SELECT au_id, LEFT(phone, 3) AS 'Area Code', RIGHT(phone, 8) AS 'Phone Number'
FROM Authors;