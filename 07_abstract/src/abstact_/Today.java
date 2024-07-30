package abstact_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Today {
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		
		System.out.println("오늘 날짜 : " + date);
		
		SimpleDateFormat sdate = new SimpleDateFormat("yy년 MM월 dd일 HH시 mm분 ss초");
		SimpleDateFormat sdate2 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHH");
		System.out.println("오늘 날짜 : " + sdate.format(date));
		
		Scanner scan = new Scanner(System.in);
		System.out.println("생일을 입력하세요.");
		String birth = scan.next();
		
		Date birth_date = sdate2.parse(birth);
		System.out.println("내생일 : " + sdate2.format(birth_date));
 		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(cal.YEAR);
		System.out.println(year);
		int month = cal.get(cal.MONTH)+1;
		System.out.println(month);
		int caldate = cal.get(cal.DATE);
		System.out.println(caldate);
		System.out.println(year + "년" + month + "월" + caldate + "일");
		

		int year2 = cal.get(1);
		System.out.println(year);
		int month2 = cal.get(2) +1;
		System.out.println(month);
		int caldate2 = cal.get(cal.DAY_OF_MONTH);
		int week = cal.get(cal.DAY_OF_WEEK);
		System.out.println(caldate);
		
		String week_display = "";
		switch(week) {
		case 1: week_display="월요일"; break;
		case 2: week_display="화요일"; break;
		case 3: week_display="수요일"; break;
		case 4: week_display="목요일"; break;
		case 5: week_display="금요일"; break;
		case 6: week_display="토요일"; break;
		case 7: week_display="일요일"; break;
		};    
		
		int hour = cal.get(cal.HOUR);
		int minute = cal.get(cal.MINUTE);
		int second = cal.get(cal.SECOND);
		
		System.out.println(year2 + "년 " + month2 + "월 " + caldate2 + "일 " + week_display + " "+ hour + ":" + minute + ":" + second);
		System.out.println();
		
		
	}
}
