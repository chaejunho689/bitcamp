package abstact_;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.text.NumberFormatter;

public class NumberMain {
	public static void main(String[] args) {
//		NumberFormat nf = new NumberFormat(); // error
		
		NumberFormat nf = new DecimalFormat();
		NumberFormat nf2 = new DecimalFormat("#,###.##원");
		NumberFormat nf3 = new DecimalFormat("#,###.00원"); 
		NumberFormat nf4 = NumberFormat.getInstance(); // 표준
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(); // 각 나라 통화표시
		NumberFormat nf6 = NumberFormat.getCurrencyInstance(Locale.JAPAN); // 국가 설정

		//3자리마다 쉼표, 소수이하 3째자리
		System.out.println(nf.format(12345678.123456));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		//3자리마다 쉼표, 소수이하 3째자리
		System.out.println(nf2.format(12345678.123456));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		
		//3자리마다 쉼표, 소수이하 3째자리
		System.out.println(nf3.format(12345678.123456));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//3자리 찍고 소수이하 3째자리 => 기본패턴
		nf4.setMaximumFractionDigits(2); // 소수이하 2째 자리
		nf4.setMinimumFractionDigits(2); // 0을 강제 표시
		System.out.println(nf4.format(12345678.123456));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		System.out.println(nf5.format(12345678.123456));
		System.out.println(nf5.format(12345678));
		System.out.println();
		
		
		// locale set
		System.out.println(nf6.format(12345678.123456));
		System.out.println(nf6.format(12345678));
		System.out.println();
		

	}
}
