/*
	함수 : 전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환
    
    - 단일행 함수 : N 개의 값을 읽어서 N 개의 결과값을 리턴 (매 행마다 함수 실행 결과 반환)
    - 그룹 함수 : N 개의 값을 읽어서 1개의 결과값을 리턴 (그룹별로 함수 실행 결과 반환) 
    
    >> SELECT 절에 단일행 함수와 그룹 함수는 함께 사용하지 못함! 
       왜? 결과 행의 개수가 다르기 때문에!
	
    >> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
*/

-- 단일행 함수

/*
	문자 처리 함수
    
    LENGTH(컬럼|'문자열') : 해당 문자열값의 BYTE 길이 수 반환 
    - 한글 한 글자 -> 3BYTE
    - 영문자, 숫자, 특수문자 한 글자 -> 1BYTE 
    
    CHAR_LENGTH(컬럼|'문자열') : 해당 문자열값의 글자 수 반환 
*/
SELECT 
	length('데이터베이스'), char_length('데이터베이스'),
    length('database'), char_length('database');
-- FROM DUAL; -- 가상 테이블 : 데이터베이스 자체에서 제공하는 테이블 (MySQL 생략 가능!)

-- 사원명(emp_name), 사원명의 글자수, 이메일(email), 이메일의 글자수 조회
SELECT emp_name, char_length(emp_name), email, char_length(email)
FROM employee;

/*
	INSTR(컬럼|'문자열', '찾으려는 문자열')
    - 특정 문자열에서 찾고자 하는 문자열의 위치 반환 
    - 없으면 0 반환 
*/
SELECT instr('AABAACAABBAA', 'B'); -- 3
SELECT instr('AABAACAABBAA', 'D'); -- 0

-- 's'가 포함되어 있는 이메일 중 이메일, 이메일의 @ 위치 조회
SELECT email, instr(email, '@')
FROM employee
WHERE email LIKE '%s%';

/*
	LPAD|RPAD(컬럼|'문자열', 최종적으로 반환할 문자의 길이, '덧붙이고자 하는 문자')
    - 문자열에 덧붙이고자 하는 문자를 왼쪽 또는 오른쪽에 덧붙여서
      최종적으로 반환할 문자의 길이만큼 문자열 반환 
*/
SELECT lpad('HELLO', 10,'A');
SELECT rpad('HELLO', 10, '*');

/*
	TRIM(컬럼|'문자열') 
    TRIM([LEADING|TRAILING|BOTH] 제거하고자하는문자들 FROM 컬럼|'문자열')
    - 문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환 
*/
SELECT trim('       K H     '); -- 기본적으로 양쪽에 있는 공백 제거 
SELECT trim(BOTH ' ' FROM '       K H     ');

SELECT trim(LEADING 'Z' FROM 'ZZZKHZZZ'); -- KHZZZ
SELECT trim(TRAILING 'Z' FROM 'ZZZKHZZZ'); -- ZZZKH
SELECT trim(BOTH 'Z' FROM 'ZZZKHZZZ'); -- KH

-- LTRIM : 앞쪽 공백만 제거 
SELECT trim(LEADING ' ' FROM '       K H     ');
SELECT ltrim('       K H     ');

-- RTRIM : 뒤쪽 공백만 제거 
SELECT trim(TRAILING ' ' FROM '       K H     ');
SELECT rtrim('       K H     ');

/*
	SUBSTR|SUBSTRING(컬럼|'문자열', 시작 위치 값, 추출할 문자 개수)
    - 문자열에서 특정 문자열을 추출해서 반환 
*/
SELECT substr('PROGRAMMING', 5, 2); -- RA
SELECT substring('PROGRAMMING', 1, 6); -- PROGRA
SELECT substr('PROGRAMMING', -8, 3); -- GRA 

SELECT * FROM employee;

-- 여자 사원들의 이름(emp_name), 주민등록번호(emp_no) 조회
SELECT emp_name, emp_no
FROM employee
WHERE substr(emp_no, instr(emp_no, '-') + 1, 1) = 2;

-- 남자 사원들의 이름, 주민등록번호 조회 
SELECT emp_name, emp_no
FROM employee
WHERE substr(emp_no, 8, 1) = 1;

/*
	LOWER|UPPER(컬럼|'문자열')
    - LOWER : 다 소문자로 변경한 문자열 반환 
    - UPPER : 다 대문자로 변경한 문자열 반환 
*/
SELECT lower('Welcome To My World!'),
	   upper('Welcome To My World!');
       
/*
	REPLACE(컬럼|'문자열', '바꾸고 싶은 문자열', '바꿀 문자열')
    - 특정 문자열로 변경하여 반환 
*/
SELECT replace('서울특별시 강남구 역삼동', '역삼동', '삼성동');

