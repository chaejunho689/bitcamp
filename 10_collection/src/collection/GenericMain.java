package collection;

public class GenericMain<T>{
	private T a;
	
	public void setA(T a) {
		this.a = a;
	}
	
	public T getA() {
		return a;
	}
	
	public static void main(String[] args) {
		GenericMain<String> aa = new GenericMain<>();
		aa.setA("에스파");
		System.out.println("이름 : " + aa.getA());
		
		GenericMain<Integer> bb = new GenericMain<>();
		bb.setA(25);
		System.out.println("나이 : " + bb.getA());
	}
}
