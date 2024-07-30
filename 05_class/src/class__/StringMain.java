package class__;

public class StringMain {
	public StringMain() {
		String aa = "apple";
		String bb = "apple";
		if(aa == bb) {
			System.out.println("aa와 bb의 참조값은 같다.");
		} else {
			System.out.println("aa와 bb의 참조값은 다르다.");
		}
		
		System.out.println();
		if(aa.equals(bb)) {
			System.out.println("aa와 bb의 문자열은 같다.");
		} else {
			System.out.println("aa와 bb의 문자열은 다르다.");
		}
		System.out.println();
		
		
		String cc = "apple";
		String dd = "apple";
		System.out.println();
		if(cc == dd) {
			System.out.println("cc와 dd의 참조값은 같다.");
		} else {
			System.out.println("cc와 dd의 참조값은 다르다.");
		}
		
		if(cc.equals(dd)) {
			System.out.println("cc와 dd의 문자열은 같다.");
		} else {
			System.out.println("cc와 dd의 문자열은 다르다.");
		}
		
		String e = "오늘 날짜는 " + 2023 + 12 + 29;
		System.out.println("e = " + e);
		
		/*
		메모리가 곽 차서 더 생성이 안된다.
		-> JVM에 의해서 휴지통으로 이동한다.
		-> JVM에 의해서 휴지통으로 보내는 동안은 컴퓨터는 작동을 멈춘다
		-> 
		*/ 
		
		System.out.println("문자열 크기 = " + e.length());

		System.out.println("5번째 위치의 문자 = " + e.charAt(5)); //는

		System.out.println("부분 문자밀 추출 = " + e.substring(7));
		System.out.println("부분 문자멀 추출 = " + e.substring(7,11));

		System.out.println("대문자 변경 = " + "Hello".toUpperCase());
		System.out.println("소문자 변경 = " + "Hello".toLowerCase());

		System.out.println("문자열 검색 = " + e.indexOf("짜"));
		System.out.println("문자열 검색 = " + e.indexOf("날짜"));
		System.out.println("문자열 검색 = " + e.indexOf("개바부"));//-1
		System.out.println("문자열 치환 = " + e.replace("날짜", "일자"));
	}
	
	public static void main(String[] args) {
		new StringMain();
	}
}
