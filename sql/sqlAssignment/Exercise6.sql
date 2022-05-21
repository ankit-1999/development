--Q.6 Write a trigger for the Product table to ensure the list price can never be raised more than 15 Percent in a single change. Modify the 
--    above trigger to execute its check code only if the ListPrice column is updated (Use AdventureWorks Database).

CREATE TRIGGER PRODUCTION.tr_ListPrice_Update
ON Production.Product
AFTER UPDATE
AS
BEGIN
	IF UPDATE(ListPrice)
		BEGIN
			DECLARE @oldval int
			DECLARE @newval int
			DECLARE @PID int

			SELECT @PID=ProductID 
			FROM inserted;

			SELECT @oldval = ListPrice 
			FROM deleted 
			WHERE ProductID = @PID;

			SELECT @newval = ListPrice 
			FROM inserted 
			WHERE ProductID = @PID;
			
			IF @newval - @oldval > 0.15*@oldval
			BEGIN
				PRINT('Can not be Modified')
				ROLLBACK
			END
		END
END



UPDATE Production.Product
SET ListPrice = 0
WHERE ProductID = 4
