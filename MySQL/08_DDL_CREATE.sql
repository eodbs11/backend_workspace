/*
	DDL (Data Definition Language) : 데이터 정의어
    - 객체(Object)/스키마(Schema)를 만들고(CREATE), 변경하고(ALTER),
      삭제(DROP)하는 언어
    - 즉, 실제 데이터 값이 아닌 구조 자체를 정의하는 언어   
    - 주로 DB 관리자, 설계자가 사용 
    
    * MySQL에서 객체(구조) : 테이블(Table), 뷰(View), 인덱스(Index),
						  프로시저(Procedure), 트리거(Trigger), 함수(Function)
*/
/*
	CREATE
    - 객체를 생성하는 구문 
    
    테이블 생성 
    CREATE TABLE 테이블명(
		컬럼명 자료형(크기),
        컬럼명 자료형(크기),
        ...
    );
    
    * 자료형
    1. 문자 
        - CHAR / **VARCHAR** : 고정 및 가변 길이 문자, 반드시 크기 지정 
        - TEXT : 매우 긴 문자열을 저장하는데 사용 
	2. 숫자 
        - **INT** : 정수값 저장하는데 사용
        - FLOAT / DOUBLE : 부동소수점 저장하는데 사용 
        - DECIMAL : 고정소수점 저장하는데 사용 
	3. 날짜 및 시간
        - **DATE** : 날짜 저장하는데 사용
        - TIME : 시간 저장하는데 사용 
        - DATETIME / TIMESTAMP : 날짜와 시간을 함께 저장 
	4. 불리언 
		- BOOLEAN / BOOL : 참(True) 또는 거짓(False) 값을 저장하는데 사용 
	5. 이진 자료형
		- BLOB : 이진 데이터를 저장하는데 사용. 이미지나 동영상과 같은 이진 파일 
        --> 실제로는 이미지나 동영상은 따로 관리함 
*/
-- 회원에 대한 데이터를 담을 member 테이블 생성
CREATE TABLE member(
	mem_no INT,
    mem_id VARCHAR(20),
    mem_pwd VARCHAR(20),
    mem_name VARCHAR(20),
    gender CHAR(3),
    phone VARCHAR(13),
    email VARCHAR(50),
    mem_date DATE
);

-- 테이블 구조를 표시해주는 구문 
DESC member;

SELECT * FROM member;

-- 테이블에 데이터를 추가시키는 구문 (DML : INSERT)
-- INSERT INTO 테이블명 VALUES(값, 값, ...);
INSERT INTO member VALUES(1, 'user01', 'pass01', '이상현', '남', '010-0000-0000', 'aaa@naver.com', '2023-11-30');
INSERT INTO member VALUES(2, 'user02', 'pass02', '이상호', '남', null, NULL, NOW());
INSERT INTO member VALUES(2, 'user02', 'pass02', '이상호', '남', null, NULL, current_date());
INSERT INTO member VALUES(null, null, null, null, null, null, null, null);

/*
	제약조건(CONSTRAINTS)
    - 사용자가 원하는 조건의 데이터만 유지하기 위해서 각 컬럼에 대해 
       저장될 값에 대한 제약조건을 설정 
	- 제약조건은 데이터 무결성 보장을 목적으로 한다. 
    - 종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY 
*/
/*
	NOT NULL 
    - 해당 컬럼에 반드시 값이 있어야만 하는 경우 
      (즉, 해당 컬럼에 절대 NULL이 들어와서는 안되는 경우) 
    - 추가/수정시 NULL 값을 허용하지 않도록 제한   
*/
CREATE TABLE mem_notnull(
	mem_no INT NOT NULL,
    mem_id VARCHAR(20) NOT NULL,
    mem_pwd VARCHAR(20) NOT NULL,
    mem_name VARCHAR(20) NOT NULL,
    gender CHAR(3),
    phone VARCHAR(13),
    email VARCHAR(50),
    mem_date DATE
);

INSERT INTO mem_notnull VALUES(1, 'user01', 'pass01', '정세영', '여', null, null, null);
INSERT INTO mem_notnull VALUES(2, 'user02', null, '김현수', '남', null, null, current_date());
-- > NOT NULL 제약조건에 위배되어 오류 발생! 

