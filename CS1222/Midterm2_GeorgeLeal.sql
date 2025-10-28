/*

Midterm 2
George Leal

*/

-- Q1: Report the names of all customers who have placed an order, the order ID, and whether
-- the order has been shipped or not.
SELECT CONCAT_WS(' ', C.fname, C.lname) AS 'Customer Name', O.oid AS 'Order ID',
				CASE
                WHEN O.sdate IS NOT NULL THEN 'Yes'
                ELSE 'No'
                END AS 'Shipped'
FROM Customers C
LEFT JOIN Orders O ON C.cid = O.cid
WHERE O.oid IS NOT NULL;

-- Q2: Find thee first name and the last name of all customers who have NOT placed any orders.
SELECT C.fname, C.lname
FROM Customers C
LEFT JOIN Orders O ON C.cid = O.cid
WHERE O.cid IS NULL;

-- Q3: For each order id, calculate the total of the order. The total of an order is the sum
-- of the prices of all the products (price * quantity) in that order.
-- Sort the results by the total of the order.
SELECT O.oid, SUM(P.price * O.quantity) AS total
FROM Order_details O
INNER JOIN Products P ON O.pid = P.pid
GROUP BY O.oid
ORDER BY SUM(P.price * O.quantity);

-- Q4: Identify the customer name(s) who ordered out of stock product(s) and the corresponding
-- product id to let them know the product status.
SELECT C.fname, C.lname, P.pid
FROM Customers C
LEFT JOIN Orders O ON C.cid = O.cid
LEFT JOIN Order_details OD ON O.oid = OD.oid
LEFT JOIN Products P ON P.pid = OD.pid
WHERE P.quantity = 0;

-- Q5: Report the name of the customer who bought the most expensive product, the product name(description),
-- and the price.
SELECT CONCAT_WS(' ', C.fname, C.lname) AS 'Customer Name', P.description, P.price
FROM Customers C
INNER JOIN Orders O ON C.cid = O.cid
INNER JOIN Order_details OD ON O.oid = OD.oid
INNER JOIN Products P ON OD.pid = P.pid
WHERE P.price = (SELECT MAX(price)
				FROM Products);

-- Q6: Report the number of products that are below $50, between $50 and $100 (inclusive),
-- between $101 and $150 (inclusive), and above $150.
SELECT 
    COUNT(pid) AS 'Product Count',
    CASE
        WHEN price < 50 THEN 'Below $50'
        WHEN price >= 50 AND price <= 100 THEN 'Between $50 and $100'
        WHEN price >= 101 AND price <= 150 THEN 'Between $101 and $150'
        ELSE 'Above $150'
    END AS 'Price Range'
FROM Products
GROUP BY 
    CASE
        WHEN price < 50 THEN 'Below $50'
        WHEN price >= 50 AND price <= 100 THEN 'Between $50 and $100'
        WHEN price >= 101 AND price <= 150 THEN 'Between $101 and $150'
        ELSE 'Above $150'
    END;
    
-- Q7: For each product, display the product id, the order id of which contins the product, and the quantity,
-- followed on th next line by the total quantity.
SELECT pid, oid, quantity
FROM Order_details
UNION ALL
SELECT pid, 'total', SUM(quantity) AS quantity
FROM Order_details
GROUP BY pid
ORDER BY pid, oid;

-- Q8: The order placed by the customer "Heydemark Wendy" was just shipped.
-- Change the shipping date of the related order to today. --CID 1002 --OID 2011
UPDATE Orders O
JOIN Customers C ON O.cid = C.cid
SET O.shipped_date = CURDATE()
WHERE C.fname = 'Wendy' AND C.lname = 'Heydemark';

-- Q9: The customer named "Furniture Paddy wants to add two "MSE001" (products) to
-- the order he placed. Insert a new record into the Order_details table.
INSERT INTO Order_details (oid, pid, quantity)
SELECT O.oid, 'MSE001', 2
FROM Orders O
JOIN Customers C ON O.cid = C.cid
WHERE C.fname = 'Furniture' AND C.lname = 'Paddy';

-- Q10: For each order, report the order ID, the product ID, the price of the product,
-- the average price for all products in this order, and the difference value between
-- the price and the average price.
SELECT OD.oid AS 'Order ID', OD.pid AS 'Product ID', P.price AS 'Product Price',
	ROUND((SELECT AVG(P2.price) 
           FROM Order_details OD2
           INNER JOIN Products P2 ON OD2.pid = P2.pid
           WHERE OD2.oid = OD.oid), 2) AS 'Average Price',
           
    ROUND(P.price - (SELECT AVG(P2.price) 
                     FROM Order_details OD2
                     INNER JOIN Products P2 ON OD2.pid = P2.pid
                     WHERE OD2.oid = OD.oid), 2) AS 'Price Difference'
FROM 
    Order_details OD
INNER JOIN 
    Products P ON OD.pid = P.pid;
