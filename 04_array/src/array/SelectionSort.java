package array;

public class SelectionSort {
	public static void main(String[] args) {

		/* ERROR: 	배열을 선언하고 데이터 크기를 결정하는 것은 불가, 
		 			선언하면서 동시에 크기를 결정하는 것은 가능.
		int[] ar; 
		ar = {25, 36, 30, 45, 28};
		*/
		
		int[] ar = {25, 36, 30, 45, 28};
		

		System.out.println("정렬 전");
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + "  ");
		}
		System.out.println();
		
		
		// Selection Sort
		int temp;
		for(int i = 0; i < ar.length - 1; i++) {
			for(int j = i + 1; j < ar.length; j++) {
				if(ar[i] > ar[j]) { // 부등호 방향으로 오름차순, 내림차순 정렬 가능
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		
		// 정렬 후
		System.out.println("정렬 후");
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + "  ");
		}
		System.out.println();
		
	}
}