INSERT INTO mem_notnull VALUES(2, 'user01', 'pass01', '김현수', '남', null, null, null);

SELECT * FROM mem_notnull;

/*
	UNIQUE
    - 해당 컬럼에 중복된 값이 들어와서는 안 되는 경우
    - 추가/수정 시 기존에 있는 데이터값 중 중복값이 있을 경우 오류 발생 
*/
DROP TABLE mem_unique;
CREATE TABLE mem_unique(
	mem_no INT NOT NULL,
    mem_id VARCHAR(20) NOT NULL UNIQUE,
    mem_pwd VARCHAR(20) NOT NULL,
    mem_name VARCHAR(20) NOT NULL,
    gender CHAR(3),
    phone VARCHAR(13),
    email VARCHAR(50),
    mem_date DATE
);

INSERT INTO mem_unique VALUES(1, 'user01', 'pass01', '정대윤', null, null, null, null);
INSERT INTO mem_unique VALUES(2, 'user01', 'pass02', '권예빈', null, null, null, null);
-- > unique 제약조건에 위배되어 insert 실패! 
INSERT INTO mem_unique VALUES(2, 'user02', 'pass02', '권예빈', null, null, null, null);
INSERT INTO mem_unique VALUES(3, 'user03', 'pass03', '정동준', 'ㄴ', null, null, null);
-- > 성별에 유효한 값이 아니어도 지금 들어오고 있음! 

SELECT * FROM mem_unique;

/*
	CHECK(조건식)
    - 해당 컬럼에 들어올 수 있는 값에 대한 조건을 제시해볼 수 있음! 
    - 해당 조건에 만족하는 데이터값만 담길 수 있음 
*/
DROP TABLE mem_check;
CREATE TABLE mem_check(
	mem_no INT NOT NULL,
    mem_id VARCHAR(20) NOT NULL UNIQUE,
    mem_pwd VARCHAR(20) NOT NULL,
    mem_name VARCHAR(20) NOT NULL,
    gender CHAR(3) NOT NULL,
    phone VARCHAR(13),
    email VARCHAR(50),
    mem_date DATE,
    CONSTRAINT mem_gender_check CHECK (gender IN ('남', '여')),
    CONSTRAINT mem_gender_not_null CHECK (gender IS NOT NULL)
);

INSERT INTO mem_check 
VALUES(1, 'user01', 'pass01', '김다은', '여', null, null, null);

INSERT INTO mem_check
VALUES(2, 'user02', 'pass02', '손민정', 'ㅇ', null, null, null);
-- > check 제약조건에 위배되었기 때문에 오류 발생! 

INSERT INTO mem_check
VALUES(2, 'user02', 'pass02', '손민정', null, null, null, null);
-- > check 제약조건 뿐만 아니라 null도 처리해야 된다는 것! 

INSERT INTO mem_check
VALUES(2, 'user02', 'pass02', '손민정', '여', null, null, null);

INSERT INTO mem_check
VALUES(2, 'user03', 'pass03', '정회영', '남', null, null, null);
-- > 회원번호(mem_no)가 동일해도 insert가 되는게 문제! 

SELECT * FROM mem_check;

/*
	PRIMARY KEY (기본키)
    - 테이블에서 각 행들을 식별하기 위해 사용될 컬럼에 부여하는 제약조건 (식별자 역할) 
      ex) 회원번호, 학번, 사원번호, 부서코드, 직급코드, 제품번호, 주문번호, 운송장번호, ...
    - PRIMARY KEY 제약조건을 부여하면 그 컬럼에 자동으로 NOT NULL + UNIQUE 조건이 설정 
    - 한 테이블 당 오로지 한 개만 설정 
    --> 복합키 설정도 가능 
*/
DROP TABLE mem_pri;
CREATE TABLE mem_pri(  
	mem_no INT, -- PRIMARY KEY
    mem_id VARCHAR(20),
    mem_pwd VARCHAR(20) NOT NULL,
    mem_name VARCHAR(20) NOT NULL,
    gender CHAR(3) CHECK (gender IN ('남', '여')) NOT NULL,
    phone VARCHAR(13),
    email VARCHAR(50),
    mem_date DATE,
    PRIMARY KEY(mem_no, mem_id)
);
INSERT INTO mem_pri 
VALUES(1, 'user01', 'pass01', '신대규', '남', null, null, null);

