/*
George Leal
Daniel Ng

Lab 04: More Joins
*/

-- 1. List the name of the artist who recorded the track title 'Front Door'.
SELECT A.ArtistName
FROM Artists A
WHERE A.ArtistID = (SELECT ArtistID
                    FROM Titles
                    WHERE TitleID = (SELECT TitleID
                                    FROM Tracks
                                    WHERE TrackTitle = 'Front Door'));
                                    
-- 2. Report the names of all artists that came from the leadsource e-mail and that have not recorded a title.
SELECT ArtistName
FROM Artists
WHERE LeadSource = 'Email' AND ArtistID NOT IN (SELECT ArtistID
												FROM Titles);

-- 3. List the names of all artists and a count of the number of members (if any) assigned to that artist. (use outer join)
SELECT A.ArtistName, COUNT(X.MemberID)
FROM Artists A LEFT JOIN XrefArtistsMembers X 
ON A.ArtistID = X.ArtistID
GROUP BY A.ArtistName;

-- 4. List the names of all artists and the StudioID (if any) they worked in. (use outer join)
SELECT A.ArtistName, T.StudioID
FROM Artists A LEFT JOIN Titles T
ON A.ArtistID = T.ArtistID;

-- 5. List the names of all salespeople and a count of the number of members they work with. (use outer join)
SELECT S.FirstName, S.LastName, COUNT(M.MemberID)
FROM SalesPeople S LEFT JOIN Members M
ON S.SalesID = M.SalesID
GROUP BY S.FirstName, S.LastName;

-- 6. Each member is given his or her salesperson as a primary contact name and also the name of that salesperson's supervisor 
-- as a secondary contact name. Produce a list of member names and the primary and secondary contacts for each.
SELECT 	M.FirstName AS 'FName_M', M.LastName AS 'LName_M', 
		S.FirstName AS 'FName_Prim', S.LastName AS 'LName_Prim',
		V.FirstName AS 'FName_Second', V.LastName AS 'LName_Second'
FROM Members M
INNER JOIN SalesPeople S ON M.SalesID = S.SalesID
INNER JOIN SalesPeople V ON S.Supervisor = V.SalesID;

-- 7. List any salesperson (name) whose supervisor is NOT supervised by any one. (use outer join)
SELECT *
FROM SalesPeople S 
LEFT JOIN SalesPeople V ON S.Supervisor = V.SalesID
WHERE S.Supervisor IS NOT NULL AND V.Supervisor IS NULL;

-- 8. List the names of members with the Artist name of 'Highlander'.
SELECT M.FirstName, M.LastName
FROM Members M
INNER JOIN XrefArtistsMembers X ON M.MemberID = X.MemberID
INNER JOIN Artists A ON X.ArtistID = A.ArtistID
WHERE ArtistName = 'Highlander';

-- 9. List each title from the Title table along with the name of the studio where it was recorded,
-- the name of the artist, and the number of tracks on the title.
SELECT T.Title, S.StudioName, A.ArtistName, COUNT(R.TitleID) AS NumOfTracks
FROM Titles T
INNER JOIN Studios S ON T.StudioID = S.StudioID
INNER JOIN Artists A ON T.ArtistID = A.ArtistID
INNER JOIN Tracks R ON T.TitleID = R.TitleID
GROUP BY T.Title, S.StudioName, A.ArtistName;

-- 10. List all genres from the Genre table that are not represented in the Titles table. (use outer join)
SELECT G.Genre
FROM Genre G
LEFT JOIN Titles T ON G.Genre = T.Genre
WHERE G.Genre NOT IN (SELECT Genre
					  FROM Titles);

-- 11. List each genre from the genre table and the total length in minutes of all tracks recorded for that genre if any.  (use outer join)
SELECT G.Genre, SUM(Tr.LengthSeconds) / 60 AS Minutes
FROM Genre G LEFT JOIN Titles T
ON G.Genre = T.Genre
LEFT JOIN Tracks Tr
ON T.TitleID = Tr.TitleID
GROUP BY G.Genre;

-- 12. List the names of responsible parties along with the artist name of the artist they are responsible for.
SELECT M.FirstName, M.LastName, A.ArtistName
FROM Members M
INNER JOIN XrefArtistsMembers X ON M.MemberID = X.MemberID
INNER JOIN Artists A ON X.ArtistID = A.ArtistID
WHERE X.RespParty = 1;
