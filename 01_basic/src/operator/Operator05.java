package operator;

public class Operator05 {
	public static void main(String[] args) {
		boolean a = 25 > 36;
		
		System.out.println("a = " + a); // a = false
		System.out.println("!a = " + !a); // !a = true
		
		String b = "apple";
		String c = "apple";
		String d = new String("apple");
		
		System.out.println("b == c = " + (b == c ? "같다" : "다르다")); //주소 비교
		System.out.println("b == c = " + (b == d ? "같다" : "다르다")); //주소 비교
		
		System.out.println("(b.equals(c) = " + (b.equals(c) ? "같다" : "다르다")); //주소 비교
		System.out.println("(b.equals(d) = " + (b.equals(d) ? "같다" : "다르다")); //주소 비교

	}
}
