package basic;

public class Variable2 {
	int c; // 필드, 이미 초기화 되어 있음.
	static int b; // 필드

	public static void main(String[] args) {
		int a = 100; // Local variable 지역 변수, garbage 값이 들어감, 초기화를 해줘야 함.
		System.out.println(a);
		
		//int a; --> 중복 선언으로 인하여 오류가 발생한다.
		

//		System.out.println("필드 = " + c); // error occured. non-static field..
		System.out.println("필드 = " + new Variable2().c); // 해당 클래스를 호출했으므로 사용 가능
		System.out.println("필드 = " + b);
	}
}
