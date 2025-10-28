/*

George Leal
Daniel Ng
Lab 06: Advanced Queries
*/

-- Q1: List the names of all artists who have not recorded a title. Use EXISTS.
SELECT ArtistName
FROM Artists A
WHERE EXISTS (	SELECT TitleID 
					FROM Titles T
					WHERE T.ArtistID = A.ArtistID);

-- Q2: Produce a single list of studio names with their web addresses and artist names with their web addresses. Eliminate any studios or artists without a web address in the results.

-- Q3: Report the number of female members, male members, and the total number.  Use proper column names.
SELECT COUNT(Gender) AS 'Total Members',

(SELECT COUNT(Gender)
		FROM Members
		WHERE Gender = 'F') AS 'Female Members',

(SELECT COUNT(Gender)
		FROM Members
		WHERE Gender = 'M') AS 'Male Members'

FROM Members;

-- Q4: Report the number of artists who entered in the same year and the total number (by adding a new row, ex) UNION). 

-- Q5: For each title id, report the number of sound files (if one track has both MP3 file and the RealAud file. then count them as 2).
SELECT TitleID, SUM(MP3 + RealAud) AS NumberOfFiles
FROM Tracks
GROUP BY TitleID
ORDER BY TitleID DESC;

-- Q6: For TitleID 1, report the TitleID, track title, lengthseconds, the average lengthseconds for all tracks of TitleID 1, and the difference value between the lengthseconds and the average value.
SELECT TitleID, TrackTitle, LengthSeconds, LengthSeconds - (SELECT AVG(LengthSeconds) FROM Tracks WHERE TitleID = 1) AS Difference
FROM Tracks
WHERE TitleID = 1
GROUP BY TitleID, TrackTitle, LengthSeconds
UNION
SELECT 1, 'AVERAGE', AVG(LengthSeconds), 0
FROM Tracks
WHERE TitleID = 1;
-- Q7: For each title id, report the TitleID, track number, track title, lengthseconds, the average lengthseconds 
-- for all tracks of the TitleID, and the difference value between the lengthseconds and the average value.  
-- Use correlated sub-queries in the SELECT clause to answer the query.
SELECT TitleID, TrackNum, TrackTitle, LengthSeconds,
(SELECT AVG(LengthSeconds) 
FROM Tracks TR 
WHERE TR.TitleID = T.TitleID) AS AverageLengthSeconds,
LengthSeconds - (SELECT AVG(LengthSeconds) 
				FROM Tracks TR 
				WHERE TR.TitleID = T.TitleID) AS Difference
FROM Tracks T;

-- Q8: Re-design the query in Q7 using sub-queries in the FROM clause.

-- Q9: Report the title name, number of tracks, and total time in minutes for each title. using correlated sub-queries in the SELECT clause
SELECT T.Title, 

(SELECT COUNT(*)
FROM Tracks TR
WHERE TR.TitleID = T.TitleID) AS NumberOfTracks,

(SELECT SUM(LengthSeconds) / 60
FROM Tracks TR
WHERE TR.TitleID = T.TitleID) AS Minutes

FROM Titles T;
-- Q10: Produce a list of all of the area codes used in both member's home phones and studio's phones along with a count of the phone numbers for each area code.
SELECT AreaCode, COUNT(*) AS PhoneCount
FROM (
    SELECT LEFT(HomePhone, 3) AS AreaCode
    FROM Members
    UNION ALL
    SELECT LEFT(Phone, 3) AS AreaCode
    FROM Studios
) AS CombinedPhones
GROUP BY AreaCode
ORDER BY AreaCode;

-- Q11: For each artist, list the artist name and the first and last name (together in one column) 
-- of every member associated with that artist followed on the next line by a count of the number of members associated with that artist. 
-- Include all artists whether they have members or not. 
SELECT 0 AS SEQ, A.ArtistName, CONCAT_WS(' ', M.FirstName, M.LastName) AS 'Member Names'
FROM Artists A
LEFT JOIN XrefArtistsMembers X ON A.ArtistID = X.ArtistID
LEFT JOIN Members M ON X.MemberID = M.MemberID

UNION ALL

SELECT 1 AS SEQ, A.ArtistName, COUNT(M.MemberID) AS MemberCount
FROM Artists A
LEFT JOIN XrefArtistsMembers X ON A.ArtistID = X.ArtistID
LEFT JOIN Members M ON X.MemberID = M.MemberID
GROUP BY ArtistName
ORDER BY ArtistName, SEQ;

-- Q12: Use a correlated sub-query and EXISTS to list all genres that do NOT have recorded titles.

-- Q13: List the artist id and the artist name of all artists who have members not in the USA.