INSERT INTO mem_pri
VALUES(1, 'user02', 'pass02', '조세미', '여', null, null, null);
-- > 기본키에 중복값을 담으려고 해서 문제 발생! (unique 제약조건 위배)
-- > 기본키를 mem_no + mem_id 복합키로 설정했을 때는 가능! 

INSERT INTO mem_pri
VALUES(null, 'user02', 'pass02', '조세미', '여', null, null, null);
-- > 기본키에 null을 담으려고 해서 문제 발생! (not null 제약조건 위배) 


INSERT INTO mem_pri
VALUES(2, 'user01', 'pass02', '윤민영', '여', null, null, null);
-- > 복합키로 지정해서 id가 user01로 동일해도 가능! 

SELECT * FROM mem_pri;

-- 복합키 사용 예시 (어떤 회원이 어떤 상품을 찜했는지에 대한 데이터를 보관하는 테이블)
CREATE TABLE tb_like(
	mem_no INT, 
    product_name VARCHAR(10),
    like_date DATE,
    PRIMARY KEY (mem_no, product_name)
);

INSERT INTO tb_like VALUES(1, 'A', current_date());
INSERT INTO tb_like VALUES(1, 'B', current_date());
INSERT INTO tb_like VALUES(2, 'A', current_date());
INSERT INTO tb_like VALUES(1, 'A', current_date());

SELECT * FROM tb_like;

-- > 복합키 방식으로 지정해서 쓰는 거 추천 안해요! 

-- 회원등급에 대한 데이터를 따로 보관하는 테이블
CREATE TABLE mem_grade(
	grade_code INT PRIMARY KEY,
    grade_name VARCHAR(30) NOT NULL
);
INSERT INTO mem_grade VALUES(10, '일반회원');
INSERT INTO mem_grade VALUES(20, '우수회원');
INSERT INTO mem_grade VALUES(30, '특별회원');

SELECT * FROM mem_grade;

DROP TABLE member;
CREATE TABLE member(  
	mem_no INT PRIMARY KEY,
    mem_id VARCHAR(20) NOT NULL UNIQUE,
    mem_pwd VARCHAR(20) NOT NULL,
    mem_name VARCHAR(20) NOT NULL,
    gender CHAR(3) CHECK (gender IN ('남', '여')) NOT NULL,
    phone VARCHAR(13),
    email VARCHAR(50),
    grade_id INT -- > 회원 등급 번호 같이 보관할 컬럼 
);

INSERT INTO member 
VALUES(1, 'user01', 'pass01', '신대규', '남', null, null, null);

INSERT INTO member
VALUES(2, 'user02', 'pass02', '조세미', '여', null, null, 10);

INSERT INTO member
VALUES(3, 'user03', 'pass03', '정회영', '남', null, null, 40);
-- > 유효한 회원등급번호가 아님에도 insert 가능! 

SELECT * FROM mem_grade;

/*
	FOREIGN KEY(외래키) 
    - 외래키 역할을 하는 컬럼에 부여하는 제약조건 
    - 다른 테이블에 존재하는 값만 들어와야 되는 특정 컬럼에 부여하는 제약조건 
      (단, NULL 값은 가질 수 있음)
      
     --> 다른 테이블을 참조한다고 표현 
     --> 주로 FOREIGN KEY 제약조건에 의해 테이블 간의 관계가 형성됨! 
*/

DROP TABLE member;
CREATE TABLE member(  
	mem_no INT, -- PRIMARY KEY, 컬럼레벨 방식
    mem_id VARCHAR(20) NOT NULL UNIQUE,
    mem_pwd VARCHAR(20) NOT NULL,
    mem_name VARCHAR(20) NOT NULL,
    gender CHAR(3) CHECK (gender IN ('남', '여')) NOT NULL,
    phone VARCHAR(13),
    email VARCHAR(50),
    grade_id INT,
    PRIMARY KEY (mem_no), -- 테이블 레벨 방식
    Foreign key (grade_id) REFERENCES mem_grade(grade_code)
);


