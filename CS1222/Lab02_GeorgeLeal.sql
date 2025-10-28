/* 

George Leal
Lab 02: Aggregate

*/

-- Like and Wildcards:

-- 1. 
SELECT FirstName, LastName, HomePhone, Gender
FROM Members
WHERE Region = 'GA' AND (HomePhone LIKE '822%' OR Gender = "F");

-- 2.
SELECT TitleID, Title, UPC
FROM Titles
WHERE UPC LIKE '%2';

-- 3.
SELECT TitleID, TrackNum, TrackTitle
FROM Tracks
WHERE TrackTitle LIKE 'Song%';

-- Aggregate calculations for a table or a group:

-- 4.
SELECT (AVG(LengthSeconds)/60) AS Average, 
	(MIN(LengthSeconds)/60) AS Shortest, 
    (MAX(LengthSeconds)/60) AS Longest
FROM Tracks;

-- 5.
SELECT SUM(LengthSeconds) / 60
FROM Tracks
WHERE LengthSeconds > 150;

-- 6. 
SELECT COUNT(TrackTitle), AVG(LengthSeconds)
FROM Tracks
WHERE TrackTitle LIKE 'S%';

-- 7. 
SELECT COUNT(TrackTitle), SUM(LengthSeconds), AVG(LengthSeconds)
FROM Tracks
WHERE TitleID = "4";

-- 8.
SELECT COUNT(*)
FROM Members
WHERE Gender = 'M' AND COUNTRY = 'USA';

-- Aggregate calculations for multiple groups:

-- 9.
SELECT TitleID, COUNT(*)
FROM Tracks
GROUP BY TitleID;

-- 10. 
SELECT TitleID, (LengthSeconds)/60
FROM Tracks;

-- 11. 
SELECT Region, COUNT(*)
FROM Members
GROUP BY Region
ORDER BY Region;

-- 12.
SELECT Region, Gender, Count(*)
FROM Members
GROUP BY Region,Gender
ORDER BY Region;

-- 13. 
SELECT TitleID, AVG(LengthSeconds)/60 AS Avg, 
				MIN(LengthSeconds)/60 AS Shortest, 
                MAX(LengthSeconds)/60 AS Longest
FROM Tracks
GROUP BY TitleID;

-- 14.
SELECT LeadSource, COUNT(*),
				   MIN(EntryDate),
                   MAX(EntryDate)
FROM Artists
GROUP BY LeadSource;

-- 15. 
SELECT TitleID, AVG(LengthSeconds)/60 AS Average, 
				MIN(LengthSeconds)/60 AS Shortest, 
                MAX(LengthSeconds)/60 AS Longest
FROM Tracks
GROUP BY TitleID
HAVING AVG(LengthSeconds)/60 > 3;

-- 16. 
SELECT TitleID, AVG(LengthSeconds)/60 AS Average, 
				MIN(LengthSeconds)/60 AS Shortest, 
                MAX(LengthSeconds)/60 AS Longest
FROM Tracks
WHERE MP3 IS TRUE
GROUP BY TitleID
HAVING AVG(LengthSeconds)/60 > 3;

-- 17. 
SELECT TitleID, COUNT(*)
FROM Tracks
GROUP BY TitleID
HAVING COUNT(*) < 9;


-- 18.
SELECT Region,COUNT(*)
FROM Members
WHERE EMail IS NOT NULL
GROUP BY Region
HAVING COUNT(*) > 1;

