package multi_for;

public class MultiFor02 {
	public static void main(String[] args) {
		int dan, j;
		
		for(dan = 2; dan <= 9; dan++) {
			for(j = 1; j <= 9; j++) {
				System.out.println(dan + " x " + j + " = " + dan * j);
			}
		}
	}
}
/*
2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
. . . . . 
9 x 5 = 45
9 x 6 = 54
9 x 7 = 63
9 x 8 = 72
9 x 9 = 81
*/