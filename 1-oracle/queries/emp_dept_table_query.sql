create table departments(
department_id int generated always as identity (start with 100 INCREMENT by 1)  primary key,
 department_name varchar2(100) not null,
 employee_count int default 0
);

create table employees(
employee_id int
generated always as identity (start with 100 increment by 1) 
primary key,
employee_name varchar2(50) not null,
employee_salary number(18,2) default 0,
department_id int references departments(department_id) not null
);

insert into departments(department_name) values('HR'); 
insert into departments(department_name) values('EDU'); 

insert into employees(employee_name,employee_salary,department_id) values('anil',1000.00,100);
insert into employees(employee_name,employee_salary,department_id) values('sunil',2000.00,101);
insert into employees(employee_name,employee_salary,department_id) values('joydip',3000.00,100);
insert into employees(employee_name,employee_salary,department_id) values('vinod',4000.00,100);
insert into employees(employee_name,employee_salary,department_id) values('mahesh',5000.00,100);

select * from departments;
select * from employees;

disable increase_employee_count_trigger;
update departments set  employee_count=2 where department_id=100;
update employees set department_id=101 where employee_id=104;
delete from employees where employee_id=104;
