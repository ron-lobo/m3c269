#create database c269db;
show databases;
use c269db;
show tables;

DROP TABLE if exists carReg;
DROP TABLE if exists employeeDepartment;

CREATE OR REPLACE TABLE department (
	id					INT						PRIMARY KEY		auto_increment,
	NAME				VARCHAR(40),
	deptHead			VARCHAR(30)
	#secretary		INT,
	#phoneNum
);

create or replace table employee (
    id					int					PRIMARY KEY		auto_increment,
	 NAME					varchar(30)			not null,
    postcode			char(8),
    houseNumber		int,
    phoneNumber		varchar(20)			unique,
    salary				double,
    title         	enum("Associate", "AVP", "VP", "EVP", "SVP", "MD", "CEO"),
    isAvailable		BOOLEAN
);

create or replace TABLE exEmployee (
    id					int					PRIMARY KEY		auto_increment,
	 NAME					varchar(30)			not null,
    salary				double,
    title         	enum("Associate", "AVP", "VP", "EVP", "SVP", "MD", "CEO"),
    endDate				date
);


CREATE or replace TABLE carReg (
	employeeId			INT,
	carReg				CHAR(8)				unique,
   constraint fk_carReg_employeeId FOREIGN KEY (employeeId) REFERENCES employee(id),
   PRIMARY KEY (employeeId, carReg)
);

CREATE OR REPLACE TABLE employeeDepartment (
		deptId				INT,
		employeeId			INT,
    	constraint fk_employeeDepartment_deptId FOREIGN KEY (deptId) REFERENCES department(id),
    	constraint fk_employeeDepartment_employeeId FOREIGN KEY (employeeId) REFERENCES employee(id),
   	PRIMARY KEY (employeeId, deptId)
);



CREATE OR REPLACE TABLE trade (
   id					int					PRIMARY KEY		auto_increment,
	customer			VARCHAR(100),
	side				ENUM('Buy', 'Sell'),
	qty				INT,
	symbol			CHAR(8),
	price				DECIMAL(8,2)
);
