SELECT * FROM kh.employee;

SELECT * FROM employee;
SELECT * FROM employee_copy;

CREATE TABLE employee_copy
SELECT * FROM employee;

INSERT INTO employee_copy(emp_id, emp_name, emp_no)
VALUES("900", "테스트", "000000-0000000");

UPDATE employee_copy SET emp_name = "테스트 02" WHERE emp_id = 900;

SET AUTOCOMMIT = 1;

DELETE FROM employee_copy WHERE emp_id = 900;