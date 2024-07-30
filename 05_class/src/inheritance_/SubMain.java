package inheritance_;

public class SubMain extends Super {
	private String name;
	protected int age;
	
	public SubMain() {
		System.out.println("SupMain 기본 생성자");
	}
	
	public SubMain(String name, int age, double weight, double height) {
		//3. 부모 생성자 호출
		super(weight, height);
		
		System.out.println("SubMain 생성자");

		this.name = name;
		this.age = age;
		//1.
		//this.weight = weight;
		//this.height = height;
		
		//2.
		//super.weight = weight;
		//super.height = height;
		
	}
	
	public void output() {
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		//System.out.println("몸무게 = " + weight);
		//System.out.println("키 = " + height);
		
		disp(); //호출
	}
	
	public static void main(String[] args) {
		SubMain aa = new SubMain("홍길동", 25, 85.3, 178.6); //생성자 2번 호출
		aa.output();
		System.out.println();
		
		aa.disp();
		System.out.println("----------------");
		
		Super bb = new SubMain("코난", 13, 35.8, 156.7);
		//bb.output(); - error
		bb.disp();
	}

}










