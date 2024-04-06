create database student;
use student;
create table st_en_form(
serial int auto_increment primary key,
id int ,
name varchar(24),
level varchar(5),
semester varchar(5),
depart varchar(20),
degree varchar(20),
pass varchar(20),
con_pass varchar(20),
seat_no int,
Time varchar(30),
Date varchar(30)
);

create table library_form(
serial int auto_increment primary key,
id int ,
name varchar(24),
level varchar(5),
semester varchar(5),
depart varchar(20),
degree varchar(20),
pass varchar(20),
con_pass varchar(20),
seat_no int,
Time varchar(30),
Date varchar(30),
Exit_time varchar(30),
Exit_date varchar(30)
);
create table Registerform(

Id int primary key,
Name varchar(24),
Level varchar(11),
Semester varchar(20),
Department varchar(20),
Degree varchar(20),
Password varchar(20),
ConPassword varchar(20)

);
select *from st_en_form;
select * from library_form ;
select *from RegisterForm;
select id,pass from st_en_form where id=2002005;
delete from st_en_form where id=2002005;

update library_form
set Exit_time=" ",Exit_date=" "
where id=2002005 ;
drop database student;
drop database Registerform;