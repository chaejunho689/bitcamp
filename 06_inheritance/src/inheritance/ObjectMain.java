package inheritance;

class Test {
	@Override
	public String toString() {
		return getClass() + "@오버라이드";
	}
}

public class ObjectMain {
	public static void main(String[] args) {
		Test test = new Test();
		System.out.println("객체 test = " + test); 
		System.out.println("객체 test = " + test.toString());  // 클래스@16진수 주소
		System.out.println("객체 test = " + test.hashCode()); //10진수
		
		String str = "apple";
		System.out.println("객체 str = " + str); // 클래스@16진수 -> 스트링문자열로
		System.out.println("객체 str = " + str.toString()); // 클래스@16진수 -> 스트링문자열로
		System.out.println("객체 str = " + str.hashCode()); // 클래스@16진수 -> 스트링문자열로
		
		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println("aa==bb + " + aa==bb);
		System.out.println("aa.equals)(bb)  : " + aa.equals(bb));

		String cc = new String("apple");
		String dd = new String("apple");
		System.out.println("cc==dd + " + (cc==dd));
		System.out.println("cc.equals)(dd)  : " + cc.equals(dd));
		
		String ee = new String("apple");
		String ff = new String("apple");
		System.out.println("ee==ff" + (ee==ff));
		System.out.println("ee.equals)(ff)  : " + ee.equals(ff));


	}
		
}
