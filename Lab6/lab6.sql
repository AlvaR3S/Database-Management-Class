--Reynaldo Alvarez
--CMPT 308  Rivas
 
--Lab 6: Very Interesting SQL Queries. Thursday, February 25, 2016
--Due: Wednesday, March 2, 2016.
 
--1.
--Display the name and city of customers who live in any city that makes the most different kinds of
--products. (There are two cities that make the most different products. Return the name and city of
--customers from either one of those.)
 
Select customers.name, customers.city
From customers
Inner Join products
On (customers.city) = (products.city)
Group By customers.name, customers.city
Order By COUNT(products.city) DESC Limit 1;
 
 
--2.
--Display the names of products whose priceUSD is strictly above the average priceUSD, in reverse-
--alphabetical order.
 
Select name
From products
Where priceUSD > (Select AVG(priceUSD) From products)
Order By name DESC;
 
--3.
--Display the customer name, pid ordered, and the total for all orders, sorted by total from high to low.
 
Select customers.name, products.pid, SUM(orders.dollars) as totalOfOrders
From customers
Left Join orders
On  (customers.cid) = (orders.cid)
Inner Join products
On (orders.pid) = (products.pid)
Group By customers.name, products.pid
Order By SUM(orders.dollars) DESC;
 
--4.
--Display all customer names (in alphabetical order) and their total ordered, and nothing more. Use
--coalesce to avoid showing NULLs.
 
Select customers.name, SUM(orders.dollars)
From customers
Left Outer Join orders
On (customers.cid) = (orders.cid)
Group By customers.name, orders.dollars
Order By customers.name ASC;
 
--5.
--Display the names of all customers who bought products from agents based in Tokyo along with the
--names of the products they ordered, and the names of the agents who sold it to them.
 
Select customers.name, products.name, agents.name
From orders
Inner Join products
On (orders.pid) = (orders.pid)
Inner Join customers
On (orders.cid) = (customers.cid)
Inner Join agents
On (orders.aid) = (agents.aid) 
Where agents.name = (Select agents.name
		     From agents
		     Where agents.city='Tokyo');
 
--6.
--Write a query to check the accuracy of the dollars column in the Orders table. This means calcu-
--lating Orders.totalUSD from data in other tables and comparing those values to the values in
--Orders.totalUSD. Display all rows in Orders where Orders.totalUSD is incorrect, if any.
 
Select *
From (Select o.*, o.qty*p.priceusd*(1-(discount/100)) as truedollars
      from orders o
      inner join products p on o.pid = p.pid
      inner join customers c on o.cid = c.cid) as tmptable
Where dollars != truedollars;
 
--7.
--What is the difference between a LEFT OUTER JOIN and a RIGHT OUTER JOIN? Give example
--queries in SQL to demonstrate. (Feel free to use the CAP2 database to make your points here.) 
 
--My answer:
		-- A Left Outer Join connects all the information on a table that the comparing information does not contain. 
		-- A Right Outer Join is the same, however it is the table that is being Joined to.
		-- For example If I use: 
				--	 Select customers.cid, orders.pid
				--       From customers 
				--       Right Outer Join orders
				--	 On (customers.cid = orders.cid)
				
		-- This will display an example that takes all of the customers in the orders table and display all of the pid orders.
		--If I use Left Outer Join on this exact example I will get a different result.
 
				--	 Select customers.cid, orders.pid
				--       From customers 
				--       Right Outer Join orders
				--	 On (customers.cid = orders.cid)
 
		-- This output will include all of the customers cid even if there is not a match with a pid in the orders table.
		-- This will include the c005 cid at the end of the cid coloumn and will be matched with a null pid value.
					 
				