INSERT INTO member 
VALUES(1, 'user01', 'pass01', '신대규', '남', null, null, null);
-- > 외래키 제약조건이 부여되어도 기본적으로 null 허용됨

INSERT INTO member
VALUES(2, 'user02', 'pass02', '조세미', '여', null, null, 10);

INSERT INTO member
VALUES(3, 'user03', 'pass03', '정회영', '남', null, null, 40);
-- > 부모키(PARENT KEY)를 찾을 수 없다는 오류 발생

INSERT INTO member
VALUES(3, 'user03', 'pass03', '정회영', '남', null, null, 20);

INSERT INTO member
VALUES(4, 'user04', 'pass04', '윤민영', '여', null, null, 10);

-- > 부모 테이블(mem_grade)에서 데이터값을 삭제할 경우 어떤 문제가 발생하는지A
-- 데이터 삭제 : DELETE FROM 테이블명 WHERE 조건;

-- mem_grade 체이블에서 grade_code가 10인 등급 삭제
DELETE FROM mem_grade
WHERE grade_code = 10;
-- > 자식테이블(member)에 10이라는 값을 사용하고 있기 때문에 삭제x

-- mem_grade 체이블에서 grade_code가 30인 등급 삭제
DELETE FROM mem_grade
WHERE grade_code = 30;
-- > 자식테이블(member)에 30이라는 값을 사용하고 있지 않기 때문에 삭제o


SELECT * FROM member;
SELECT * FROM mem_grade;

DELETE FROM member WHERE mem_no = 2;
DELETE FROM member WHERE mem_no = 4;

/*
	자식테이블 생성시 외래키 제약조건을 부여할 때 삭제옵션 지정 가능
    - 삭제옵션 : 부모테이블의 데이터 삭제 시 그 데이터를 사용하고 있는 
				자식 테이블의 값을 어떻게 처리할건지
                
	1. ON DELETE RESTRICTED (기본값)
		: 자식 데이터로 쓰이는 부모데이터는 삭제가 아예 안되게끔
	2. ON DELETE SET NULL
		: 부모데이터 삭제시 해당 데이터를 쓰고 있는 자식 데이터의 값을 NULL로 처리
	3. ON DELETE CASCADE
		: 부모데이터 삭제시 해당 데이터를 쓰고 있는 자식 데이터도 같이 삭제
*/

DROP TABLE member;
CREATE TABLE member(  
	mem_no INT, -- PRIMARY KEY, 컬럼레벨 방식
    mem_id VARCHAR(20) NOT NULL UNIQUE,
    mem_pwd VARCHAR(20) NOT NULL,
    mem_name VARCHAR(20) NOT NULL,
    gender CHAR(3) CHECK (gender IN ('남', '여')) NOT NULL,
    phone VARCHAR(13),
    email VARCHAR(50),
    grade_id INT,
    PRIMARY KEY (mem_no), -- 테이블 레벨 방식
    Foreign key (grade_id) REFERENCES mem_grade(grade_code) ON DELETE SET NULL
);

INSERT INTO member 
VALUES(1, 'user01', 'pass01', '신대규', '남', null, null, null);

INSERT INTO member
VALUES(2, 'user02', 'pass02', '조세미', '여', null, null, 10);

INSERT INTO member
VALUES(3, 'user03', 'pass03', '정회영', '남', null, null, 20);

INSERT INTO member
VALUES(4, 'user04', 'pass04', '윤민영', '여', null, null, 10);

SELECT * FROM mem_grade;
SELECT * FROM member;

-- mem_grade에서 grade_code가 10인 등급을 삭제
DELETE FROM mem_grade
WHERE grade_code = 10;
-- > 잘 삭제됨 단, 10을 가져다 쓰고 있던 자식 데이터 값은 NULL로 변경됨

INSERT INTO mem_grade VALUES(10, '일반회원');

-- ON DELETE CASCADE

