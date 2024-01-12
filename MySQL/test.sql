-- 1

SELECT dept_code, format(sum(salary),0) 합계, format(avg(ifnull(salary,0)), 0) '평균', count(*) 인원수
FROM employee
GROUP BY dept_code
HAVING avg(ifnull(salary,0))> 2800000;



SELECT emp_name, job_code
FROM employee
where bonus IS NOT NULL
GROUP BY job_code
ORDER BY 2;


SELECT emp_name, job_code, count(bonus)
FROM employee
where bonus is NOT null
GROUP BY job_code
ORDER BY 2;

SELECT emp_name, job_code, count(*) as 사원수
FROM employee
where bonus is NOT null
GROUP BY job_code
ORDER BY job_code;

SELECT emp_name, job_code, count(*) as "사원수"
FROM employee
GROUP BY job_code
HAVING bonus is not null
ORDER BY job_code;


SELECT emp_name, job_code, count(*)
FROM employee
where bonus IS NOT NULL
GROUP BY job_code
ORDER BY job_code;

SELECT emp_name, job_code, count(*) as 사원수


SELECT emp_name, job_code
FROM employee
WHERE bonus IS NOT NULL
ORDER BY job_code;​

SELECT emp_name, job_code
FROM employee
WHERE bonus IS NOT NULL
GROUP BY job_code
ORDER BY job_code;

SELECT emp_name, job_code, count(*) as 사원수 
FROM employee
where bonus IS NOT NULL
GROUP BY job_code
ORDER BY job_code;

SELECT emp_name, job_code
FROM employee
WHERE bonus IS NOT NULL
ORDER BY job_code;​

SELECT *
from employee;

SELECT *
from department;

SELECT emp_name, job_code, count(*) as 사원수
FROM employee
WHERE bonus IS NOT NULL
GROUP BY emp_name
ORDER BY 2;

SELECT emp_name, job_code, count(*) as 사원수
FROM employee
WHERE bonus IS NOT NULL
GROUP BY emp_id
ORDER BY 2; 


-- 2
SELECT emp_id, emp_name, dept_id, dept_title
FROM employee
JOIN department on (dept_code = dept_id)
ORDER BY 3 DESC
LIMIT 3;





