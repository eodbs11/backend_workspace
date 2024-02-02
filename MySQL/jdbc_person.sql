CREATE TABLE person(
	id Int AUTO_INCREMENT PRIMARY key,
    name VARCHAR(20),
    address VARCHAR(30)
    );
    
SELECT * FROM kh.person;

INSERT INTO person 
VALUES(999, '테스트', '서울');

DELETE FROM person
WHERE id = 1;

SELECT *
FROM person
WHERE id = 111;

CREATE TABLE member(
	id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    name VARCHAR(20)
);

SELECT * FROM kh.member;