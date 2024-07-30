package class__;

import java.util.Scanner;

public class Exam {
	private String name = null; // 유저 이름
	private String dap = null; // 유저의 정답을 스트링 저장 
	private char[] ox = null; // JUNG의 답을 배열로 저장 
	private char[] user_ox = null; // 유저의 정답을 배열로 저장
	private char[] user_ox_result = null; // O X 로 정답 표기
	private String result = null; // 유저의 정답 OX를 스트링 저장 
	private int score = 0;
	private final String JUNG = "11111"; //상수화

	
	
	public Exam() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("인원수를 입력하세요.");
		int count = scan.nextInt();
		Exam[] ex = new Exam[count];

		//입력
		for(int i=0; i<ex.length; i++) {
			ex[i] = new Exam(); 
			
			System.out.print("이름을 입력 : ");
			String name = scan.next();
	        ex[i].setName(name);

			
			System.out.println();
			System.out.print("답 입력 : ");
			String bdap = scan.next();
	        ex[i].setDab(dap);


			
		}
		System.out.println("이름\t12345\t점수");
		//출력
		for(int i = 0; i < count; i++) {
			System.out.print(getName()+"\t");
			System.out.print(getResult()+" ");
			System.out.println("\t"+ getScore());
		}
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setDab(String j) {
		dap = j;
		
		user_ox = new char[5];

		
		for(int i = 0; i < 5; i++) { 
			user_ox[i] = j.charAt(i);
		}
		compare();
	}
	
	public void compare() {
        ox = JUNG.toCharArray(); // Initialize ox array
        user_ox_result = new char[5]; // Initialize user_ox_result array

		for(int i = 0; i < 5; i++) { 
			ox[i] = JUNG.charAt(i); // 정답 저장
		}
		
		for(int i = 0; i < 5; i++) { // i -> 5 문제(5개)만큼 반복한다.
			if(ox[i] == user_ox[i]) {
				user_ox_result[i] = 'O';
				score += 20;
			} else {
				user_ox_result[i] = 'X';
			}
		}
		charToString();
	}
	
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}	
	
	public void charToString() {
		result = new String(user_ox_result); 
	}
	
	public String getResult() {
		return result;
	}	
	
	
}
