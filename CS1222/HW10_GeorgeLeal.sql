/*
George Leal
HW 10: Triggers
*/

-- Q1: Create a trigger called before_titles_insert. Before a new title is inserted into the Titles table, 
-- the Publisher_Total table is updated to reflect the total number of titles the publisher has published. 
-- Note: If the publisher is NOT in the Titles table, you should insert a tuple into the Publisher_Total table. 
-- Otherwise, just update the Publisher_Total table. The following is the definition of the Publisher_Total table.
CREATE TABLE Publisher_Total (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pub_id char(3) NOT NULL,
    total INT NOT NULL,
    action VARCHAR(25) DEFAULT 'INSERT'
);

-- Populate the Publisher_Total table with the following queries.
INSERT INTO Publisher_Total (pub_id, total)
SELECT pub_id, count(*)
FROM Titles
GROUP BY pub_id;

DELIMITER $$

CREATE TRIGGER before_titles_insert
BEFORE INSERT ON Titles
FOR EACH ROW
BEGIN
    IF EXISTS (	SELECT * 
				FROM Publisher_Total 
                WHERE pub_id = NEW.pub_id) 
				THEN
				UPDATE Publisher_Total
				SET total = total + 1, action = 'INSERT'
				WHERE pub_id = NEW.pub_id;
    ELSE
        INSERT INTO Publisher_Total (pub_id, total, action)
        VALUES (NEW.pub_id, 1, 'INSERT');
    END IF;
    
END$$

DELIMITER ;

-- Q2: Create a trigger called after_title_author_insert. 
-- When a new tuple is inserted into Title_Authors table, a message and au_id are inserted into the table Author_Message. 
-- If the royalty share is smaller than 0.5, the message is the id of the author followed by "your royalty share is low". 
-- Otherwise, the message is the id of the author followed by "your royalty share is high". 
-- The following is the definition of the Author_Message table.
CREATE TABLE Author_Message(
    id INT AUTO_INCREMENT primary key,
    au_id char(3) NOT NULL,
    message TEXT NOT NULL
);

DELIMITER $$

CREATE TRIGGER after_title_author_insert
AFTER INSERT ON Title_Authors
FOR EACH ROW
BEGIN
    IF NEW.royalty_share < 0.5 THEN
        INSERT INTO Author_Message
        SET au_id = NEW.au_id,
            message = CONCAT(NEW.au_id, ' your royalty share is low');
    ELSE
        INSERT INTO Author_Message
        SET au_id = NEW.au_id,
            message = CONCAT(NEW.au_id, ' your royalty share is high');
    END IF;
END$$

DELIMITER ;
