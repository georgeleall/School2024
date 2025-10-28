/*
George Leal

HW 02: Aggregate
*/

-- 1. 
SELECT title_id, COUNT(au_id)
FROM Title_Authors
GROUP BY title_id;

-- 2.
SELECT State, COUNT(*)
FROM Authors
GROUP BY State;

-- 3.
SELECT Type, COUNT(*),AVG(pages)
FROM Titles
GROUP BY Type;

-- 4. 
SELECT pub_id AS "Publisher_ID" , COUNT(*) AS "Number" , MIN(price) AS "Min Price", MAX(price) AS "Max Price",AVG(price) AS "Average Price"
FROM Titles
GROUP BY pub_id
ORDER BY AVG(price);

-- 5.
SELECT type, AVG(price) AS avg_price
FROM Titles
WHERE price > 10
GROUP BY type
HAVING AVG(price) > 15
ORDER BY avg_price DESC;

-- 6.
SELECT DISTINCT au_fname, au_lname
FROM Authors
WHERE address Like '%St%';
