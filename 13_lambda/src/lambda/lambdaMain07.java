package lambda;


@FunctionalInterface
interface Create01 {
	public Person create(String name);
	
}

@FunctionalInterface
interface Create02 {
	public Person create(String name, int age);
}

class Person {
	private String name;
	private int age;
	
	public Person(String name) {
		this.name = name;
		System.out.println("Person(String name) 생성자");
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("Person(String name, int age) 생성자");
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

class PersonTest {
	public Person  getPerson01(Create01 create1) {
		String name = "none";
		Person person = new Person(name);
		return person;
	}
	
	public Person getPerson02(Create01 create1) {
		String name = "none";
		Person person = new Person(name);
		return person;
	}
}


public class lambdaMain07 {

	public static void main(String[] args) {
		PersonTest personTest = new PersonTest();
		
		Person one = personTest.getPerson01(Person :: new);
		System.out.println("이름 : " + one.getName() ) ;
		System.out.println("나이 : " + one.getAge() ) ;
	}

}
