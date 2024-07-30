package multiArray;

public class MultiArray05 {
	public static void main(String[] args) {
		// 다차원 배열 - 가변길이 
		int[][] ar = new int[3][];
		ar[0] = new int[2];
		ar[1] = new int[3];
		ar[2] = new int[4];

		
		ar[0][0] = 10;
		
		
		// 출력
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < ar[i].length; j++) {
				System.out.println("ar[" + i + "][" + j + "] = " + ar[i][j]);
			}
		}
	}
}

