package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBeanKo = new MessageBeanKo(); //1:1, 결합도 100%
		//MessageBean messageBean = new MessageBeanEn(); //부모 = 자식, 다형성, 결합도 낮추기
		
		//스프링 설정파일
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
		MessageBean messageBean = (MessageBean) context.getBean("messageBean"); //applicationContext.xml에서 Bean의 id 값을 넣어준다.
		messageBean.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean2 = (MessageBean) context.getBean("messageBean");
		messageBean2.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean3 = (MessageBean) context.getBean("messageBean");
		messageBean3.sayHello("Spring");
		System.out.println();

	}

}

























