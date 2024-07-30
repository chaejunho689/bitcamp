package class__;

public class Method01 {
	public static void main(String[] args) {
		Method01.display();
		display();
		
		Method01 m = new Method01();
		m.output();
		m.display();
		
	}
	
	// static은 객체 생성 없이 호출할 수 있다.
	// println -> 기본 메소드, display, output 등 직접 만든 것은 사용자메소드
	public static void display() {
		System.out.println("static method");
	}
	
	// static이 아니면 객체 생성하여 호출한다.
	public void output() {
		System.out.println("non-static method");
	}
	
}
