--oracle
create table MEMBER(
name varchar2(15) not null,
id varchar2(30) primary key ,
pwd varchar2(50) not null,
phone varchar(20) unique);