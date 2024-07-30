package abstact_;

enum colorEnum {
	RED, GREEN, BLUE;
}
class Final {
	public final String FRUIT = "사과";
	public final String FRUIT2;
	
	public static final String ANIMAL = "호랭이";
	public static final String ANIMAL2;
	
	static {
		ANIMAL2 = "동물";
	}
	
	public Final() {
		FRUIT2 = "딸기";
	}
}
public class FinalMain {
	public static void main(String[] args) {
		final int AGE = 25;
		System.out.println("AGE = " + AGE); // 초기값 세팅 시 변경 불가
		
		final String NAME;
		NAME = "홍길동"; // 초기값 없었으면 1번은 입력가능 
		
		System.out.println("NAME = " + NAME);
		
		Final f = new Final();
		System.out.println("FRUIT = " + f.FRUIT);
		System.out.println("FRUIT2 = " + f.FRUIT2);

		System.out.println("ANIMAL = " + Final.ANIMAL);
		System.out.println("ANIMAL2 = " + Final.ANIMAL2);
		
		System.out.println("빨강 = " + colorEnum.RED );
		System.out.println("빨강 = " + colorEnum.RED.ordinal());
		
		for(colorEnum data : colorEnum.values()) {
			System.out.println(data.ordinal() + " : " + data);
		}
	}
}
