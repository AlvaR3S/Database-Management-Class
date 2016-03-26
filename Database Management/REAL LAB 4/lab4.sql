--1. Get the cities of agents bookingan order for a customer whose cid is 'c002'.
SELECT city 
FROM agents
WHERE aid in (Select aid
              From orders
              Where cid='c002');

--2. Get the id of products ordered through any agent who takes at least one order from a customer in Dallas, sorted by pid from highest to lowest. (This is not the same as asking for ids of products ordered by customers in Dallas.)
Select Distinct pid
From orders
Where aid in (Select aid
              From orders
              Where cid in (Select cid
                            From customers
                            Where city='Dallas'))
                            Order By pid Desc;
                            
--3. Get the ids and names of customers who did not place an order through agent a01.
Select cid, name
From customers
Where cid not in (Select cid
              From orders
              Where aid='a01');         

--4. Get the ids of customers who ordered both product p01 and p07.
Select cid
From orders
Where pid='p01' intersect (Select cid
                           From orders
                           Where pid='p07');
                           
--5. Get the ids of products not ordered by any customers who placed any order through agent a07 in pid order from highest to lowest.
Select Distinct pid
From orders
Where pid not in (Select pid
                  From agents
                  Where aid ='a07')
                  Order By pid Desc;

--6. Get the name, discounts, and city for all customers who place orders through agents in London or New York.
Select name, discount, city
From customers
Where cid in (Select cid
             From orders
             Where aid in (Select aid
                           From agents
                           Where city='London'
                           Or city='New York'));


--7. Get all customers who have the same discount as that of any customers in Dallas or London.
Select *
From customers
Where discount in (Select distinct discount
                   From customers
                   Where city in ('Dallas','London'));

--8. Tell me about check constraints: 
--What are they? 
 --What are they good for? 
 --What is the advantage of putting that sort of thing inside the database? 
--Make up some examples of good uses of check constraints and some examples of bad uses check constraints. 
--Explain the differences in your examples and argue your case.   


-- Constraints are rules that specify how a table acts. They are great for
-- setting restrictive definitions of a table when it is made. When a
-- constraint is placed on a table it allows for others to clearly identify
-- what they cannot and can input into the table. This also assists with
-- information that is not supposed to be input into the table. By trying to
-- input a value that does not hold up to this Constraint it will through an
-- error message and explain to the user what went wrong. A good example of a
-- constraint is a NOT NULL value when creating a value that states it is not
-- null. A bad example of a constraint is using the PRIMARY KEY incorrectly.
-- For example, if a person creates a table and uses a contraint with PRIMARY
-- KEY and inputs the wrong attribute it can lead to multiple mistakes within
-- the table. The difference between both examples is in the way they use them.
-- When using constraints incorrectly this can lead to error. Never use
-- constraints when they do not need to be used. Constraints can help define
-- and specifythe created attributes.


                                    
