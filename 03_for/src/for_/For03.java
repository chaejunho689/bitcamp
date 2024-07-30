package for_;

public class For03 {
	public static void main(String[] args) {
		int sum = 0;
		int mul = 1;
		System.out.println("숫자" + "\t" + "합" + "\t" + "곱");
		for(int i = 1; i <= 10; i++) {
			sum = sum + i;
			mul = mul * i;
			System.out.println(i + "\t" + sum + "\t" + mul);
		}
/*
숫자	합	곱
1	1	1
2	3	2
3	6	6
4	10	24
5	15	120
6	21	720
7	28	5040
8	36	40320
9	45	362880
10	55	3628800
*/
		
	}
}
