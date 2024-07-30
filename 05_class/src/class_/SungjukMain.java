package class_;

public class SungjukMain {
	public static void main(String[] args) {
		Sungjuk aa = new Sungjuk();
		aa.setData("윈터", 100, 89, 53);
		aa.calc();
		System.out.println(
				  aa.getName() + "\t"
				+ aa.getKor() + "\t"
				+ aa.getEng() + "\t"
				+ aa.getMath() + "\t"
				+ aa.getTot() + "\t"
				+ String.format("%.2f", aa.getAvg()) + "\t"
				+ aa.getGrade() + "\t"
				);
	}
}

/*
[문제] 성적처리
- 총점, 평균, 학점을 구하시오.
- 평균은 소수이하 2째자리까지 처리한다.

클래스명 : SungJuk
필드 : name, kor, eng, math, tot, avg, grade
메소드 : setData(이름, 국어, 영어, 수학)
       calc() - 총점, 평균, 학점 계산
   getName()
   getKor()
   getEng()
   getMath()
       getTot()
       getAvg()
       getGrade()

클래스명 : SungJukMain

[실행결과]
----------------------------------------------------
이름 국어 영어 수학 총점 평균 학점
----------------------------------------------------
홍길동 90 96 100
*/