use calendar;
DELIMITER $$
CREATE PROCEDURE `searchEmployeesByRange` (
	IN offset INT,
    IN count INT
)
BEGIN
	SELECT id, code, firstname, lastname, gender, birthDate, hireDate,
    monthlySalary, payments FROM employees
    LIMIT offset,count;
END$$
DELIMITER ;

