package abstact_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class CalendarEx {
	protected Scanner scan = new Scanner(System.in);
	
	public CalendarEx() throws ParseException {
		Calendar cal = Calendar.getInstance();

		System.out.print("연도를 입력하세요 : ");
		String year = scan.next();
		System.out.print("월을 입력하세요 : ");
		String month = scan.next();
		
		CalendarCalc(year, month);
	}

	public void CalendarCalc(String a, String b) throws ParseException{
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat full = new SimpleDateFormat("yyyyMMdd"); 
		Date df = full.parse(a + b + "01"); // full을 Date로 변환
//		System.out.println(full.format(df)); //날짜 풀 20240101 형식
		
		SimpleDateFormat month = new SimpleDateFormat("MM"); 
		Date df2 = month.parse(b);
//		System.out.println(month.format(df2)); // 월만 분리
		
		SimpleDateFormat year = new SimpleDateFormat("yyyy"); 
		Date df3 = year.parse(a);
//		System.out.println(year.format(df3)); // 연도만 분리
		
		cal.setTime(df);
		int weekFirst = cal.get(cal.DAY_OF_WEEK);
//		System.out.println(weekFirst); // 입력받은 년월의 시작요일
		
		cal.setTime(df2);
		int weekLast = cal.getActualMaximum(cal.DAY_OF_MONTH);
//		System.out.println(weekLast); // 입력받은 년월의 시작요일
		
		CalendarDisplay(weekFirst, weekLast, a, b);
	}
	
	
	public void CalendarDisplay(int first, int last, String year, String month) {
		System.out.println("\t\t["+ year + "년\t" + month + "월]");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		first = first-1; // 요일의 인수 조정
		int week = 0;
		int j = 0;
		for(int i = 1; i <= last; i++) {
			for(; j < first; j++) {
//				System.out.print(" j");
				System.out.print("\t");
				week++;
			} // 첫번째 시작일 만큼 탭하고 끝
			System.out.print(i);
			System.out.print("\t");
			week++;
			if(week == 7) {
				System.out.println();
				week = 0;
			}
		}
	}
}
