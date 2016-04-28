-------------------------LAB 5 SQL Queries Using Joins.------------------------

-----------------------------Reynaldo Alvarez----------------------------------

--------------------------------02/24/2016-------------------------------------



--1. Show the cities of agents booking an order for a customer whose id is ‘c002’. Use joins; no subqueries.
Select agents.city
From agents
Inner Join customers
On customers.city=agents.city
Where cid='c002';




--2. Show the ids of products ordered through any agent who makes at least one order for a customer in Dallas, sorted by pid from highest to lowest. Use joins; no subqueries.
Select products.pid
From products
Inner Join agents
On products.city = agents.city
Where agents.city In ('Dallas')
Order By pid DESC;



--3. Show the names of customers who have never placed an order. Use a subquery.
Select name
From customers
Where cid NOT IN (Select cid
		  From orders);	


--4. Show the names of customers who have never placed an order. Use an outer join.
Select customers.name
From customers
Left Outer Join orders
On customers.cid = orders.cid
Where orders.cid Is Null;




--5. Show the names of customers who placed at least one order through an agent in their own city, along with those agent(s’) names.
-- you missed a semicolon on this one!
Select customers.name, agents.name
From customers
Inner Join agents
On customers.city = agents.city;




--6. Show the names of customers and agents living in the same city, along with the name of the shared city, regardless of whether or not the customer has ever placed an order with that agent.
Select customers.name, customers.city, agents.name, agents.city
From customers
Inner Join agents
On customers.city = agents.city;




--7. Show the name and city of customers who live in the city that makes the fewest different kinds of products. (Hint: Use count and group by on the Products table.)
Select customers.name, customers.city, COUNT(products.city) AS numberOfProducts
From customers
Inner Join products
On products.city = customers.city
Group By customers.name, customers.city, Least(products.city);
