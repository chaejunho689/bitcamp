package multiArray;

public class MultiArray03 {
	public static void main(String[] args) {
		int[][] ar = {{1,2,3,0},{4,5,6,0},{7,8,9,0},{0,0,0,0}};
		
//		// 출력
//		for(int i = 0; i < ar.length; i++) {
//			for(int j = 0; j < ar[i].length; j++) {
////				System.out.println("ar[" + i + "][" + j + "] = " + ar[i][j]);
//				System.out.print(String.format("%5d", ar[i][j]));
//			}
//			System.out.println();
//		}

		
		// 계산
		for(int i = 0; i < ar.length-1; i++) {
			for(int j = 0; j < ar[i].length -1; j++) {
				ar[i][3] += ar[i][j];
				ar[3][j] += ar[i][j];
				ar[3][3] += ar[i][j];
			}
			System.out.println();
		}
		
		// 출력
		for(int i = 0; i < ar.length-1; i++) {
			for(int j = 0; j < ar[i].length-1; j++) {
				ar[i][ar.length-1] += ar[i][j];
				System.out.print(String.format("%5d", ar[i][j]));
			}
			System.out.println();
		}
		
		
	}
}
