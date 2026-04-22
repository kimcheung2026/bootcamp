
--Create Database
create database bootcamp_2603;


use bootcamp_2603;
--Create Table
create table employees (
id integer,
first_name varchar(50),
last_name varchar(50),
dob date,
salary decimal(7,2),
gender varchar(1)
);
drop table employees;
--No column sequence
--Case Insensitive by default ( Table name, column name

--Vaulue -> by default Case sensitive (postgreSQL)
--Value -> by default case Insensitive (MYSQL)
select * from employees;
delete from employees;

insert into employees (id, first_name, last_name, dob, salary, gender)
    values(1, 'John', 'Lau', '2001-12-31', 23000.5, 'M');
insert into employees (id, first_name, last_name, dob, salary, gender)
    values(2, 'Sally', 'Lau', '2000-04-30', 30000, 'F');
insert into employees (id, first_name, last_name, dob, salary, gender)
    values(3, 'Leo', 'Chan', '1980-01-30', 28000, 'M');
insert into employees (id, first_name, last_name, dob, salary, gender)
    values(4, 'Jenny', 'Chan', '1990-02-28', 19000, 'F');
insert into employees (id, first_name, last_name, dob, salary, gender)
    values(5, 'Oscar', 'Tam', '1993-04-10', 21000, 'M');
    
    

