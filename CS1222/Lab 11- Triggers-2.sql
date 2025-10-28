/*

George Leal
Daniel Ng

Lab 11: Triggers-2

*/

-- Q1: Create a before update trigger on the SalesPeople table called before_SalesPeople_update.
-- If you update the value in the base column to a new value that is 2 times greater than the current value, 
-- the trigger raises an error message "The new base value XXX cannot be 2 times greater than the current value XXX".
-- If the new value is less than half of the current value, the error message is 
-- "The new base value XXX cannot be less than half of the current value XXX".

-- Q2: Creates an AFTER UPDATE trigger called after_Tracks_update that is automatically invoked after 
-- an update event occurs for each row in the Tracks table. If you update the value in the LengthSeconds 
-- column to a new value, the trigger inserts a new row to log the changes in the LengthChanges table.

DELIMITER $$
CREATE TRIGGER after_Tracks_update
AFTER UPDATE ON Tracks
FOR EACH ROW
BEGIN
    IF OLD.LengthSeconds != NEW.LengthSeconds THEN
        INSERT INTO LengthChanges (titleID, trackNum, beforeLength, afterLength, changedAt)
        VALUES (NEW.titleID, NEW.trackNum, OLD.LengthSeconds, NEW.LengthSeconds, NOW());
    END IF;
END $$
DELIMITER ;

-- The following statement creates a table that stores the changes in the LengthSeconds column from the Tracks table.

CREATE TABLE LengthChanges (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titleID INT(11),
    trackNum SMALLINT(6),
    beforeLength SMALLINT(6),
    afterLength SMALLINT(6),
    changedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);