package thread_;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends Frame implements Runnable {
	
	public Clock() {
//		setSize(300, 400);
		setFont(new Font("맑은 고딕", Font.BOLD, 25));
		setForeground(new Color(0, 255, 250));
		setBackground(new Color(120, 120, 120));
		setBounds(900,700,300,400);
		setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
//		 스레드 시작 -> 스레드 실행 (운영체제가 run을 call) 

	
	this.addwindowsListener (new WindowEvent e) {
			public whindows closing(WindowAdapter()) {
			System.out.println(0) //강제종료;
		}
	});
}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			repaint();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	// Call back
	// Frame에 그려준다.
	@Override
	public void paint(Graphics g) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		
		g.drawString(sdf.format(date), 100, 100);
		System.out.println(sdf.format(date));
	}
	
	
	public static void main(String[] args) {
		new Clock();//Frame이 생성되고, paint() 호출 1회 무조건 실행 됨.
		
	}
	
}