/*
	CONCAT(컬럼|'문자열', 컬럼|'문자열', ...)
    - 문자열을 하나로 합친 후 결과 반환 
*/
SELECT concat('가나다라', 'ABCD'); -- 가나다라ABCD
SELECT concat('가나다라', 'ABCD', '1234'); -- 가나다라ABCD1234


-- 실습문제 ---------------------------------------------
-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름, 변경 전 이메일, 변경 후 이메일 조회
SELECT emp_name, email "변경 전", replace(email, 'kh.or.kr', 'gmail.com') "변경 후"
FROM employee; 

-- 2. 사원명과 주민등록번호(000000-0******)으로 조회 
-- replace, concat, rpad, substr
SELECT 
	emp_name, 
    replace(emp_no, substr(emp_no, -6, 6), '******')
FROM employee;

-- rpad(substr(emp_no, 1, 8), 14, '*')
SELECT 
	emp_name,
    rpad(substr(emp_no, 1, instr(emp_no, '-') + 1), char_length(emp_no), '*')
FROM employee;

-- concat
SELECT 
	emp_name,
    concat(substr(emp_no, 1, 8), '******')
FROM employee;


-- 3. 사원명, 이메일, 이메일에서 추출한 아이디 조회 (@ 앞) 
-- replace, trim, substr
SELECT 
	emp_name,
    email,
    replace(email, '@kh.or.kr', '')
FROM employee;

SELECT
	emp_name,
    email,
    trim(trailing '@kh.or.kr' from email)
FROM employee;

SELECT
	emp_name,
    substr(email, 1, instr(email, '@')-1)
FROM employee;


/*
	숫자 처리 함수
    
    ABS(숫자) 
    - 숫자의 절대값 반환 
*/
SELECT abs(-10);
SELECT abs(-5.7);

/*
	숫자 DIV 숫자 = 숫자 / 숫자
    MOD(숫자, 숫자) = 숫자 MOD 숫자 = 숫자 % 숫자
*/
SELECT 
	10 DIV 3, 10 / 3, 
    mod(10, 3), 10 MOD 3, 10 % 3;

/*
	ROUND(숫자, [위치])
    - 반올림한 결과를 반환 
*/
SELECT round(123.456); -- 123, 위치 기본값 : 0
SELECT round(123.456, 1); -- 123.5
SELECT round(123.456, 5); -- 123.456
SELECT round(123.456, -1); -- 120
SELECT round(123.456, -2); -- 100

/*
	CEIL(숫자)
    - 올림 처리해서 반환 
*/
SELECT ceil(123.152); -- 124

/*
	FLOOR(숫자)
    - 버림 처리해서 반환
*/
SELECT floor(123.952); -- 123

/*
	TRUNCATE(숫자, 위치)
    - 위치 지정하여 버림 처리해서 반환
*/
SELECT truncate(123.456, 1); -- 123.4 
SELECT truncate(123.456, -1); -- 120

/*
	날짜 처리 함수
    NOW(), CURRENT_TIMESTAMP() : 현재 날짜와 시간 반환 
    CURDATE(), CURRENT_DATE() : 현재 날짜 반환
    CURTIME(), CURRENT_TIME() : 현재 시간 반환 
*/
SELECT now(), current_timestamp(),
	   curdate(), current_date(),
       curtime(), current_time();
       
/*
	DAYOFYEAR(날짜) : 날짜가 해당 연도에서 몇 번째 날인지 반환 
    DAYOFMONTH(날짜) : 날짜가 해당 월에서 몇 번째 날인지 반환 
    DAYOFWEEK(날짜) : 날짜가 해당 주에서 몇 번째 날인지 반환 (일요일=1, 토요일=7)
*/
SELECT dayofyear(now()), dayofmonth(now()), dayofweek(now());

/*
	PERIOD_DIFF(YYYYMM|YYMM, YYYYMM|YYMM) : 두 기간의 차이를 숫자로 반환 
    DATEDIFF(날짜, 날짜) : 두 날짜 사이의 일수를 숫자로 반환 
    TIMEDIFF(날짜, 날짜) : 두 시간의 차이를 날짜 형식으로 반환 
    TIMESTAMPDIFF(날짜단위, 날짜, 날짜) : 두 날짜 사이의 기간을 날짜단위에 따라 변환 
    
    * 날짜 단위 : YEAR(연도), QUARTER(분기), MONTH(월), WEEK(주), DAY(일)
                HOUR(시간), MINUTE(분), SECOND(초)
*/
SELECT period_diff(202312, 202403); -- -3
SELECT period_diff(202503, 202312); -- 15

SELECT datediff('2023-12-31', now()); -- 5
SELECT timediff('2024-01-01 00:00:00', now()); -- 129:41:36

