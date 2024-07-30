package while_;

public class While01 {
	public static void main(String[] args) {
		int a = 0;
		int i = 1;

		while(a <= 10) {
			a++;
			System.out.println(a + " ");
		}
		
		int b = 1;
		while(true) {
			System.out.println(b + " ");
			b++;
			
			if(b > 10) break;
		}
	}
}
