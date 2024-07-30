package abstact_;

public abstract class AbstractTest {
	protected String name;
	
	public AbstractTest() {}
	
	public AbstractTest(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
   	
//	public void setName(String name) { 
////		this.name = name;
//	}
	
	public abstract void setName(String name); //추상메소드는 추상클래스로 가야됨. 
	
	
	/*
	abstract void 메소드 -> abstract class 클래스
	 */
}
