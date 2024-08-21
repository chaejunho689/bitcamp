/*
[문제 1] 기말고사 과목별 평균이 높은 3과목을 검색하시오
테이블 : COURSE, SCORE
컬럼 : ROWNUM, CNO, CNAME, RESULT

[문제 2] 4.5 환산 평점이 가장 높은 3인의 학생을 검색하시오.
테이블 : STUDENT
컬럼 : RN, SNO, SNAME, AVR

[문제 3] 기말고사 평균이 60점 이상인 학생의 정보를 검색하시오
         평균은 반올림하여 소수이하 둘째자리까지 출력하시오
테이블 : STUDENT, SCORE
컬럼 : SNO, SNAME, RESULT

[문제 4] 기말고사 평균 성적이 핵 화학과목보다 우수한 과목의 과목명과 담당 교수명을 검색하시오
테이블 : COURSE, SCORE, PROFESSOR
컬럼 : CNO, CNAME, RESULT, PNO, PNAME
*/

SELECT * FROM SCORE;
SELECT * FROM COURSE;
  
--문제1
SELECT 
    S.CNO, C.CNAME, AVG_RESULT 
FROM 
    (SELECT CNO, AVG(RESULT) AS AVG_RESULT
    FROM SCORE S
    GROUP BY CNO
    ORDER BY AVG_RESULT DESC) S
JOIN COURSE C
ON S.CNO = C.CNO
WHERE ROWNUM <= 3
ORDER BY AVG_RESULT DESC
                                                                                                                            
--문제2 
SELECT * 
FROM (SELECT SNO, SNAME, (AVR/4)*4.5 AS 환산점수
    FROM STUDENT)
WHERE ROWNUM <= 3
ORDER BY 환산점수 DESC
 