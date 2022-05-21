--Q.3 Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with 
--    AdventureWorks.

select s.accountnumber, s.orderdate
from (
      select so.* ,
	  totalPeraccount =sum(ss.linetotal) over (partition by so.accountnumber),
	  rn =ROW_NUMBER() over (partition by so.accountnumber order by so.orderdate desc)
	  from sales.SalesOrderHeader so
	  join Sales.SalesOrderDetail ss on so.SalesOrderID=ss.SalesOrderID
	  ) s
where s.totalPeraccount>70000
      and s.rn<=5;