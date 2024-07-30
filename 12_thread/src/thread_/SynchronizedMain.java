package thread_;

class Synchronized extends Thread {
	private static int count;
	
	@Override
	public void run() {	
		synchronized (Synchronized.class) {
			
		}
		for(int i = 1; i <= 5; i++) {
			count++;
			System.out.println(Thread.currentThread() + " : " + count);
		}
	}
}


public class SynchronizedMain {
	public static void main(String[] args) {

		Synchronized aa = new Synchronized();
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();


		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");
		
		aa.setPriority(Thread.MIN_PRIORITY);
		bb.setPriority(Thread.MAX_PRIORITY);
//		cc.setPriority(Thread.);
		
		aa.start();
		bb.start();
		cc.start();
		
	}

}
