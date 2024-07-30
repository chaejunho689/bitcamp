package nested;

public class Outer {
	private String name;
	
	public void output() {
		System.out.println("이름 = " + this.name + "\t나이 = " + new Inner().age);
	}
	
	class Inner {
		private int age;
		
		public void disp() {
			// Outer -> Inner 접근 가능
			System.out.println("이름 = " + name + "\t나이 = " + this.age);
		}
		
	}
	
	
	Inner inner = new Inner();
	
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.name="홍길동";
		outer.output();
		System.out.println();
		
		Outer.Inner inner = outer.new Inner();
		inner.age = 25;
		inner.disp(); 
		System.out.println();
		
		Outer.Inner inner2 = outer.new Inner();
		inner2.age = 30;
		inner2.disp(); 
		
		Outer.Inner inner3 = outer.new Inner();
		outer.name = "코난";
		inner3.age = 35;
		inner3.disp(); 
		
	}
}
