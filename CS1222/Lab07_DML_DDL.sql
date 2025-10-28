/* 
George Leal
Daniel Ng
Lab 07: DML and DDL
*/

-- Q1: Add a new artist with the following information. Use a proper function to automatically get today's date.

-- Q2: The title 'Time Flies' now has a new track, the 11th track 'Spring', which is 150 seconds long and has only an MP3 file.
-- Insert the new track into the Tracks table.
INSERT INTO Tracks (TitleID, TrackNum, TrackTitle, LengthSeconds, MP3, RealAud)
VALUES (4, 11, 'Spring', 150, 1, 0);

SELECT *
FROM Tracks;

-- Q3: Create a new table called Members2 with the fields as the Members table.
CREATE TABLE Members2 LIKE Members;

-- Q4: Populate Members2 the content of the Members table.
INSERT INTO Members2
SELECT *
FROM Members;

-- Q5: The area code for Columbus, Ohio has been changed from 277 to 899. 
-- Update the homephone and workphone numbers of all members in the Members2 table accordingly.

-- Q6: Salesperson Bob Bentley has agreed to turn over all his female members to salesperson Lisa Williams whose sales id is 2.
-- Update the Members2 table accordingly. 
UPDATE Members2
SET SalesID = 2
WHERE SalesID=1 AND Gender = 'F';

-- Q7: Members Doug Finney and Terry Irving are forming a new artist to be called "Doug and Terry." 
-- Add this record to the Artists table, using ArtistID 13, the address information of Doug Finney, 
-- no web address, today's entry date, and no lead source. 
-- Don’t hand-code any data for the insert that can be looked up from the Members table.
INSERT INTO Artists (ArtistID, ArtistName, City, Region, Country, EntryDate)
SELECT 13, 'Doug and Terry', City, Region, Country, CurDate()
FROM Members
WHERE FirstName = 'Doug' AND LastName = 'Finney';

-- Q8: Add the appropriate new records to the XrefArtistsMembers table for the artist "Doug and Terry" (see Q7).
-- Doug is the responsible party. Don’t hand-code any data for the insert that can be looked up from the Members2 table.
INSERT INTO XrefArtistsMembers (ArtistID, MemberID, RespParty)
SELECT A.ArtistID, M.MemberID, X.RespParty
FROM Members M
LEFT JOIN XrefArtistsMembers X ON X.MemberID = M.MemberID
INNER JOIN Artists A ON A.ArtistName = 'Doug and Terry'
WHERE M.FirstName = 'Doug' AND M.LastName = 'Finney';

-- Q9: Lyric Music has decided to set up a web page for every artist who doesn't have a web site. 
-- The web address will be "www.lyricmusic.com/" followed by the ArtistID. 
-- Fill this in for every artist record that doesn't already have a web site.

-- Q10: Delete all members who work for the artist 'Sonata' from the Members2 table.

-- Q11: Modify the scheme of the Members2 table as follows: create a new column `Name`; delete the columns `FirstName` and `LastName`.

-- Q12: Delete the table Members2 from the database.

