/*
George Leal
HW 09: Views
*/

-- Q1: Create a view to report the name(s) of the author(s) that have not written any book.
CREATE VIEW NoBooks AS
SELECT CONCAT_WS(' ', au_fname, au_lname) AS 'Author Name'
FROM Authors A
LEFT JOIN Title_Authors TA ON A.au_id = TA.au_id
WHERE title_id IS NULL;

-- Q2: Create a view to report the author name, title name and the royalty_rate of each author.
CREATE VIEW AuthorInfo AS
SELECT CONCAT_WS(' ', A.au_fname, A.au_lname) AS 'Author Name', T.title_name, R.royalty_rate
FROM Authors A
LEFT JOIN Title_Authors TA ON A.au_id = TA.au_id
LEFT JOIN Titles T ON TA.title_id = T.title_id
LEFT JOIN Royalties R ON T.title_id = R.title_id;

-- Q3: Create a view to report the name of the publisher that published the book with the smallest royalty rate.
CREATE VIEW PublisherSmallRoyalty AS
SELECT P.pub_name
FROM Publishers P
INNER JOIN Titles T ON P.pub_id = T.pub_id
INNER JOIN Royalties R ON T.title_id = R.title_id
WHERE R.royalty_rate = (SELECT MIN(royalty_rate)
						FROM Royalties);

-- Q4: Create an updatable view that reports the information of books with price greater than $18.
-- Make sure that new books with price smaller than $18 cannot be inserted into the Books table through this view.
CREATE VIEW Books19andUp AS
SELECT *
FROM Titles
WHERE price > 18;

-- Q5: Redefine the view created in question Q4. Change the price to $20. Everything else is the same.
ALTER VIEW Books19andUp AS
SELECT title_id, title_name, type, pub_id, pages, 20 AS price, sales, pubdate, contract
FROM Titles
WHERE price > 18;