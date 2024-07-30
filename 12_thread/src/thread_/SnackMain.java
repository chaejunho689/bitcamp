package thread_;

public class SnackMain extends Thread {
	private String str;

	public SnackMain(String str) {
		this.str = str;
	}
	
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(str + "\t" + "i = " + i + "\t" + Thread.currentThread());
		}
	}
	public static void main(String[] args) {
			SnackMain aa = new SnackMain("새우깡");
			SnackMain bb = new SnackMain("포카칩");
			SnackMain cc = new SnackMain("수미칩");
		
			aa.setName("새우깡");
			aa.setName("포카칩");
			aa.setName("수미칩");
			
			aa.start(); // 스레드 시작 -> 운영체제가 알아서 스레드 실행(운영체제가 알아서 run() 호출, 콜백메소드(call back))
			try {
				aa.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			bb.start();
			cc.start();
			
			aa.run(); // callback 메소드
			bb.run();
			cc.run();
			
			
			
	}
		
}
