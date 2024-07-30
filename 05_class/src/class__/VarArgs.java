package class__;

public class VarArgs {
	
	/*
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int sum(int a, int b, int c) {
		return a+b+c;
	}
	
	public int sum(int a, int b, int c, int d) {
		return a+b+c+d;
	}
	
	 -> 같은 이름의 메소드 인수 개수를 자유롭게 하는것이 더 편리
	 */
	
	// 인수 개수를 자유롭게 하는 방법 내부적으로 배열로 인식함.
	public int sum(int... ar) {
		int hap = 0;
		for(int i = 0; i < ar.length; i++) {
			hap += ar[i];
		}
		return hap;
	}
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		
		System.out.println("10 + 20 = " + va.sum(10, 20) );
		System.out.println("10 + 20 + 30 = " + va.sum(10, 20, 30) );
		System.out.println("10 + 20 + 30 + 40 = " + va.sum(10, 20, 30, 40) );

	}
}
