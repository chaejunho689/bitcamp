package while_;

public class DoWhile {
	public static void main(String[] args) {
		
		char ch = 'A';
		int i = 1;
		do {
			System.out.print(ch);
			ch++;
			i++;
			if(i == 8) {
				System.out.println();
				i = 1;
			}
		} while (ch <= 'Z');
	}
}

/*
[문제] A ~ z를 출력하되, 1줄에 7개씩 만 출력하시오.

ABCDEFG
HIJKLMN
OPQRSTU
VWXYZ

 */

