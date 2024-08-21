--ex1) 테이블 : test
create table test(
id number(5),
name char(10),
address varchar2(50));


--ex2) 테이블 : user1
create table user1(
idx number primary key,
id varchar2(10) unique,
name varchar2(10) not null,
phone varchar2(15),
address varchar2(50),
score number(6,2) check(score >= 0 and score <= 100),
subject_code number(5),
hire_date date default sysdate,
marriage char(1) default 'N' check(marriage in('Y', 'N')));

--ex3) 제약조건 확인
select constraint_name, constraint_type
from user_constraints
where table_name='USER1';
select *
from user_constraints
where table_name='USER1';

--ex4) 테이블
create table user2(
idx number constraint PKIDX primary key,
id varchar2(10) constraint UNID unique,
name varchar2(10) constraint NOTNAME not null,
phone varchar2(15),
address varchar2(50),
score number(6,2) constraint CKSCORE check(score >= 0 and score <= 100),
subject_code number(5),
hire_date date default sysdate,
marriage char(1) default 'N' constraint CKMARR check(marriage in('Y','N')));

--ex5) 제약조건 확인
select constraint_name, constraint_type
from user_constraints
where table_name='USER2';
select *
from user_constraints
where table_name='USER2';


insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(1,'aaa','kim','010-000-0000','서울',75,100,'2010-08-01','Y');
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(1,'aaa','kim','010-000-0000','서울',75,100,'2010-08-01','Y');
--→ 무결성제약조건에 위배(이유: idx 1 중복)
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(2,'aaa','kim','010-000-0000','서울',75,100,'2010-08-01','Y');
--→ 무결성제약조건에 위배(이유: id aaa 중복)
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(2,'bbb','','010-000-0000','서울',75,100,'2010-08-01','Y');
--→ NULL을 ("HR"."USER1"."NAME") 안에 삽입할 수 없습니다
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(2,'bbb','lee','010-000-0000','서울',120,100,'2010-08-01','Y');
--→ 체크 제약조건에 위배되었습니다(이유: score가 0~100사이의 수 이어야함)
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(2,'bbb','lee','010-000-0000','서울',75,100,'2010-08-01','K');
--→ 체크 제약조건에 위배되었습니다(이유 : marriage가 Y 또는 N 이어야함)
insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(2,'bbb','lee','010-000-0000','서울',75,100,'2010-08-01','N');
--ex7) 테이블