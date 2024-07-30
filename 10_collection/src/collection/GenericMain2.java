package collection;

public class GenericMain2<T> {
	private T a;
	
	//생성자 
	public GenericMain2(T a) {
		this.a = a;
//	생성자는 한 번만, setter는 여러번 호출 가능하다.
	}
	
	public void setA(T a) {
		this.a = a;
	}
	
	public T getA() {
		return a;
	}
	
	public static void main(String[] args) {
//		GenericMain2<?> aa = new GenericMain2<String>();
//		aa.setA("둘리"); 반드시 데이터는 setter가 아니라 생성자를 통해 넣어야 한다.
		
//		? = 오브젝트 와일드카드
		GenericMain2<?> aa = new GenericMain2<String>("둘리");
		String name = (String) aa.getA(); 
		System.out.println("이름 : " + name);
		
		GenericMain2<?> bb = new GenericMain2<Integer>(24);
		int age = (int) bb.getA(); // unAutoBoxing 클래스 <-> 기본형화
		System.out.println("나이 : " + age);
		
		
	}
}
