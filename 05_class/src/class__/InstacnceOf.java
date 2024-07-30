package class__;

class AAA {}
class BBB extends AAA {}

public class InstacnceOf {
	
	public class InstanceOf {
		public static void main(String[] args) {
			AAA aa = new AAA();
			BBB bb = new BBB();
			AAA aa2 = new BBB();

			AAA aa3 = aa;
			if(aa instanceof AAA) {
				System.out.println("1. TRUE");
			}
			else {
				System.out.println("1. FALSE");
			}
			
			AAA aa4 = aa;
			if(bb instanceof AAA) {
				System.out.println("2. TRUE");
			}
			else {
				System.out.println("2. FALSE");
			}
			
			BBB bb2 = (BBB)aa2;
//			BBB bb3 = (BBB)aa; //캐스팅 안됨. 에러메시지
			if(aa2 instanceof BBB) {
				System.out.println("3. TRUE");
			} else {
				System.out.println("3. FALSE");
			}
			
			if(aa instanceof BBB) {				
				System.out.println("4. TRUE");
			} else {
				System.out.println("4. FALSE");
			}
		
			
		}
}

}
