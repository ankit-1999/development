--Q.5 Write a Procedure supplying name information from the Person.Person table and accepting a filter for the first name. Alter the above 
--    Store Procedure to supply Default Values if user does not enter any value. ( Use AdventureWorks)


CREATE PROCEDURE dbo.usp_GetNameDetails @FirstNameFilter nvarchar(20)
AS
SELECT 
          FirstName,
          MiddleName,
          LastName
FROM Person.Person 
WHERE FirstName LIKE '%' + @FirstNameFilter + '%'; 

EXEC dbo.usp_GetNameDetails 'ss';

--DROP PROCEDURE dbo.uspGetNameDetails

ALTER PROCEDURE dbo.usp_GetNameDetails @FirstNameFilter nvarchar(20) = 'Ruth'
AS
SELECT    FirstName, 
          MiddleName, 
          LastName
FROM Person.Person 
WHERE FirstName LIKE '%' + @FirstNameFilter + '%'; 

EXEC dbo.usp_GetNameDetails 'b'



