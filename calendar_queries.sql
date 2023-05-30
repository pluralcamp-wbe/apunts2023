use calendar;

select concat('Nom: ',name) as NOM,
concat('Vermell: ',red) as VERMELL,
concat('Verd: ',green) as VERD,
concat('Blau: ',blue) as BLAU
from colors
where red = 0 or green = 0 or blue = 0
order by red,green,blue;

select concat(concat(firstname,' '), lastname) as fullname, 
monthlySalary as sal
from employees
where monthlySalary > 1300;

select *
from employees
where left(firstname,1) = 'M';

select *
from employees
where firstname not like 'M%';

SELECT * FROM calendar.events limit 5;

select code, monthlySalary
from employees
where monthlySalary <> 2500; -- != is also valid

select AVG(monthlySalary)
from employees;

select SUM(monthlySalary)
from employees;

select SUM(monthlySalary)/count(*)
from employees;

select gender, count(*)
from employees
group by gender;

select gender, avg(monthlySalary) as 'Salari mitjà'
from employees
group by gender;

select firstname 
from employees
where payments is not null;

select firstname 
from employees
where length(firstname) > 5;

select * 
from employees
where firstname like '%m%' and
monthlySalary > 2300;

select *
from colors
where red between 1 and 50;

select if(green between 200 and 255,'verdosa','altres') as tonalitat
from colors
order by green desc;

select firstname, lastname, monthlySalary
from employees
where monthlySalary not in (2300,2900);

select max(monthlySalary)
from employees;

use minishop;

select * from customers;
select * from orders;

/*
INNER JOIN:
An INNER JOIN returns only the rows that match between the two tables based on the specified condition. In other words, it only returns rows where there is a matching customer_id value in both the customers and orders tables.
*/

SELECT customers.name, orders.order_date
FROM customers
INNER JOIN orders
ON customers.id = orders.customer_id;

/*
OUTER JOIN:
An OUTER JOIN returns all the rows from one table and matching rows from the other table based on the specified condition. If there is no matching row in the other table, then NULL values are returned. Here's an example SQL statement for a LEFT OUTER JOIN:
*/

SELECT customers.name, orders.order_date
FROM customers
LEFT OUTER JOIN orders
ON customers.id = orders.customer_id;

update orders set customer_id = null where customer_id = 4;

-- repetir la query anterior

-- ara amb RIGHT OUTER JOIN
SELECT customers.name, orders.order_date
FROM customers
RIGHT OUTER JOIN orders
ON customers.id = orders.customer_id;

-- natural join?
SELECT customers.name, orders.order_date
FROM customers
NATURAL JOIN orders;

-- GROUP BY
SELECT customer_id, COUNT(*) AS order_count
FROM orders
GROUP BY customer_id;


-- Functions and stored procedures

-- How can I return the result of a select in a function in MySQL?
-- A MySQL function can only return a single value. You can use a stored procedure, instead:
DROP PROCEDURE getOrderCount;
DELIMITER $$
CREATE PROCEDURE `getOrderCount`()
BEGIN
    SELECT customer_id, COUNT(*)
    FROM `minishop`.orders
    GROUP BY customer_id;
END $$

DELIMITER ;

call getOrderCount;

-- Subquery:
-- Is it possible to call stored procs in MySQL subqueries.
-- No.

/* This is erroneous:
SELECT AVG(order_count) AS avg_order_count
FROM (
	call getOrderCount
) as subquery;
*/

SELECT AVG(order_count) AS avg_order_count
FROM (
    SELECT customer_id, COUNT(*) AS order_count
    FROM orders
    GROUP BY customer_id
) as subquery;

-- MySQL function can return only 1 value. Example:

/*
Quan creem una funció podem obtenir el següent error:
-- This function has none of DETERMINISTIC, NO SQL, or READS SQL DATA in its declaration

> If binary logging is enabled:
SET GLOBAL log_bin_trust_function_creators = 1;

> Otherwise, add DETERMINISTIC / NOT DETERMINISTIC / READS SQL DATA / etc
after RETURN and before BEGIN in the function declaration.

https://stackoverflow.com/questions/26015160/deterministic-no-sql-or-reads-sql-data-in-its-declaration-and-binary-logging-i 
 */

SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS calculateAvgOrderCount;
DELIMITER $$
CREATE FUNCTION calculateAvgOrderCount()
RETURNS DECIMAL(10, 2)

BEGIN
    DECLARE avg_order_count DECIMAL(10, 2);

    SELECT AVG(order_count) INTO avg_order_count
    FROM (
        SELECT customer_id, COUNT(*) AS order_count
        FROM orders
        GROUP BY customer_id
    ) subquery;
    RETURN avg_order_count;
END$$
DELIMITER ;

select calculateAvgOrderCount();

-- En una variable de sessió definida per l'usuari --> Només pot contenir un únic valor (escalar):

SET @avg_order_count := (
	SELECT AVG(order_count) AS avg_order_count
	FROM (
		SELECT customer_id, COUNT(*) as order_count
		FROM `minishop`.orders
		GROUP BY customer_id
	) as subquery
);

select @avg_order_count;

-- HAVING
/*
Let's say we want to find customers who have placed more than 1 order. We can use the HAVING clause along with the COUNT function to filter the results:

In this example, we're selecting the customer ID, customer name, and the count of orders for each customer. We use a LEFT JOIN to include all customers, even those who have not placed any orders.

The GROUP BY clause groups the results by the customer ID and customer name.

The HAVING clause filters the results and includes only those customers who have placed more than 2 orders, as specified by the condition COUNT(o.customer_id) > 1.
 
 */

SELECT c.id, c.name, COUNT(o.customer_id) AS order_count
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name
HAVING COUNT(o.customer_id) > 1;

-- INTO
/*
DECLARE @customer_id INT;
DECLARE @customer_name VARCHAR(50);
DECLARE @order_count INT;

SELECT c.id, c.name, COUNT(o.customer_id) AS order_count
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id
GROUP BY c.id, c.name
ORDER BY COUNT(o.customer_id) DESC
LIMIT 1
INTO @customer_id, @customer_name, @order_count;
*/



