/*

George Leal
Daniel Ng

Lab 10: Triggers
 */

-- Q1: Create a trigger called before_memeber_update. Before any member information is updated, 
-- the trigger should insert a tuple into Members_audit table to keep the member id, first name and 
-- last name of the updated member, and the timestamp of the update.  
-- The following is the definition of the Member_audit table.

CREATE TABLE Members_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    memberID INT(11) NOT NULL,
    firstname VARCHAR(25) NOT NULL,
    lastname VARCHAR(25) NOT NULL,
    changedat DATETIME DEFAULT NULL,
    action VARCHAR(25) DEFAULT 'UPDATE'
);

-- Q2: Create a trigger called before_titles_insert. Before a new title is inserted into the Titles table, 
-- the Titles_Total table is updated to reflect the total number of titles the corresponding artist has. 
-- Note: If the artist is NOT in the Titles table, you should insert a tuple into the Titles_Total table. 
-- Otherwise, just update the Titles_Total table. The following is the definition of the Titles_Total table.
CREATE TABLE Titles_Total(
    id INT AUTO_INCREMENT PRIMARY KEY,
    ArtistID INT(11) NOT NULL,
    total INT NOT NULL,
    action VARCHAR(25) DEFAULT 'INSERT'
);

-- Populate the Titles_Total table with the following queries.
INSERT INTO Titles_Total(ArtistID, total)
SELECT ArtistID, count(*)
FROM Titles
GROUP BY ArtistID;

DELIMITER //

CREATE TRIGGER before_titles_insert
BEFORE INSERT ON Titles
FOR EACH ROW
BEGIN
    -- Check if the artist already exists in Titles_Total
    IF EXISTS (SELECT 1 FROM Titles_Total WHERE ArtistID = NEW.ArtistID) THEN
        -- If the artist exists, update their total count
        UPDATE Titles_Total
        SET total = total + 1
        WHERE ArtistID = NEW.ArtistID;
    ELSE
        -- If the artist does not exist, insert a new record with a total of 1
        INSERT INTO Titles_Total (ArtistID, total)
        VALUES (NEW.ArtistID, 1);
    END IF;
END//

DELIMITER ;


-- Q3: Create a trigger called after_artists_insert. When a new artist is inserted into the Artists table,
--  a welcome message "Welcome NEW_ARTIST_NAME" is generated. If the new artist's web address is null, 
-- the message is followed by "please do not forget to provide your web address!". 
-- The new message is inserted into the table Artists_Welcome together with the ArtistName of the new artist. 
-- The following is the definition of the Artist_Welcome table.
CREATE TABLE Artist_Welcome(
    id INT AUTO_INCREMENT primary key,
    artistName TEXT,
    message TEXT NOT NULL
);