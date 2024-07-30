package interface_;

public interface InterA {
	public static final String NAME = "카리나"; // 상수
	int AGE = 25;  // Interface에서 일반 변수는 사용할 수 없음 -> 에러없는 이유? ->
	// static final이 생략처리 되고, 자동 상수로 변환 됨.
	
	public void aa(); // 추상은 세미콜론 붙임. abstract(추상 메소드 선언) 생략 가능.
	public void bb() ;// { } <- 구현 부분은 생성 불가.
}
