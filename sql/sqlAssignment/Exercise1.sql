-- Q.1  Display the number of records in the [SalesPerson] table. (Schema(s) involved: Sales)

SELECT COUNT(*) AS [Number of records]
FROM   Sales.SalesPerson;

-- Q.2 Select both the FirstName and LastName of records from the Person table where the FirstName begins with the letter ‘B’. (Schema(s) involved: Person)

SELECT FirstName, LastName
FROM   Person.Person
WHERE (FirstName LIKE 'B%')

-- Q.3 Select a list of FirstName and LastName for employees where Title is one of Design Engineer, Tool Designer or Marketing Assistant. (Schema(s) involved: HumanResources, Person)

SELECT p.FirstName, p.LastName
FROM   Person.Person AS p INNER JOIN
             HumanResources.Employee AS h ON h.BusinessEntityID = p.BusinessEntityID
WHERE (h.JobTitle = 'Design Engineer') OR
             (h.JobTitle = 'Tool Designer') OR
             (h.JobTitle = 'Marketing Assistant');

--Q.4 Display the Name and Color of the Product with the maximum weight. (Schema(s) involved: Production)

SELECT Name, Color
FROM   Production.Product
WHERE (Weight =
                 (SELECT MAX(Weight)
                 FROM    Production.Product));

-- Q.5 Display Description and MaxQty fields from the SpecialOffer table. Some of the MaxQty values are NULL, in this case display the value 0.00 instead.--    (Schema(s) involved: Sales)SELECT Description, CASE WHEN MaxQty IS NULL THEN 0.00 ELSE MaxQty END AS Expr1
FROM   Sales.SpecialOffer;

-- Q.6 Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005 
--     i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined as 
--     'Average exchange rate for the day.' (Schema(s) involved: Sales)

SELECT AVG(AverageRate) AS 'Average exchange rate for the day'
FROM   Sales.CurrencyRate
WHERE (FromCurrencyCode = 'usd') AND (ToCurrencyCode = 'gbp') AND (YEAR(CurrencyRateDate) = 2005);

-- Q.7  Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’. Display an 
--      additional column with sequential numbers for each row returned beginning at integer 1. (Schema(s) involved: Person)
SELECT FirstName, LastName, ROW_NUMBER() over ( order by lastname) as 'Sequential number'
FROM   Person.Person
WHERE (FirstName LIKE '%ss%');

-- Q.8  Sales people receive various commission rates that belong to 1 of 4 bands. (Schema(s) involved: Sales)

SELECT BusinessEntityID, 
CASE 
    WHEN CommissionPct = 0.00 THEN 'Band 0' 
	WHEN CommissionPct <= 0.01 THEN 'Band 1' 
	WHEN CommissionPct <= 0.015 THEN 'Band 2' 
	ELSE 'Band 3' 
	END AS 'Commission Band'
FROM   Sales.SalesPerson;

-- Q.9 Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez. Hint: use 
--     [uspGetEmployeeManagers] (Schema(s) involved: [Person], [HumanResources]) 

DECLARE @id INT
SELECT 
      @id = BusinessEntityID 
FROM 
     Person.Person
WHERE 
     FirstName = 'Ruth' 
	 AND LastName = 'Ellerbrock' 
	 AND PersonType = 'EM'
EXEC 
    dbo.uspGetEmployeeManagers @id;




-- Q.10 Display the ProductId of the product with the largest stock level. Hint: Use the Scalar-valued function [dbo]. [UfnGetStock]. 
--      (Schema(s) involved: Production)

SELECT ProductID AS 'Product ID'
FROM Production.ProductInventory
WHERE Quantity = (SELECT MAX(Quantity)
						  FROM Production.ProductInventory);

