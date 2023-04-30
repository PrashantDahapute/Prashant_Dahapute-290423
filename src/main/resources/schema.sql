CREATE TABLE customer (
	id INT NOT NULL PRIMARY KEY,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL
);

CREATE TABLE mobile_number (
	id INT  auto_increment,
	mobile_number VARCHAR(15) NOT NULL,
	custid BIGINT NOT NULL,
	CONSTRAINT mobile_number_customer_fk FOREIGN KEY (custid) REFERENCES customer(id)
);