-- 직원명, 입사일, 근무 일 수, 근무 개월 수, 근무 년 수 조회 
SELECT 
	emp_name, hire_date,
    datediff(now(), hire_date) "근무 일 수",
    timestampdiff(day, hire_date, now()) "근무 일 수 2",
    timestampdiff(month, hire_date, now()) "근무 개월 수",
    timestampdiff(year, hire_date, now()) "근무 년 수"
FROM employee;

/*
	ADDDATE(날짜, INTERVAL 숫자 날짜단위 (YEAR, MONTH, DAY, HOUR, MINUTE, SECOND)
    ADDTIME(날짜, 시간 정보)
    - 특정 날짜에 입력받은 정보만큼 더한 날짜를 반환 
    
    SUBDATE(날짜, INTERVAL 숫자 날짜단위 
    SUBTIME(날짜, 시간 정보)
    - 특정 날짜에 입력받은 정보만큼 뺀 날짜를 반환 
*/
SELECT now(), adddate(now(), interval 15 day);
SELECT now(), subdate(now(), interval 15 day);
SELECT now(), addtime(now(), "1 01:01:30");
SELECT now(), subtime(now(), "1 01:01:30");

-- 직원명, 입사일, 입사 후 6개월이 된 날짜를 조회 
SELECT emp_name, hire_date,
	adddate(hire_date, interval 6 month)
FROM employee;

/*
	LAST_DAY(날짜) : 해당 월의 마지막 날짜를 반환 
*/
SELECT last_day(now());
SELECT last_day('2024-02-04');

/*
	YEAR(날짜)
	MONTH(날짜)
    DAY(날짜)
    HOUR(날짜)
    MINUTE(날짜)
    SECOND(날짜)
    - 특정 날짜에 연도, 월, 일, 시간, 분, 초 정보를 각각 추출해서 반환 
*/
SELECT year(now()), month(now()), day(now()),
	   hour(now()), minute(now()), second(now());

-- 연도별 오래된 순으로 직원명, 입사년도, 입사월, 입사일 조회 
SELECT
	emp_name, hire_date,
    year(hire_date) "입사년도",
    month(hire_date) "입사월",
    day(hire_date) "입사일"
FROM employee
ORDER BY 입사년도, 입사월, 입사일;

/*
	형 변환 함수
    CAST(값 AS 데이터형식)
    CONVERT(값, 데이터형식[길이])
*/
SELECT CAST(1234 AS CHAR), CONVERT(1234, CHAR);

/*
	포맷 함수
    FORMAT(숫자, 위치) : 숫자에 3단위씩 콤마 추가해서 반환 
    DATE_FORMAT(날짜, 포맷 형식) : 날짜 형식을 변경해서 반환
*/
SELECT emp_name, salary, format(salary, 2) 
FROM employee;

SELECT now(), date_format(now(), '%Y.%m.%d');
SELECT now(), date_format(now(), '%Y.%m.%d %T');
SELECT now(), date_format(now(), '%Y년 %m월 %d일 %H시 %i분 %s초');

-- 직원명, 입사일(2023년 12월 26일) 조회
SELECT 	
	emp_name, 
	date_format(hire_date, '%Y년 %m월 %d일 %H시 %i분 %s초')
FROM employee;

/*
	null 처리 함수 
    
    COALESCE|IFNULL(값, 값이 NULL일 경우 반환할 값)
*/
SELECT emp_name, bonus, coalesce(bonus, 0)
FROM employee;

-- 전 사원의 직원명, 보너스, 보너스 포함 연봉(급여 + 급여 * 보너스) * 12 조회 
SELECT
	emp_name,
    ifnull(bonus, 0),
    (salary + salary * ifnull(bonus, 0)) * 12 "연봉"
FROM employee;

-- 직원명, 부서 코드(dept_code) 조회 (부서 코드가 없으면 '부서없음')
SELECT emp_name, coalesce(dept_code, '부서없음')
FROM employee;

/*
	NULLIF(값1, 값2)
    - 두 개의 값이 동일하면 NULL 반환, 두 개의 값이 동일하지 않으면 값1 반환 
*/
SELECT nullif('123', '123'); -- null
SELECT nullif('123', '456'); -- 123

SELECT nullif('1234', 1234); -- null

/*
	IF(값1, 값2, 값3) | IF(조건, 조건True인경우, 조건False인경우)
    - 값1이 null이 아니면 값2 반환, null이면 값3 반환 
    - 조건에 해당하면 두번째 값 반환, 해당하지 않으면 마지막 값 반환 
*/

select emp_name, bonus, if(bonus, 0.7, 0.1)
from employee;

-- 사번, 사원명, 주민번호, 성별(남, 여) 조회

select emp_id, emp_name, emp_no, if(substr(emp_no, 8, 1) = 2, "여", "남")
from employee;


