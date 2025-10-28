/*

George Leal
Daniel Ng
Lab 09: Views

*/

-- Q1: Create a view that reports the number of artists who entered in the same year and the total number. 

-- Q2: Create a view that reports the artist id and the artist name of all artists who have members not in USA.
CREATE VIEW NotInUSA AS
SELECT ArtistID, ArtistName
FROM Artists
WHERE Country != 'USA';

-- Q3: Modify the view created in question Q2 to report the artist name and web address of all artists who have members not in USA. 

-- Q4: Create a view that lists the names of artists and a count of the number of members assigned to that artist.
CREATE VIEW ArtistsMemberCount AS
SELECT A.ArtistName, COUNT(M.MemberID) AS MemberCount
FROM Artists A
LEFT JOIN XrefArtistsMembers X ON A.ArtistID = X.ArtistID
LEFT JOIN Members M ON X.MemberID = M.MemberID
GROUP BY A.ArtistName;

-- Q5: Create a view that reports all the information of the longest title(s).

-- Q6: Create a view that reports the title ID, track number, track title, lengthseconds, the maximum lengthseconds
-- for all tracks of the title id, and the difference value between the lengthseconds and the maximum value for each title id.
CREATE VIEW TrackInfo AS
SELECT T1.TitleID, T1.TrackNum, T1.TrackTitle, T1.LengthSeconds, T2.MaxLengthSeconds AS LongestTrack,
T1.LengthSeconds - T2.MaxLengthSeconds AS LengthDifference
FROM Tracks T1
JOIN 
(SELECT TitleID, MAX(LengthSeconds) AS MaxLengthSeconds
FROM Tracks
GROUP BY TitleID) T2 
ON T1.TitleID = T2.TitleID;


-- Q7: Create an updatable view that reports the information of all tracks that are longer than 300 seconds. Make sure that no new track shorter than 300 seconds can be inserted into the Tracks table through the view.

-- Q8: Redefine the view created in question Q7 to report the information of all tracks that are longer than 280 seconds.
-- Make sure that no new track shorter than 280 seconds can be inserted into the Tracks table through the view.

-- Q9: Rename the view created in question Q7 to another name

-- Q10: Delete the views created in questions Q3, Q4 and Q5.
