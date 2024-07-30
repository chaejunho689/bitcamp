package lambda;

import java.util.jar.Attributes.Name;

class Person03 {
	public void execute(InterA interA) {
		interA.disp("홍길동", 25);
	}
	
	public void execute(InterB interB) {
		interB.output("홍길동입니다.");
	}
}


public class LambdaMain03 {

	public static void main(String[] args) {
		Person03 person03 = new Person03();
		
		person03.execute(("test", "test") -> {
			System.out.println();
			
			person03.execute((Name.class age) -> {
				System.out.println("나의 이름은" + name + " 입이다.");
				System.out.println("나의 나이는" + age + " 입이다.");
				
		});
		
	}

}
