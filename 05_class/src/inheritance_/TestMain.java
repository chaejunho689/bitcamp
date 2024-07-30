package inheritance_;

class AA {
	public int a = 3;
	public void disp() {
		a+= 5;
		System.out.println("AA : " + a + " ");
	}
}

class BB extends AA {
	public int a = 8;
	public void disp() {
		this.a+= 5;
		System.out.println("BB : " + a + " ");
	}
}


public class TestMain {
	public static void main(String[] args) {
		BB aa = new BB();
		aa.disp();
		System.out.println("aa : " + aa.a);
		System.out.println();
		
		AA bb = new BB();
		bb.disp();
	
		BB cc = (BB)bb; // 자식 -자식부모
		cc.disp(); //BB:18
		System.out.println("cc : " + cc);
		
		AA dd = new AA();
		dd.disp(); // AA : 8
		System.out.println("dd : " + dd.a); //8
		System.out.println();
		
		BB ee = (BB)dd; //BB캐스팅 자식=자식(부모)) -- ClassCaspException
		
	}
	
	// 부모는 자식 클래스를 참조할 수 있는 다형성 클래스다.
	// 자식 = 부모 자료에 맞춰준다(캐스팅)
	
}
