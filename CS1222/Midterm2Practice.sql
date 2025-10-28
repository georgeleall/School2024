/*
Practice Midterm 2 Problems
*/

-- Where customer lives in CA
SELECT * FROM Customers
WHERE RIGHT(address, 2) = 'CA';

-- Report any order id which has not been shipped yet.
SELECT oid
FROM Orders
where sdate IS NULL;

-- Report each year of order and the number of orders per year.
-- Please put the total number of orders at the Last Line
SELECT YEAR(odate), COUNT(oid)
FROM Orders
GROUP BY YEAR(odate)
UNION 
SELECT 'total', COUNT(*)
FROM Orders;

-- Report each customer's full name (in one column, "last name, firstname" format),
-- and the number of orders made (if any)
SELECT CONCAT_WS(', ', C.lname,C.fname) AS NAME, COUNT(O.oid) AS Orders
FROM Customers C
LEFT JOIN Orders O ON O.cid=C.cid
GROUP BY CONCAT_WS(', ', C.lname,C.fname);

-- Report the order id and product id
-- with largest quantity ordered for any CPU product.
SELECT oid, pid
FROM Order_details
WHERE pid LIKE 'CPU%' AND
quantity =(SELECT MAX(quantity)
				FROM Order_details
                WHERE LEFT(pid,3) = 'CPU');
                
-- Report the customer id who ordered the cheapest product
SELECT O.cid
FROM Orders O
INNER JOIN Order_details OD ON O.oid = OD.oid
INNER JOIN Products P ON OD.pid = P.pid
WHERE P.price = (SELECT MIN(price)
				FROM Products);

-- Report the product id which is out of stock.
SELECT pid
FROM Products
WHERE quantity = 0;

-- The product HDD001 now has 5 stocks. Change the quantity properly.
UPDATE Products
SET quantity = 5
WHERE pid = 'HDD001';

-- The customer named "Hull Klee" wants to add three
-- "HDD001" to the order the person already placed.
INSERT INTO Order_details
SELECT O.oid, 'HDD001', 3
FROM Orders O
INNER JOIN Customers C ON O.cid=C.cid
WHERE C.fname = 'Hull' AND C.lname = 'Klee'

