/*
George Leal
HW 03: Subqueries and Joins 
*/

-- 1. List the title_name and book type of books that are more expensive than all 'history' books.
SELECT title_name, type
FROM Titles
WHERE price > ALL ( SELECT price
					FROM Titles
					WHERE type = 'history');

-- 2. List the title_id and au_id of books written by the authors whose last name is 'Hull'.
SELECT T.title_id, A.au_id
FROM Title_Authors T, Authors A
WHERE T.au_id = A.au_id AND A.au_lname = 'Hull';

-- 3. Find the name(s) of the author(s) that have NOT written any book.
SELECT A.au_fname, A.au_lname
FROM Authors A
WHERE A.au_id NOT IN ( 	SELECT T.au_id
						FROM Title_Authors T);

-- 4. Find the id(s) of the author(s) who have written 'children' books.
SELECT TA.au_id
FROM Title_Authors TA, Titles T
WHERE TA.title_id = T.title_id AND T.type = 'children';

-- 5. Find the name(s) of the publisher(s) that have published more than one books.
SELECT P.pub_id, COUNT(*) AS Book_Count
FROM Publishers P, Titles T
WHERE P.pub_id = T.pub_id
GROUP BY P.pub_id
HAVING COUNT(*) > 1;

-- 6. List the title_name and book type of books that have the lowest royalty rate.
SELECT T.title_name, T.type
FROM Titles T, Royalties R
WHERE T.title_id = R.title_id AND R.royalty_rate = (SELECT MIN(royalty_rate)
													FROM Royalties);
                        
-- 7. Find the pub_id  of the publisher(s) that have published the LEAST expensive book.
SELECT pub_id
FROM Titles
WHERE price = (	SELECT MIN(price)
				FROM Titles);

-- 8. Find the name(s) of the publisher(s) that published the book with the greatest number of pages.
SELECT P.pub_name
FROM Publishers P, Titles T
WHERE P.pub_id = T.pub_id AND T.pages = (SELECT MAX(pages)
										 FROM Titles);