DROP TABLE member;
CREATE TABLE member(  
	mem_no INT, -- PRIMARY KEY, 컬럼레벨 방식
    mem_id VARCHAR(20) NOT NULL UNIQUE,
    mem_pwd VARCHAR(20) NOT NULL,
    mem_name VARCHAR(20) NOT NULL,
    gender CHAR(3) CHECK (gender IN ('남', '여')) NOT NULL,
    phone VARCHAR(13),
    email VARCHAR(50),
    grade_id INT,
    PRIMARY KEY (mem_no), -- 테이블 레벨 방식
    Foreign key (grade_id) REFERENCES mem_grade(grade_code) ON DELETE CASCADE
);

INSERT INTO member 
VALUES(1, 'user01', 'pass01', '신대규', '남', null, null, null);

INSERT INTO member
VALUES(2, 'user02', 'pass02', '조세미', '여', null, null, 10);

INSERT INTO member
VALUES(3, 'user03', 'pass03', '정회영', '남', null, null, 20);

INSERT INTO member
VALUES(4, 'user04', 'pass04', '윤민영', '여', null, null, 10);

-- 10번 등급 삭제!
DELETE FROM mem_grade
WHERE grade_code = 10;

SELECT * FROM mem_grade;
SELECT * FROM member;

/*
	DEFAULT 기본값
    - 제약조건 아님
    - 컬럼을 선정하지 않고 INSERT시 NULL이 아닌 기본값을 세팅해주는 값
*/

DROP TABLE member;
CREATE TABLE member(  
	mem_no INT AUTO_INCREMENT PRIMARY KEY,    
    mem_name VARCHAR(20) NOT NULL,
    mem_age INT,
    hobby VARCHAR(20) DEFAULT '노래',
    -- enroll_date DATETIME DEFAULT NOW()
    enroll_date DATE DEFAULT (current_date)
);

INSERT INTO member VALUES(1, '손민정', 20, DEFAULT, '23-11-30');
INSERT INTO member VALUES(2, '정세영', 20, DEFAULT, null);
INSERT INTO member VALUES(3, '김다은', 20, DEFAULT, DEFAULT);

-- INSERT INTO 테이블명(컬럼명, 컬럼명, ...) VALUES(컬럼값, 컬럼값, ...);
INSERT INTO member(mem_no, mem_name) VALUES(4, '권예빈');
-- > 선택되지 않은 컬럼에는 기본적으로 NULL이 들어감
-- 단, 해당 컬럼에 DEFAULT 값이 부여되어 있을경우 NULL이 아닌 DEFAULT 값이 들어감
INSERT INTO member(mem_name) VALUES('권예빈');
-- > AUTO_INCREMENT를 지정하여 mem_no가 자동으로 1 증가해서 추가

SELECT * FROM member;

/*
	서브쿼리를 이용한 테이블 생성
    - 컬럼명, 데이터 타입, 값 모두 복사 / 제약조건은 NOT NULL만
    
    CREATE TABLE 테이블명
    AS 서브쿼리;
*/
-- employee 테이블 복사하여 새로운 테이블 생성
CREATE TABLE employee_copy
AS SELECT * FROM kh.employee;

DESC employee_copy;
SELECT * FROM kh.employee;

SELECT * FROM employee_copy;

DROP TABLE employee_copy;

-- 데이터 값은 복사하지 X
CREATE TABLE employee_copy
AS SELECT * FROM kh.employee WHERE 1 = 0;
-- 모든 행에 대해서 매번 false이기 때문에 테이블의 구조만 복사되고 데이터 값은 복사되지 x

DROP TABLE employee_copy;
-- employee 테이블에서 사번, 직원명, 급여, 연봉만 저장하는 테이블 생성

CREATE TABLE employee_copy
AS SELECT emp_id, emp_name, salary, salary * 12 as "연봉"
FROM kh.employee;

CREATE TABLE employee_copy
AS SELECT 
	emp_id 사번, 
    emp_name 직원명, 
    format(salary, 0) 급여, 
    format(salary * 12, 0) 연봉
FROM kh.employee;

SELECT * FROM employee;

