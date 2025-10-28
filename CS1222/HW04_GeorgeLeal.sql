/*
George Leal

HW 04: More Joins
*/

-- Q1: Report the names of all authors and the title_name of the books (if any) they have written.
SELECT A.au_fname, A.au_lname, T.title_name
FROM Authors A 
LEFT JOIN Title_Authors TA ON A.au_id = TA.au_id
LEFT JOIN Titles T ON T.title_id = TA.title_id;

-- Q2: For each author, report the author name and the number of books that he/she wrote, if any.
SELECT A.au_fname, A.au_lname, COUNT(TA.title_id) AS NumberOfBooks
FROM Authors A 
LEFT JOIN Title_Authors TA ON A.au_id = TA.au_id
GROUP BY A.au_fname, A.au_lname;

-- Q3: For each author who has written a book,  list the author name, title name, and the royalty_rate.
SELECT A.au_fname, A.au_lname, T.title_name, R.royalty_rate
From Authors A 
LEFT JOIN Title_Authors TA ON A.au_id = TA.au_id
LEFT JOIN Titles T ON TA.title_id = T.title_id
LEFT JOIN Royalties R ON T.title_id = R.title_id;

-- Q4: Find the name of the publisher that published the book with the greatest royalty rate.
SELECT P.pub_name
FROM Publishers P
LEFT JOIN Titles T ON P.pub_id = T.pub_id
LEFT JOIN Royalties R ON T.title_id = R.title_id
WHERE R.royalty_rate = (SELECT MAX(royalty_rate)
						FROM Royalties);
                        
-- Q5: Find the title name of the latest published book, the name of its author, and the publisher's name.
SELECT T.title_name, A.au_fname, A.au_lname, P.pub_name
FROM Titles T
LEFT JOIN Title_Authors TA ON T.title_id = TA.title_id
LEFT JOIN Authors A ON A.au_id = TA.au_id
LEFT JOIN Publishers P ON T.pub_id = P.pub_id
WHERE T.pubdate = (	SELECT MAX(pubdate)
					FROM Titles);

-- Q6: List the name of all publishers, the number of books, and the maximum price of the book they have published (if any).
SELECT P.pub_name, MAX(T.price), COUNT(T.title_id)
FROM Publishers P
LEFT JOIN Titles T ON P.pub_id = T.pub_id
GROUP BY P.pub_name;

-- Q7: For each book, list the book name, the author name, and the publisher's name.
SELECT T.title_name, A.au_fname, A.au_lname, P.pub_name
FROM Titles T
LEFT JOIN Title_Authors TA ON T.title_id = TA.title_id
LEFT JOIN Authors A ON TA.au_id = A.au_id
LEFT JOIN Publishers P ON T.pub_id = P.pub_id;

-- Q8: Find the name of the author who wrote the longest book in terms of pages.
SELECT A.au_fname, A.au_lname
FROM Authors A
LEFT JOIN Title_Authors TA ON TA.au_id = A.au_id
LEFT JOIN Titles T ON TA.title_id = T.title_id
WHERE T.pages IN (SELECT MAX(pages)
				FROM Titles);
