package interface_;

// InterA, InterB 상속
//public class InterMain implements InterA, InterB {

//InterC안에 InterA, InterB 상속했기 때문에 InterC만 상속해도 InterA,B 사용가능
public class InterMain implements InterC {

	// 해당 인터페이스 오버라이딩 -> 전부 안해주면 에러 발생
	public void aa() {
		
	}
	
	public void bb() {
		
	}
	
	public void cc() {
		
	}
	
	public void dd() {
		
	}
	
	public static void main(String[] args) {
		
	}
}
