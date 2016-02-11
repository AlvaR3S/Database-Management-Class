SELECT ordno,dollars
FROM Orders;

SELECT name, city
FROM Agents
WHERE name='Smith';

SELECT pid, name, priceUSD 
FROM Products
WHERE quantity > 208000;

SELECT name, city
FROM Customers
WHERE city='Dallas';

SELECT name
FROM Agents
WHERE city !='New York' and city!='Tokyo';

SELECT *
FROM Products
WHERE (city!='Dallas' and city!='Duluth')
AND priceUSD >= 1.00

SELECT *
FROM Orders
WHERE (mon='jan' or mon='mar');

SELECT *
FROM Orders
WHERE (mon='feb' and dollars < 500);

SELECT *
FROM Orders
WHERE cid='c005';