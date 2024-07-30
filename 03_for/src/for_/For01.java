package for_;

public class For01 {
	public static void main(String[] args) {
		for(int i = 1; i <= 5; i++) {
			System.out.println("Hello I World" + i);
		}
	
		// System.out.println("탈출 i = " + i); (X) 
		// -> { for 문 } 안의 i는 { for 문 }
		// 안에서만 유효하다.
		
		int j;
		for(j = 1; j <= 5; j++) {
			System.out.println("Hello J World" + j);
		}
		 System.out.println("탈출 j = " + j);
		//지역 변수를 설정하여 for문 바깥에서도 사용할 수 있다.

		 
		int k;
		for(k = 65; k <= 90; k++) {
			System.out.print((char)k + " ");
		} 
		// A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
	}
}
