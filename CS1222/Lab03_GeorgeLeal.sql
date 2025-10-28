/*
George Leal

Lab 03: Subqueries and Joins
*/

-- Subqueries, IN, ANY, and ALL:

-- 1. List length of the longest RealAud track in the 'metal' genre.
SELECT MAX(LengthSeconds)
FROM Tracks
WHERE RealAud = 1 AND TitleID IN (SELECT TitleID
								  FROM Titles
								  WHERE Genre = 'metal');

-- 2. List the ArtistID, ArtistName, and EntryDate of all artists whose EntryDate is earlier than everyone who has a 'Directmail' LeadSource.
SELECT ArtistID, ArtistName, EntryDate
FROM Artists
WHERE EntryDate > (	SELECT MIN(EntryDate)
					FROM Artists
					WHERE LeadSource = 'Directmail');

-- 3. List the ArtistID, ArtistName, and EntryDate of all artists whose EntryDate is earlier than anyone who has a 'Directmail' LeadSource.
SELECT ArtistID, ArtistName, EntryDate
FROM Artists
WHERE EntryDate > ALL (	SELECT EntryDate
						FROM Artists
						WHERE LeadSource = 'Directmail');


-- 4. List the ArtistName and EntryDate of the artist with the earliest entry date.
SELECT ArtistName, EntryDate
FROM Artists
WHERE EntryDate <= (SELECT MIN(EntryDate)
					FROM Artists);
-- 5. List the TrackTitle of all tracks in the 'alternative' genre.
SELECT TrackTitle
FROM Tracks
WHERE TitleID IN (	SELECT TitleID
					FROM Titles
                    WHERE Genre = 'alternative');

-- 6. List all the unique genres from the `Genre` table that are not represented in the `Titles` table.
SELECT Genre
FROM Genre
WHERE Genre NOT IN (SELECT Genre
					FROM Titles);

-- 7. List the TrackTitle and length of tracks with a length longer than all tracks in the 'metal' genre. 
-- (Hint: This requires sub-query within a sub-query)
SELECT TrackTitle, LengthSeconds
FROM Tracks
WHERE LengthSeconds > ALL (	SELECT LengthSeconds
							FROM Tracks
							WHERE TitleID IN (	SELECT TitleID
												FROM Titles
												WHERE Genre = 'metal'));

-- 8. List the TrackTitle of the track with the longest length.
SELECT TrackTitle
FROM Tracks
WHERE LengthSeconds = (	SELECT MAX(LengthSeconds)
						FROM Tracks);


-- 9. List the FirstName, LastName, and Birthday of the oldest member WITHOUT using MIN() function. (Hint: use a subquery and ALL)
SELECT FirstName, LastName, Birthday
FROM Members
WHERE Birthday <= ALL (	SELECT Birthday
						FROM Members);

-- 10. List the FirstName, LastName, and Birthday of the second oldest member.
SELECT FirstName, LastName, Birthday
FROM Members
WHERE Birthday IN ( SELECT MIN(Birthday)
					FROM Members
					WHERE Birthday <> ( SELECT MIN(Birthday)
										FROM Members));

-- Equi-Join and Inner Join: (Each question needs TWO answers: one by using Equi-Join, and another one by using Inner Join) 

-- 11.  List the CD title (i.e. `Title` field of `Titles` table) and the TrackTitle of all tracks recorded in the studio with StudioID 1.
-- (Equi-Join)
SELECT T.Title, TR.TrackTitle
FROM Titles T, Tracks TR
WHERE T.TitleID = TR.TitleID AND T.StudioID = 1;

-- (Inner Join)
SELECT T.Title, TR.TrackTitle
FROM Titles T INNER JOIN Tracks TR
ON T.TitleID = TR.TitleID 
WHERE T.StudioID = 1;

-- 12. List each Title from the `Titles` table along with the name of the studio where it was recorded.
-- (Equi-Join)
SELECT T.Title, S.StudioName
FROM Titles T, Studios S
WHERE T.StudioID = S.StudioID;
-- 13. Find the name (including FirstName and LastName) of the salesperson who works with the member with last name 'Alvarez'.
-- (Equi-Join)
SELECT S.FirstName, S.LastName
FROM Members M, SalesPeople S
WHERE M.SalesID = S.SalesID AND M.LastName = 'Alvarez';

-- (Inner Join)
SELECT S.FirstName, S.LastName
FROM Members M INNER JOIN SalesPeople S
ON M.SalesID = S.SalesID
WHERE M.LastName = 'Alvarez';


-- 14. List the name of members from California(CA) and their salespeople's name.
-- (Equi-Join)
SELECT M.FirstName, M.LastName, S.FirstName, S.LastName
FROM Members M, SalesPeople S
WHERE M.SalesID = S.SalesID AND M.Region = 'CA';

-- (Inner Join)
SELECT M.FirstName, M.LastName, S.FirstName, S.LastName
FROM Members M INNER JOIN SalesPeople S
ON  M.SalesID = S.SalesID
WHERE M.Region = 'CA';

-- 15. List the name of all artists who have recorded more than one CD titles and the number of titles they have.
-- (Equi-Join)
SELECT A.ArtistName, COUNT(*) AS Number_Titles
FROM Artists A, Titles T
WHERE A.ArtistID = T.ArtistID
GROUP BY A.ArtistName
HAVING COUNT(*) > 1;

-- (Inner Join)
SELECT A.ArtistName, COUNT(*) AS Number_Titles
FROM Artists A INNER JOIN Titles T
ON A.ArtistID = T.ArtistID
GROUP BY A.ArtistName
HAVING COUNT(*) > 1;

-- 16. List the CD title (i.e. `Title` field of `Titles` table) and the number of tracks 
-- (NOT `TrackNum` field) for any title with fewer than 9 tracks.
-- (Equi-Join)
SELECT T.Title, COUNT(*) AS NumberOfTracks
FROM Titles T, Tracks TR
WHERE T.TitleID = TR.TitleID
GROUP BY T.Title
HAVING COUNT(*) < 9;

-- (Inner Join)
SELECT T.Title, COUNT(*) AS NumberOfTracks
FROM Titles T INNER JOIN Tracks TR
ON T.TitleID = TR.TitleID
GROUP BY T.Title
HAVING COUNT(*) < 9;

