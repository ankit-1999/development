-- Write separate queries using a join, a subquery, a CTE, and then an EXISTS to list all AdventureWorks customers who have not placed 
-- an order.

-- Using join

SELECT s.CustomerID
FROM   Sales.Customer AS s LEFT OUTER JOIN
             Sales.SalesOrderHeader AS h ON s.CustomerID = h.CustomerID
WHERE (h.AccountNumber IS NULL)

-- Using Subquery

SELECT CustomerID
FROM   Sales.Customer
WHERE (CustomerID NOT IN
                 (SELECT CustomerID
                 FROM    Sales.SalesOrderHeader))

-- Using CTE

WITH Acount_Number(AccountNumber, customerID)
AS (SELECT AccountNumber, CustomerID FROM   Sales.SalesOrderHeader)
    SELECT s.CustomerID
   FROM    Sales.Customer AS s LEFT OUTER JOIN
                Acount_Number AS h ON s.CustomerID = h.customerID
   WHERE (h.AccountNumber IS NULL)


-- Using Exists
  
SELECT CustomerID
FROM   Sales.Customer AS c
WHERE (NOT EXISTS
                 (SELECT CustomerID
                 FROM    Sales.SalesOrderHeader AS h
                 WHERE (c.CustomerID = h.CustomerID)))


