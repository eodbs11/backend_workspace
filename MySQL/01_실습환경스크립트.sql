DROP TABLE employee;
DROP TABLE department;
DROP TABLE location;
DROP TABLE national;
DROP TABLE job;
DROP TABLE sal_grade;
--
CREATE TABLE department(
    dept_id CHAR(2) PRIMARY KEY,
    dept_title VARCHAR(35) NOT NULL,
    location_id CHAR(2) NOT NULL
); 

INSERT INTO department (dept_id, dept_title, location_id) VALUES ('D1','인사관리부','L1');
INSERT INTO department (dept_id, dept_title, location_id) VALUES ('D2','회계관리부','L1');
INSERT INTO department (dept_id, dept_title, location_id) VALUES ('D3','마케팅부','L1');
INSERT INTO department (dept_id, dept_title, location_id) VALUES ('D4','국내영업부','L1');
INSERT INTO department (dept_id, dept_title, location_id) VALUES ('D5','해외영업1부','L2');
INSERT INTO department (dept_id, dept_title, location_id) VALUES ('D6','해외영업2부','L3');
INSERT INTO department (dept_id, dept_title, location_id) VALUES ('D7','해외영업3부','L4');
INSERT INTO department (dept_id, dept_title, location_id) VALUES ('D8','기술지원부','L5');
INSERT INTO department (dept_id, dept_title, location_id) VALUES ('D9','총무부','L1');

CREATE TABLE employee(
	emp_id VARCHAR(3) PRIMARY KEY,
    emp_name VARCHAR(20) NOT NULL,
    emp_no CHAR(14) NOT NULL,
    email VARCHAR(25),
    phone VARCHAR(12),
    dept_code CHAR(2),
    job_code CHAR(2),
    salary INT,
    bonus DOUBLE,
    manager_id VARCHAR(3),
    hire_date DATE,
    ent_date DATE,
    ent_yn CHAR(1) DEFAULT 'N'
);


INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('200','선동일','621235-1985634','sun_di@kh.or.kr','01099546325','D9','J1',8000000,0.3,null,'1990-02-06',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('201','송종기','631156-1548654','song_jk@kh.or.kr','01045686656','D9','J2',6000000,null,'200','2001-09-01',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('202','노옹철','861015-1356452','no_hc@kh.or.kr','01066656263','D9','J2',3700000,null,'201','2001-01-01',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('203','송은희','631010-2653546','song_eh@kh.or.kr','01077607879','D6','J4',2800000,null,'204','1996-05-03',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('204','유재식','660508-1342154','yoo_js@kh.or.kr','01099999129','D6','J3',3400000,0.2,'200','2000-12-29',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('205','정중하','770102-1357951','jung_jh@kh.or.kr','01036654875','D6','J3',3900000,null,'204','1999-09-09',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('206','박나라','630709-2054321','pack_nr@kh.or.kr','01096935222','D5','J7',1800000,null,'207','2008-04-02',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('207','하이유','690402-2040612','ha_iy@kh.or.kr','01036654488','D5','J5',2200000,0.1,'200','1994-07-07',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('208','김해술','870927-1313564','kim_hs@kh.or.kr','01078634444','D5','J5',2500000,null,'207','2004-04-30',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('209','심봉선','750206-1325546','sim_bs@kh.or.kr','0113654485','D5','J3',3500000,0.15,'207','2011-11-11',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('210','윤은해','650505-2356985','youn_eh@kh.or.kr','0179964233','D5','J7',2000000,null,'207','2001-02-03',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('211','전형돈','830807-1121321','jun_hd@kh.or.kr','01044432222','D8','J6',2000000,null,'200','2012-12-12',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('212','장쯔위','780923-2234542','jang_zw@kh.or.kr','01066682224','D8','J6',2550000,0.25,'211','2015-06-17',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('213','하동운','621111-1785463','ha_dh@kh.or.kr','01158456632',null,'J6',2320000,0.1,null,'1999-12-31',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('214','방명수','856795-1313513','bang_ms@kh.or.kr','01074127545','D1','J7',1380000,null,'200','2010-04-04',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('215','대북혼','881130-1050911','dae_bh@kh.or.kr','01088808584','D5','J5',3760000,null,null,'2017-06-19',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('216','차태연','770808-1364897','cha_ty@kh.or.kr','01064643212','D1','J6',2780000,0.2,'214','2013-03-01',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('217','전지연','770808-2665412','jun_jy@kh.or.kr','01033624442','D1','J6',3660000,0.3,'214','2007-03-20',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('218','이오리','870427-2232123','loo_or@kh.or.kr','01022306545',null,'J7',2890000,null,null,'2016-11-28',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('219','임시환','660712-1212123','im_sw@kh.or.kr',null,'D2','J4',1550000,null,null,'1999-09-09',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('220','이중석','770823-1113111','lee_js@kh.or.kr',null,'D2','J4',2490000,null,null,'2014-09-18',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('221','유하진','800808-1123341','yoo_hj@kh.or.kr',null,'D2','J4',2480000,null,null,'1994-01-20',null,'N');
INSERT INTO employee (emp_id, emp_name, emp_no, email, phone, dept_code, job_code, salary, bonus, manager_id, hire_date, ent_date, ent_yn) VALUES ('222','이태림','760918-2854697','lee_tr@kh.or.kr','01033000002','D8','J6',2436240,0.35,'100','1997-09-12','2017-09-12','Y');

CREATE TABLE job(
	job_code CHAR(2) PRIMARY KEY,
    job_name VARCHAR(35)
);

INSERT INTO job (job_code, job_name) VALUES ('J1','대표');
INSERT INTO job (job_code, job_name) VALUES ('J2','부사장');
INSERT INTO job (job_code, job_name) VALUES ('J3','부장');
INSERT INTO job (job_code, job_name) VALUES ('J4','차장');
INSERT INTO job (job_code, job_name) VALUES ('J5','과장');
INSERT INTO job (job_code, job_name) VALUES ('J6','대리');
INSERT INTO job (job_code, job_name) VALUES ('J7','사원');

CREATE TABLE location(
	local_code CHAR(2) PRIMARY KEY,
    national_code CHAR(2) NOT NULL,
    local_name VARCHAR(40) NOT NULL
);

INSERT INTO location (local_code, national_code, local_name) VALUES ('L1','KO','ASIA1');
INSERT INTO location (local_code, national_code, local_name) VALUES ('L2','JP','ASIA2');
INSERT INTO location (local_code, national_code, local_name) VALUES ('L3','CH','ASIA3');
INSERT INTO location (local_code, national_code, local_name) VALUES ('L4','US','AMERICA');
INSERT INTO location (local_code, national_code, local_name) VALUES ('L5','RU','EU');

CREATE TABLE national(
	national_code CHAR(2) PRIMARY KEY,
    national_name VARCHAR(35)
);

INSERT INTO national (national_code, national_name) VALUES ('KO','한국');
INSERT INTO national (national_code, national_name) VALUES ('JP','일본');
INSERT INTO national (national_code, national_name) VALUES ('CH','중국');
INSERT INTO national (national_code, national_name) VALUES ('US','미국');
INSERT INTO national (national_code, national_name) VALUES ('RU','러시아');

CREATE TABLE sal_grade(
	sal_level CHAR(2) PRIMARY KEY,
    min_sal INT,
    max_sal INT
);

INSERT INTO sal_grade (sal_level, min_sal, max_sal) VALUES ('S1',6000000,10000000);
INSERT INTO sal_grade (sal_level, min_sal, max_sal) VALUES ('S2',5000000,5999999);
INSERT INTO sal_grade (sal_level, min_sal, max_sal) VALUES ('S3',4000000,4999999);
INSERT INTO sal_grade (sal_level, min_sal, max_sal) VALUES ('S4',3000000,3999999);
INSERT INTO sal_grade (sal_level, min_sal, max_sal) VALUES ('S5',2000000,2999999);
INSERT INTO sal_grade (sal_level, min_sal, max_sal) VALUES ('S6',1000000,1999999);

ALTER TABLE employee ADD FOREIGN KEY (dept_code) REFERENCES department(dept_id);
ALTER TABLE employee ADD FOREIGN KEY (job_code) REFERENCES job(job_code);
ALTER TABLE department ADD FOREIGN KEY (location_id) REFERENCES location(local_code);
ALTER TABLE location ADD FOREIGN KEY (national_code) REFERENCES national(national_code);