/* 사원명, 직급 코드(job_code), 기존 급여(salary), 인상된 급여 조회
	정렬 : 직급 코드 j1부터, 인상된 급여 높은 순서대로 
    직급 코드가 j7인 사원은 급여를 10% 인상
    직급 코드가 j6인 사원은 급여를 15% 인상
    직급 코드가 j5인 사원은 급여를 20% 인상
    그 외의 직급의 사원은 급여를 5%만 인상    
*/

select 
	emp_name, job_code, format(salary, 0) 급여, 
	format(if(job_code = 'j7', salary * 1.1, 
		if(job_code = 'j6', salary * 1.15,
			if(job_code = 'j7', salary * 1.2, salary * 1.05)
			)
		),0) "인상된 급여"
from employee
order by 2, 4 desc;

/*
	CASE WHEN 조건식 1 THEN 결과값 1
		 WHEN 조건식 2 THEN 결과값 2
		 ...
		 ELSE 결과값 N
    END
    
    -> if ~ else if ~ else문과 유사
*/

-- 사번, 사원명, 주민번호, 성별(남자, 여자) 조회
select
	emp_id, emp_name, emp_no,
    CASE WHEN substr(emp_no, 8, 1) = 1 then '남자'
		when substr(emp_no, 8, 1) = 2 then '여자'
        ELSE "잘못된 주민번호입니다"
        END "성별"        
from employee;

-- 사원명, 급여, 급여 등급(1 ~ 4등급) 조회
-- salary 값이 500만원 초과일 경우 1등급
-- salary 값이 500만원 이하 350만원 초과일 경우 2등급
-- salary 값이 350만원 이하 200만원 초과일 경우 3등급
-- 그 외의 경우 4등급

select
	emp_name, salary, 
    case when salary > 5000000 then '1등급'
		when salary > 3500000 then '2등급'
		when salary > 2000000 then '3등급'
        else '4등급'
	end "급여등급"
from employee;
    
-- 그룹함수(집계함수)
/*
	그룹함수 --> 결과값 1개
    -대량의 데이터들로 집계나 통계 같은 작업을 처리해야 하는 경우 사용되는 함수들
    - 모든 그룹함수는 null겂을 자동으로 제외하고 값이 있는것돌만 고상
    sum(숫자)
    - 해당 컬럼 값들의 총 합계를 반환
*/
-- 전체 사원의 총 급여 합 조회
select format(aun(salary), 0), "급여 합계"
from employee;

-- 부서코드(dept_code)가 d5인 사원들의 총 연봉(급여 *12)합 조회
select format(SUM(salary*12),0) "연봉 합계"
from employee
where dept_code = 'd5';

-- 전체 사원의 
/*
	AVG(숫자)
    - 해당 컬럼값들의 평균 값을 반환
    - 모든 그룹함수는 NULL값을 자동으로 제외하기 때문에
    AVG 함수를 사용할 떄는 coalesce 또는 IFnill 함수와 함께 사용하는 것을 권장 
 */
 -- 전체 사원의 평균 급여, 평균 보너스율 조회 
 SELECT 
	avg(salary), avg(ifnull(salary, 0)),
    avg(bonus), avg(ifnull(bonus, 0))
 FROM employee;

/*
	MIN|MAX(모든 타입의 컬럼)
    - min : 해당컬럼값들 중에 가장 작은 값을 반환
	- max : 해당 컬럼 값들 중에 가장 큰 값을 반환
*/

-- 가장 작은 값에 해당하는 사원명, 급여, 입사일
-- 가장 큰 값에 해당하는 사원명, 급여, 입사일 조회

select 
	min(emp_name), min(salary), min(hire_date),
    max(emp_name), max(salary), max(hire_date)
from employee;

/*
	count(*|컬럼|DISTINST 컬럼)
    - 컬럼 또는 행의 개수를 세서 반환
    
    count(*) : 조회 결과에 해당하는 모든 행 개수를 반환
    count(컬럼) : 해당 컬럼값이 null이 아닌 행 개수를 반환
    count(distinct 컬럼) : 해당 컬럼값의 중복을 제거한 행 개수를 반환
*/

select *
from employee;


-- 전체 사원 수 조회
select count(*)
from employee;

-- 보너스를 받은 사원수 조회
select count(bonus)
from employee;

-- 부서가 배치 된 사원수 조회
select count(dept_code)
from employee;

-- 현재 사원들이 속해있는 부서 수 조회
select count(distinct dept_code)
from employee;

-- 현재 사원들이 분포되어 있는 직급 수 조회
select count(distinct job_code)
from employee;

-- 퇴사한 직원의 수 조회
select count(ent_date)
from employee; 

select count(ent_id)
from employee
where ent_yn = y;