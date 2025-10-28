/* 
George Leal
HW 01: SQL Basics
*/

-- 1) View the table Publishers and design the following queries:

-- 1.
SELECT *
FROM Publishers;

-- 2.
SELECT DISTINCT pub_name
FROM Publishers;

-- 3.
SELECT *
FROM Publishers
WHERE State = 'CA';

-- 2) View the table Titles and design the following queries:

-- 4.
SELECT *
FROM Titles
WHERE Type = 'History';

-- 5. 
SELECT title_name, sales, pubdate
FROM Titles
WHERE pub_id = 'P01';