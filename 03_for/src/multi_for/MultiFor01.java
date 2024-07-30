package multi_for;

public class MultiFor01 {
	public static void main(String[] args) {
		int i;
		int j;
		
		for(i = 1; i <= 3; i += 1) {
			for(j = 1; j <= 3; j++) {
				System.out.println("i = " + i + "   j = " + j);
			}
			System.out.println();
		}
		
	}
}
/* 다중 for문
i = 1   j = 1
i = 1   j = 2
i = 1   j = 3

i = 2   j = 1
i = 2   j = 2
i = 2   j = 3

i = 3   j = 1
i = 3   j = 2
i = 3   j = 3
*/