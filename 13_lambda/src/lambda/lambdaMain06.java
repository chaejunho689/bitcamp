package lambda;

@FunctionalInterface
interface Comp {
	public int compage(String name, String irum); //음수, 0, 양수
}


class Person06 {
	public void order(Comp comp) {
		String name = "홍길동";
		String irum = "코난";
		
		int result = comp.compage(name, irum);
		
		if(result < 0) {
			System.out.println(name + ", " + irum);
		} else if(result > 0) {
			System.out.println(irum + ", " + name);
		}  else {
			System.out.println("같은 이름");
		}
	}
}


public class lambdaMain06 {

	public static void main(String[] args) {
		Person06 person06 = new Person06();
		Person03.order((name, irum) -> name.compareTo(irum));
		Person03.order(String :: compareTo);
	}

}
