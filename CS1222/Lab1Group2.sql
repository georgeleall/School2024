/* 
Group 2

George Leal
Alvaro Guillen

Lab 1
*/


-- 1. 
SELECT Title, UPC, Genre
FROM Titles;

-- 2.
SELECT *
FROM Titles
WHERE ArtistID = 2;

-- 3. 
SELECT FirstName, LastName, HomePhone, EMail
FROM Members;

-- 4.
SELECT MemberID
FROM Members
WHERE Gender = "M";

-- 5.
SELECT MemberID, Country
FROM Members
WHERE Country = "Canada";

-- 6.
SELECT TitleID, TrackTitle, LengthSeconds
FROM Tracks
WHERE (LengthSeconds > 300 AND MP3 IS FALSE);

-- 7.
SELECT FirstName, LastName, WorkPhone
FROM Members
WHERE WorkPhone IS NOT NULL;

-- 8.
SELECT DISTINCT LeadSource
FROM Artists;

-- 9.
SELECT StudioName AS Studio_Name, PostalCode AS Post_code, Phone
FROM Studios;

-- 10.
SELECT ArtistName, EntryDate
FROM Artists
WHERE EntryDate BETWEEN '2002-01-01' AND '2002-12-31';

-- 11.
SELECT FirstName AS "First Name" ,LastName AS "Last Name", (Base * 5) AS "Weekly Salary"
FROM SalesPeople
WHERE (Base * 5) > 1000;

-- 12. 
SELECT *
FROM Tracks
WHERE TrackNum = TitleID;


