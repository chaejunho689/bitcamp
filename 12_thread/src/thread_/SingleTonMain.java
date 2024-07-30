package thread_;

class Singleton {
	private int num=3;
	private static Singleton instance; // static의 instance 생성
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized(Singleton.class) {
				instance = new Singleton();
			}
		}
		return instance;
	}  
	
	public void calc() {
		num++;
	}
	
	public void disp() {
		System.out.println("num = " + num);
	}
	
}

public class SingleTonMain {
	public static void main(String[] args) {
//		Singleton aa = new Singleton();
		Singleton aa = Singleton.getInstance();
		aa.calc();
		aa.disp();
		System.out.println();
		
		Singleton bb = Singleton.getInstance();
//		Singleton bb = new Singleton();
		bb.calc();
		bb.disp();
		System.out.println();

		Singleton cc = Singleton.getInstance();
//		Singleton cc = new Singleton();
		cc.calc();
		cc.disp();
		System.out.println();

	}
}
