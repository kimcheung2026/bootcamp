CREATE TABLE Regions (
    region_name VARCHAR(25) NOT NULL,
    Region_ID INT NOT NULL,
    PRIMARY KEY (Region_ID)
);
show create table Regions ;

CREATE TABLE Countries (
    Country_ID CHAR(2) NOT NULL,
    Country_name VARCHAR(40) NOT NULL,
    Region_ID INT,
    PRIMARY KEY (Country_ID),
    FOREIGN KEY (Region_ID)
        REFERENCES Regions (Region_ID)
);

CREATE TABLE locations (
    Location_ID INT NOT NULL,
    Street_Address VARCHAR(25) NOT NULL,
    Postal_Code VARCHAR(12) NOT NULL,
    City VARCHAR(30) NOT NULL,
    State_Province VARCHAR(12) NOT NULL,
    Country_ID CHAR,
    PRIMARY KEY (location_ID),
    FOREIGN KEY (Country_ID)
        REFERENCES Countries (Country_ID)
);

--base on ERROR
ALTER TABLE locations DROP FOREIGN KEY locations_ibfk_1;  
ALTER TABLE locations MODIFY Country_ID CHAR(2) NOT NULL;

ALTER TABLE locations 
ADD CONSTRAINT fk_loc_country 
FOREIGN KEY (Country_ID) REFERENCES Countries(Country_ID);

CREATE TABLE departments (
    Department_ID INT NOT NULL,
    Department_Name VARCHAR(30) NOT NULL,
    Manager_ID INT NOT NULL,
    Location_ID INT,
    PRIMARY KEY (Department_ID),
    FOREIGN KEY (Location_ID)
        REFERENCES locations (Location_ID)
);
show tables;

CREATE TABLE employees1 (
    Employee_ID INT NOT NULL,
    Fisrt_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    Email VARCHAR(25) NOT NULL,
    Phone_number VARCHAR(20) NOT NULL,
    Hire_Date DATE NOT NULL,
    job_ID VARCHAR(10) NOT NULL,
    Salary INT NOT NULL,
    commission_Pct INT NOT NULL,
    Manager_ID INT NOT NULL,
    Department_ID INT,
    PRIMARY KEY (Employee_ID),
    FOREIGN KEY (Department_ID)
        REFERENCES departments (Department_ID)
);



CREATE TABLE job_history (
    Employee_ID INT NOT NULL,
    Start_Date DATE NOT NULL,
    End_date DATE NOT NULL,
    Job_ID VARCHAR(10),
    Department_ID INT,
    PRIMARY KEY (Employee_ID, Start_Date),
    FOREIGN KEY (Department_ID)
        REFERENCES departments (Department_ID),
    FOREIGN KEY (Employee_ID)
        REFERENCES employees1 (Employee_ID),
    FOREIGN KEY (Job_ID)
        REFERENCES jobs (Job_ID)
);

CREATE TABLE jobs (
    Job_ID VARCHAR(10) NOT NULL,
    Job_Title VARCHAR(35) NOT NULL,
    Min_Salary INT NOT NULL,
    Max_salary INT NOT NULL,
    PRIMARY KEY (Job_ID)
);

INSERT INTO regions (Region_ID, Region_Name) VALUES 
(1, 'Europe'),
(2, 'Americas'),
(3, 'Asia');

INSERT INTO countries (Country_ID, Country_Name, Region_ID) VALUES 
('UK', 'United Kingdom', 1),
('US', 'United States of America', 2),
('HK', 'Hong Kong', 3);

INSERT INTO locations (Location_ID, Street_Address, Postal_Code, City, State_Province, Country_ID) VALUES 
(1000, '123 Pall Mall', 'SW1 5WH', 'London', 'London', 'UK'),
(1100, '2005 North 2nd Street', '95122', 'South SF', 'California', 'US'),
(1200, '1 Garden Road', '00000', 'Central', 'Hong Kong', 'HK');

INSERT INTO departments (Department_ID, Department_Name, Location_ID) VALUES 
(10, 'Administration', 1100),
(20, 'Marketing', 1200),
(30, 'Purchasing', 1100),
(40, 'Human Resources', 1200),
(50, 'Shipping', 1000),
(60, 'IT', 1200);

ALTER TABLE departments MODIFY Manager_ID INT NULL;

INSERT INTO jobs (Job_ID, Job_Title, Min_Salary, Max_Salary) VALUES 
('AD_PRES', 'President', 20000, 40000),
('AD_VP', 'Administration Vice President', 15000, 30000),
('IT_PROG', 'Programmer', 4000, 10000),
('SA_REP', 'Sales Representative', 6000, 12000),
('ST_CLERK', 'Stock Clerk', 2000, 5000);

INSERT INTO employees1 (
    Employee_ID, First_name, Last_name, Email, Phone_number, 
    Hire_Date, Job_ID, Salary, Commission_Pct, Manager_ID, Department_ID
) VALUES 
(100, 'Steven', 'King', 'SKING', '515.123.4567', '2003-06-17', 'AD_PRES', 24000, 0, 0, 10),
(101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '2005-09-21', 'AD_VP', 17000, 0, 100, 10),
(102, 'Lex', 'De Haan', 'LDEHAAN', '515.123.4569', '2001-01-13', 'AD_VP', 17000, 0, 100, 10),
(103, 'Alexander', 'Hunold', 'AHUNOLD', '590.423.4567', '2006-01-03', 'IT_PROG', 9000, 0, 102, 60),
(104, 'Bruce', 'Ernst', 'BERNST', '590.423.4568', '2007-05-21', 'IT_PROG', 6000, 0, 103, 60);

ALTER TABLE employees1 CHANGE Fisrt_name First_name VARCHAR(20) NOT NULL;

INSERT INTO job_history (
    Employee_ID, 
    Start_Date, 
    End_date, 
    Job_ID, 
    Department_ID
) VALUES 
(101, '1997-09-21', '2001-10-27', 'IT_PROG', 60),
(101, '2001-10-28', '2005-03-15', 'SA_REP', 20),
(102, '2001-01-13', '2006-07-24', 'IT_PROG', 60),
(103, '2006-03-24', '2007-12-31', 'ST_CLERK', 50);


SELECT 
    l.location_id, 
    l.street_address, 
    l.city, 
    l.state_province, 
    c.country_name
FROM 
    locations l
JOIN 
    countries c ON l.country_id = c.country_id;



