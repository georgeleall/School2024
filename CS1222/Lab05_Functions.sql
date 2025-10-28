/*
George Leal
Daniel Ng

Lab 05: Functions
*/

-- Q1: For each member, report the member name and home phone number. 
-- Concatenate the first and last name of each member with a whitespace between.
SELECT CONCAT(FirstName, ' ', LastName) AS Members, HomePhone
FROM Members;

-- Q2: For each member, report the member name and the age of the member.
SELECT CONCAT(FirstName, ' ', LastName) AS Name, FLOOR((DateDiff(CURDATE(), Birthday) / 365)) AS Age
FROM Members;

-- Q3: Report the studio name and the first name of each studio contact. Hint: the first name is the part before the space.
SELECT StudioName, Substring(Contact, 1, LOCATE(' ', Contact) - 1) AS FirstName
FROM Studios;

-- Q4: Report the studio name and the last name of each studio contact. Hint: the last name is the part that follows the space.
SELECT StudioName, SUBSTR(Contact, Locate(' ', Contact) + 1) AS LastName
FROM Studios;

-- Q5: Report the track title with the most characters.
SELECT TrackTitle
FROM Tracks
WHERE Length(TrackTitle) = (SELECT MAX(Length(TrackTitle))
							FROM Tracks);

-- Q6:  List every genre from the Genre table and the names of any titles in that genre if any. 
-- For any genre without titles, display 'No Titles' in the Title column.
SELECT G.Genre, IfNull(T.Title, 'No Titles') AS Titles
FROM Genre G LEFT JOIN Titles T
ON G.Genre = T.Genre;

-- Q7: Report all the genres from the Genre table. 
-- Capitalize the first letter of each genre and the rest of the letters should be lower case.
SELECT CONCAT(UPPER(LEFT(Genre, 1)), LOWER(SUBSTRING(Genre, 2))) AS Genre
FROM Genre;

-- Q8: Redo Q6 using CASE.
SELECT G.Genre, 
CASE 
    WHEN T.Title IS NULL THEN 'No Titles'
    ELSE T.Title
END AS Title
FROM Genre G LEFT JOIN Titles T
ON G.Genre = T.Genre;
-- Q9: List each artist name and a lead source designation. If the lead source is 'Ad', then report 'Ad' for the lead source designation. 
-- If the lead source is anything else, then report 'Not Ad' for the lead source designation.
SELECT ArtistName,
CASE
	WHEN LeadSource = 'Ad' THEN 'Ad'
    ELSE 'Not Ad'
    END AS LeadSource
FROM Artists;

-- Q10: Report the artist name and the age in years of the responsible member for each artist at the time of that artist's entry date.
SELECT A.ArtistName, FLOOR(DateDiff(A.EntryDate, M.Birthday) / 365) AS Age
FROM Artists A INNER JOIN XrefArtistsMembers X
ON A.ArtistID = X.ArtistID
INNER JOIN Members M
ON X.MemberID = M.MemberID
WHERE X.RespParty = 1;