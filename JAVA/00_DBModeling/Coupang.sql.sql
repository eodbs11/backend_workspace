CREATE TABLE category(
		cate_code INT AUTO_INCREMENT PRIMARY KEY,
		cate_name VARCHAR(30) NOT NULL,
        parent_code INT -- 부모 카테고리 코드
); -- 카테고리

CREATE TABLE product(
	prod_code INT AUTO_INCREMENT PRIMARY KEY, -- 상품 코드
    ente_code VARCHAR(50), -- 업체 아이디
    cate_code INT, -- 카테고리 코드
    prod_name VARCHAR(30) NOT NULL, -- 상품명
    prod_desc TEXT,	-- 상품 설명
    price INT NOT NULL,  -- 가격
	stock INT NOT NULL,	-- 재고수량
    prod_date DATE DEFAULT(current_date) -- 상품등록일
); -- 상품

CREATE TABLE enterprise(
	ente_id VARCHAR(50) PRIMARY KEY, -- 업체 아이디
    password VARCHAR(50) NOT NULL, -- 비밀번호
    name VARCHAR(30), -- 대표자 이름
    company VARCHAR(50), -- 업체명
    address VARCHAR(100), -- 업체 주소
    regist_number VARCHAR(50), -- 사업자 등록번호
    company_phone VARCHAR(50) -- 업체 번호
); -- 업체

CREATE TABLE customer(
	id VARCHAR(50) PRIMARY KEY, -- 아이디
	password VARCHAR(50) NOT NULL, -- 비밀번호
    name VARCHAR(30), -- 고객명
	phone VARCHAR(20), -- 전화번호
    address VARCHAR(100), -- 주소
    email VARCHAR(50) -- 이메일
); -- 고객

CREATE TABLE pick(
	pick_code INT AUTO_INCREMENT PRIMARY KEY, -- 찜코드
    id VARCHAR(50), -- 아이디
    prod_code INT, -- 상품 코드
    pick_date DATE DEFAULT (current_date) -- 찜한 날짜
);	-- 찜

CREATE TABLE review(
	revi_code INT AUTO_INCREMENT PRIMARY KEY, -- 리뷰 코드
    id VARCHAR(50), -- 아이디
    prod_code INT, -- 상품 코드
    title VARCHAR(50), -- 제목
    revi_desc TEXT, -- 설명
    revi_date DATE DEFAULT (current_date), -- 작성 날짜
    rating INT -- 평점
); -- 리뷰

CREATE TABLE purchase(
	pur_code INT AUTO_INCREMENT PRIMARY KEY, -- 구매코드
	id VARCHAR(50), -- 아이디
    prod_code INT, -- 상품 코드
    pur_date DATE DEFAULT (current_date), -- 구매 일시
    pur_status VARCHAR(10) CHECK(pur_status IN ('구매대기중', '구매중', '구매완료',
												'배송대기중', '배송중', '배송완료'))
											DEFAULT '구매대기중' -- 구매 상태
); -- 구매 내역

CREATE TABLE delivery(
	deli_code INT AUTO_INCREMENT PRIMARY KEY,
    pur_code INT, -- 구매 코드
    deli_date DATE DEFAULT(current_date), -- 배송 날짜
    delicompany VARCHAR(30), -- 배송사
    deli_cost INT, -- 배송비
    deli_addr VARCHAR(100) -- 배송 주소
);	-- 배송

CREATE TABLE swap(
	pur_code INT AUTO_INCREMENT PRIMARY KEY, -- 구매코드
	id VARCHAR(50), -- 아이디
    prod_code INT, -- 상품 코드
    reason TEXT, -- 사유
    swap_date DATE DEFAULT(current_date), -- 날짜
    price INT, -- 비용
    swap_status char(2) CHECK(swap_status IN ('교환', '반품')) -- 교환/반품
); -- 교환/반품

CREATE TABLE coupon(
	coupon_code INT AUTO_INCREMENT PRIMARY KEY, -- 쿠폰 코드
	coupon_name VARCHAR(30), -- 쿠폰명
    expire_date DATE DEFAULT(current_date), -- 사용기한
    id VARCHAR(50), -- 아이디
    prod_code INT -- 상품 코드
); -- 쿠폰

CREATE TABLE choice(
	choi_code INT AUTO_INCREMENT PRIMARY KEY,
	prod_code INT, -- 상품 코드
    choi_name VARCHAR(30)
); -- 옵션

ALTER TABLE category 
ADD FOREIGN KEY (parent_code) REFERENCES category(cate_code);

ALTER TABLE product
ADD FOREIGN KEY (ente_id) REFERENCES enterprise(ente_id);

ALTER TABLE product
ADD FOREIGN KEY (cate_code) REFERENCES category(cate_code);

ALTER TABLE pick
ADD FOREIGN KEY (id) REFERENCES customer(id);

ALTER TABLE pick
ADD FOREIGN KEY (prod_code) REFERENCES product(prod_code);

ALTER TABLE review
ADD FOREIGN KEY (id) REFERENCES customer(id);

ALTER TABLE review
ADD FOREIGN KEY (prod_code) REFERENCES product(prod_code);

ALTER TABLE purchase
ADD FOREIGN KEY (id) REFERENCES customer(id);

ALTER TABLE purchase
ADD FOREIGN KEY (prod_code) REFERENCES product(prod_code);

ALTER TABLE delivery
ADD FOREIGN KEY (pur_code) REFERENCES purchase(pur_code);

ALTER TABLE swap
ADD FOREIGN KEY (id) REFERENCES customer(id);

ALTER TABLE swap
ADD FOREIGN KEY (prod_code) REFERENCES product(prod_code);

ALTER TABLE coupon
ADD FOREIGN KEY (id) REFERENCES customer(id);

ALTER TABLE coupon
ADD FOREIGN KEY (prod_code) REFERENCES product(prod_code);

ALTER TABLE choice
ADD FOREIGN KEY (prod_code) REFERENCES product(prod_code);


