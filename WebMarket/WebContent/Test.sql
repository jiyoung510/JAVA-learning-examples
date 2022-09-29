desc product;
desc member;
desc board;
desc cart;


CREATE TABLE IF NOT EXISTS product(
	p_id VARCHAR(10) NOT NULL,
	p_name VARCHAR(20),
	p_unitPrice  INTEGER,
	p_description TEXT,
   	p_category VARCHAR(20),
	p_manufacturer VARCHAR(20),
	p_unitsInStock LONG,
	p_condition VARCHAR(20),
	p_fileName  VARCHAR(20),
	PRIMARY KEY (p_id)
)default CHARSET=utf8;

desc product;
SELECT * FROM product;
select * from member;
select * from cart;

delete from cart where c_id=2;

SELECT C.*, P.p_name, P.p_unitPrice, P.p_unitsInStock FROM Product P INNER JOIN cart C ON P.p_id=C.p_id  WHERE id='kkw';