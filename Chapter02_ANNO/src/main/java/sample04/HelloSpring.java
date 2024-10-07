package sample04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloSpring {
	List<SungJukDTO2> list = new ArrayList<SungJukDTO2>();
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.menu(context);
		System.out.println("프로그램을 종료합니다.");
		
	}

	
	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		SungJuk sungJuk = null;
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("**************************");
			System.out.println("	1. 성적 입력");
			System.out.println("	2. 성적 출력");
			System.out.println("	3. 성적 수정");
			System.out.println("	4. 성적 삭제");
			System.out.println("	5. 종료");
			System.out.println("**************************");
			System.out.println(" 선택 : ");
			num = scan.nextInt();
			
			if(num == 5) break;
			if(num == 1) sungJuk = (SungJuk) context.getBean("sungJukInput"); 
			else if(num == 2)  sungJuk = (SungJuk) context.getBean("sungJukOutput");  // 부모 = 자식
			else if(num == 3)  sungJuk = (SungJuk) context.getBean("sungJukUpdate");  // 부모 = 자식
			
			sungJuk.execute(list);
		}
	}
	

}
