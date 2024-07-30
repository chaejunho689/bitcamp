package multiArray;

public class MultiArray01 {
	public static void main(String[] args) {
		int[][] ar;
		ar = new int[3][2];
		
		ar[0][0] = 10;
		ar[0][1] = 20;

		ar[1][0] = 30;
		ar[1][1] = 40;

		ar[2][0] = 50;
		ar[2][1] = 60;
		
		System.out.println("배열명 ar = " + ar);
		for(int i = 0; i < ar.length; i++) {
			System.out.println("ar[" + i + "]= " + ar[i]);
			for(int j = 0; j < 2; j++) {
				System.out.println("ar[" + i + "][" + j + "] = " + ar[i][j]);
			}
			System.out.println();
		}
	}
}
