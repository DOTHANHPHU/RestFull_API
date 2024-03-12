create database employees;
use employees;

create table employee(
	empId bigint not null primary key auto_increment,
    empNo varchar(10),
    empName varchar(50)
);

drop table employee;

insert into employee (empNo, empName) values ('EM001', 'TEST 1');
insert into employee (empNo, empName) values ('EM002', 'TEST 2');
insert into employee (empNo, empName) values ('EM003', 'TEST 3');
