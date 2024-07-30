package thread_;

class JoinTEST implements Runnable {

	
	//내가 아닌 운영체제가 알아서 호출 함. 
	@Override
	public void run() { // 콜백 메소드다.
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class JoinMain {

	
	public static void main(String[] args) {
		JoinTEST joinTEST= new JoinTEST();
		Thread t = new Thread(joinTEST);
		
		System.out.println("스레드 시작");
		t.start();
		System.out.println("스레드 종료");
	
	}

}


// 메인이 끝나도 Thread는 종료되지 않는다.
// 백그라운드에서 Thread는 구동된다.