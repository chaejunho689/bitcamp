package abstact_;

public class AbstractMain extends AbstractTest {
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
	//		AbstractTest at = new AbstractTest();
	//		at.setName("길동이");
		AbstractTest at = new AbstractMain(); // 부모 = 자식
		at.setName("에스파");
		System.out.println("이름 = " + at.getName());
	}
}
