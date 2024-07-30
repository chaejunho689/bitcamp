package class_;

class Person {
	// private으로 숨길 시, main에서 메소드 없이 사용 불가
	private String name; 
	private int age;
	
	//public 메소드 생성하여 private 호출사용
	// 메소드 구현
	public void setName (String n) {
		name = n;
	}

	public void setAge (int n) {
		age = n;
	}
	
	public void setData(String n, int a) {
		name = n;
		age = a;
	}
	
	public void setData() {
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}

public class PersonMain {
	public static void main(String[] args) {
	
	Person aa; // 객체
	aa = new Person(); //생성
	
	// public을 private으로 변경하면, 직접 접근 불가
//	aa.age = 15; 
//	aa.name = "홍길동";

	System.out.println("객체" + aa); // 객체 주소값 출력
//	System.out.println("이름 : " + aa.name + " 나이 : " + aa.age);
	
	aa.setName("홍길동");
	aa.setAge(25);
	System.out.println("이름 : " + aa.getName() + " 나이 : " + aa.getAge());

	Person bb;
	bb = new Person();
	
	bb.setName("차은우");
	bb.setAge(21);
	System.out.println("객체" + bb); // 객체 주소값 출력
	System.out.println("이름 : " + bb.getName() + " 나이 : " + bb.getAge());
	
	Person cc;
	cc = new Person();
	
	cc.setData("카리나", 23);
	System.out.println("객체" + cc); // 객체 주소값 출력
	System.out.println("이름 : " + cc.getName() + " 나이 : " + cc.getAge());
	
	Person dd;
	dd = new Person();
	
	dd.setData(); // 같은 이름의 setData라도, 파라미터가 다르면 별개의 메소드 취급(overload)
	System.out.println("객체" + dd); // 객체 주소값 출력
	System.out.println("이름 : " + dd.getName() + " 나이 : " + dd.getAge());
	
	}
}
