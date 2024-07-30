package nested;


public class AbstractMain {
	public static void main(String[] args) {
//		 AbstractTest at = new AbstractTest() // 에러 안됨

		// 1회용
		AbstractTest at = new AbstractTest() {
			
			@Override
			public void setName(String name) {
				// TODO Auto-generated method stub
			}
		};

		InterA in = new InterA() {
			@Override
			public void aa() {}
		};
		
		AbstractExam ae = new AbstractExam() {
			//개발자가 원하는 메소드만 Override
		};
	}
}
