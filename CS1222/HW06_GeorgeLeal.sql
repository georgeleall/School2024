-- Q1: Produce a single list of names, cities, and states for all authors and publishers. Use 'A' and 'P' to identify the source.
SELECT CONCAT('A. ', CONCAT_WS(' ', A.au_fname, A.au_lname)) AS Names, A.city, A.state
FROM Authors A

UNION

SELECT CONCAT('P. ', P.pub_name), P.city, P.state
FROM Publishers P;

-- Q2: For each book type, report all the book names of the type,  followed on the next line by a count of the number of books. 
SELECT 0 AS SEQ, type, title_name
FROM Titles

UNION ALL

SELECT 1 AS SEQ, type, CONCAT('Total number of books: ', COUNT(*)) AS title_name
FROM Titles
GROUP BY type
ORDER BY type, SEQ;

-- Q3: For each publisher, report the publisher's name and the name of authors who have books published by this publisher. 
-- Use EXISTS and correlated sub-queries.
SELECT P.pub_name, CONCAT_WS(' ', A.au_fname, A.au_lname) AS 'Author Name'
FROM Publishers P
INNER JOIN Titles T ON P.pub_id = T.pub_id
INNER JOIN Title_Authors TA ON T.title_id = TA.title_id
INNER JOIN Authors A ON TA.au_id = A.au_id
WHERE EXISTS (	SELECT 1
				FROM Titles T2
				WHERE T2.pub_id = P.pub_id
				AND T2.title_id = TA.title_id);

-- Q4: For each book type, report the title name, the number of pages of the title, the average number of pages for all books for this book type,
-- and the difference between the two. Use correlated sub-queries in the SELECT clause.  
-- Please note: the average number is NOT for all books in the Titles table.
SELECT T.type, T.title_name, T.pages,
(SELECT AVG(T2.pages)
FROM Titles T2
WHERE T2.type = T.type) AS 'Average Pages' ,T.pages - (SELECT AVG(T2.pages)
														FROM Titles T2
														WHERE T2.type = T.type) AS Difference
FROM Titles T
GROUP BY T.type,T.title_name, T.pages;

-- Q5: Re-design the query in Q4 using sub-queries in the FROM clause.
SELECT T.type, T.title_name, T.pages, AvgPages.AvgPages AS 'Average Pages', T.pages - AvgPages.AvgPages AS Difference
FROM Titles T
INNER JOIN (SELECT type, AVG(pages) AS AvgPages
FROM Titles
GROUP BY type) 
AvgPages ON T.type = AvgPages.type;
