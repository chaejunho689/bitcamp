CREATE OR REPLACE PROCEDURE PRO_NOPARAM
IS
    NAME    VARCHAR2(10);
    AGE     NUMBER(4) := 25;
BEGIN
    NAME := '홍길동';
    DBMS_OUTPUT.PUT_LINE('NAME : ' || NAME);
    DBMS_OUTPUT.PUT_LINE('AGE : ' || AGE);
END PRO_NOPARAM;
/

EXECUTE PRO_NOPARAM;

BEGIN
    PRO_NOPARAM;
END;
/

SELECT * FROM USER_SOURCE WHERE NAME = 'PRO_NOPARAM';
DROP PROCEDURE PRO_NOAPARAM; 

CREATE OR REPLACE PROCEDURE PRO_PARAM_IN
(
    NAME    IN VARCHAR2,
    AGE     NUMBER,
    PHONE   VARCHAR2 := '010-1234-5678',
    ADDR    VARCHAR2 DEFAULT '서울'
)
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('NAME : ' || NAME);
    DBMS_OUTPUT.PUT_LINE('AGE : ' || AGE);
    DBMS_OUTPUT.PUT_LINE('PHONE : ' || PHONE);
    DBMS_OUTPUT.PUT_LINE('ADDR : ' || ADDR);
END PRO_PARAM_IN;
/

EXECUTE PRO_PARAM_IN('홍길동', '010-1111-1111', '부산');


CREATE OR REPLACE PROCEDURE PRO_PARAM_OUT
(
    EMPNO IN EMPLOYEES.EMPLOYEE_ID%TYPE,
    EMPNAME OUT EMPLOYEES.LAST_NAME%TYPE,
    SAL OUT EMPLOYEES.SALARY%TYPE
)
IS
BEGIN
    SELECT LAST_NAME, SALARY 
    INTO EMPNAME, SAL 
    FROM EMPLOYEES 
    WHERE EMPLOYEE_ID = EMPNO;
END PRO_PARAM_OUT;
/



CREATE OR REPLACE PROCEDURE PRO_PARAM_INOUT
(
    NUM IN OUT NUMBER
)
IS
BEGIN
    NUM := NUM * 2;
END PRO_PARAM_INOUT;
/


DECLARE
    NUM NUMBER;
BEGIN
    NUM := 5;
    PRO_PARAM_INOUT(NUM);
    DBMS_OUTPUT.PUT_LINE('NUM : ' || NUM);
END;
/




CREATE OR REPLACE PROCEDURE PRO_SUM
(
    X IN NUMBER,
    Y IN NUMBER,
    SUM_RESULT OUT NUMBER
)
IS
BEGIN
    SUM_RESULT := X + Y;
END PRO_SUM;
/


CREATE OR REPLACE PROCEDURE PRO_FACTORY
(
    X IN NUMBER,
    Y IN NUMBER,
    MUL OUT NUMBER
)
IS
BEGIN
    MUL := 1;
    FOR i IN 1..Y LOOP
        MUL := MUL * X;
    END LOOP;
END PRO_FACTORY;
/

DECLARE
    SUM_RESULT NUMBER;
    X NUMBER := 2;
    Y NUMBER := 5;
    MUL NUMBER;
BEGIN
    PRO_SUM(X,Y, SUM_RESULT);
    PRO_FACTORY(X, Y, MUL);
    DBMS_OUTPUT.PUT_LINE('25 + 36 = ' || SUM_RESULT) ;
    DBMS_OUTPUT.PUT_LINE(X || ' ^ ' || Y || ' = '|| MUL);
END;
/



CREATE OR REPLACE FUNCTION FUNC_TAX
(
    SALARY IN NUMBER
)
RETURN NUMBER
IS
    TAX NUMBER := 0.033;
BEGIN
    RETURN (ROUND(SALARY - (SALARY * TAX)));
END FUNC_TAX;
/



CREATE TABLE EMP_TAB AS SELECT * FROM EMPLOYEES;
SELECT * FROM EMP_TAB;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMPLOYEES';

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP_TAB';


CREATE OR REPLACE TRIGGER TRI_EMP_WEEKEND
BEFORE
INSERT OR UPDATE OR DELETE ON EMP_TAB
BEGIN
    IF TO_CHAR(SYSDATE,'DY') IN ('토', '일') THEN
        IF INSERTING THEN
            RAISE_APPLICATION_ERROR(- 20000, '주말 사원정보 추가 불가');
        ELSIF UPDATING THEN
            RAISE_APPLICATION_ERROR(- 20000, '주말 사원정보 수정 불가');
        ELSIF DELETING THEN
            RAISE_APPLICATION_ERROR(- 20000, '주말 사원정보 삭제 불가');
        ELSE
            RAISE_APPLICATION_ERROR(- 20000, '주말 사원정보 변경 불가');
        END IF;
    END IF;
END;
/
 

SELECT * FROM EMP_TAB;

UPDATE EMP_TAB SET SALARY = 24000 WHERE EMPLOYEE_ID = 100;

INSERT INTO EMP_TAB(EMPLOYEE_ID, EMAIL, SALARY)
VALUES(100, 'HONG_', 25000);


DELETE EMP_TAB WHERE EMPLOYEE_ID = 100;


CREATE TABLE EMP_TAB_LOG(
    TABLENAME VARCHAR2(10),
    DML_TYPE VARCHAR2(10),
    EMPNO NUMBER(4),
    EMPNAME VARCHAR2(30),
    CHANGE_DATE DATE
);

SELECT * FROM EMP_TAB_LOG;

CREATE OR REPLACE TRIGGER TRI_EMP_LOG
AFTER
INSERT OR UPDATE OR DELETE ON EMP_TAB
FOR EACH ROW 

BEGIN
    IF INSERTING THEN
        INSERT INTO EMP_TAB_LOG
        VALUES ('EMP_TAB',
                'INSERT',
                :NEW.EMPLOYEE_ID,
                SYS_CONTEXT('USERENV', 'SESSION_USER'),
                SYSDATE);
    ELSIF UPDATING THEN
        INSERT INTO EMP_TAB_LOG
        VALUES ('EMP_TAB',
                'UPDATE',
                :OLD.EMPLOYEE_ID,
                SYS_CONTEXT('USERENV', 'SESSION_USER'),
                SYSDATE);
    ELSIF DELETING THEN
        INSERT INTO EMP_TAB_LOG
        VALUES ('EMP_TAB',
                'DELETE',
                :OLD.EMPLOYEE_ID,
                SYS_CONTEXT('USERENV', 'SESSION_USER'),
                SYSDATE);
    END IF;
END;

INSERT INTO EMP_TAB(EMPLOYEE_ID, LAST_NAME, EMAIL, JOB_ID, HIRE_DATE)
VALUES (9999, 'Test', 'Test', 'Test', SYSDATE);