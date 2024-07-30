package thread_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ATM implements Runnable {
	private long  depositMoney=100000;
	private long  balance;
	
	@Override
	public synchronized void run() {
		System.out.println("쓰레드" + Thread.currentThread().getName());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("찾고자 하는 금액 입력 : ");
		try {
			balance = Long.parseLong(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		withDraw();
	}

	public void withDraw() {
		if((balance % 10000) != 0) {
			System.out.println("만 원 단위로 입력하세요.");
			return;
		}
		
		if(balance > depositMoney) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		depositMoney -= balance;
		System.out.print("남은 잔액은 : ");
		System.out.print(depositMoney);
	}
	
	
}


public class ATMMain {
	public static void main(String[] args) {
		ATM atm = new ATM();
		//스레드 생성
		Thread mom = new Thread(atm, "부모");
		Thread son = new Thread(atm, "자식");
		
		mom.start(); // 스레드 시작 -> 스레드 실행(run 메소드 찾아감)
		son.start();
	}
}
