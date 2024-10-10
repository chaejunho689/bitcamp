[테이블]
create table guestbook(
seq number primary key, -- 시퀀스 객체로부터 값을 얻어온다
name varchar2(30),
email varchar2(30),
homepage varchar2(35),
subject varchar2(500) not null,
content varchar2(4000) not null,
logtime date);
[시퀀스]
create sequence seq_guestbook nocycle nocache;


select * from guestbook order by logtime;


SELECT * FROM(
SELECT ROWNUM RN, TT.* FROM( 
SELECT SEQ, NAME, EMAIL, HOMEPAGE, SUBJECT, CONTENT, LOGTIME FROM GUESTBOOK ORDER BY LOGTIME
) TT
) WHERE RN >= 1 AND RN <= 3;

commit;