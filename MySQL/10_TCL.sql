/*
	TCL(Transaction Control Language)
    - 트랜잭션을 제어하는 언어
    - 데이터베이스는 데이터의 변경 사항(INSERT, UPDATE, DELETE)들을 
		묶어서 하나의 트랜잭션에 담아서 처리
        
	트랜잭션(Transaction)
    - 하나의 논리적인 작업 단위 
    EX) ATM에서 현금 출력
        1. 카드 삽입
        2. 메뉴 선택 
        3. 금액 확인 
        4. 인증 - 비밀번호 입력
        5. 실제 계좌에서 금액만큼 인출 
        6. 현금 인출 
        7. 완료 
    - 각각의 업무들을 묶어서 하나의 작업 단위로 만드는 것을 트랜잭션!  
    
    COMMIT
    - 모든 작업들을 정상적으로 처리하겠다고 확정하는 구문 
    
    ROLLBACK 
    - 모든 작업들을 취소하겠다고 확정하는 구문 (마지막 COMMIT 시점으로 돌아간다.)
    
    SAVEPOINT 
    - 저장점을 지정하고 ROLLBACK 진행 시 전체 작업을 ROLLBACK 하는 것이 아닌 
		SAVEPOINT까지 일부만 롤백 한다.
	SAVEPOINT 포인트명;
    ROLLBACK TO 포인트명;
*/
-- MySQL에서는 기본적으로 autocommit 모드가 활성화되어 있음 
-- 비활성화 
set autocommit = 0;

-- 트랜잭션 시작! 
START transaction;

Drop TABLE dept_copy;
-- 테스트 진행할 테이블들 추가! 
CREATE TABLE dept_copy
AS SELECT * FROM kh.department;

CREATE TABLE emp_salary
AS SELECT emp_id, emp_name, dept_code, salary, bonus
	FROM kh.employee;
    
SELECT * FROM dept_copy;

-- dept_copy 테이블에서 dept_id가 'D9'인 부서명을 '전략기획팀'으로 수정 
-- UPDATE 테이블명 SET 변경할내용 WHERE 조건;
UPDATE dept_copy
SET dept_title = '전략기획팀'
WHERE dept_id = 'D9';

ROLLBACK;

COMMIT;

START transaction;
SELECT * FROM emp_salary;
DROP TABLE emp_salary;

-- emp_salary 테이블에서 노옹철 사원의 급여를 3000000원으로 변경


UPDATE emp_salary
SET salary = 3000000
WHERE emp_name = '노옹철';

ROLLBACK;

CREATE TABLE emp_test
AS SELECT emp_id, emp_name, dept_code
	FROM kh.employee;
    
SELECT * FROM emp_test;
DROP table emp_test;

START transaction;

-- emp_test에서 emp_id가 213, 218인 사원 삭제
-- DELETE FROM 테이블명 WHERE 조건;
DELETE FROM emp_test
WHERE emp_id IN(213, 218);

-- 두 개의 행이 삭제된 시점에서 SAVEPOINT 지정
SAVEPOINT sp1;

-- emp_id가 200인 사원 삭제
DELETE FROM emp_test
WHERE emp_id = 200;

ROLLBACK TO sp1;

ROLLBACK;


-- DDL 구문을 실행하는 순간 임시 저장된 변경사항들을 무조건 반영
CREATE TABLE test(
tid INT
);

-- >> 트랜젝션 : Java -> JDBC(Java DATA Base Connection, Java - MySQL 연결)
-- >> 						--> JDBC 때 다룰 예정
