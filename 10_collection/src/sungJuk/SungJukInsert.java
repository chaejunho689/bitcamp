package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukInsert implements SungJuk {
	
	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		// 성적 Insert
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 입력 ");
		String name = scan.next();
	
		System.out.println("학번 입력");
		int perno = scan.nextInt();
		
		System.out.println("국어 점수 입력");
		int kor = scan.nextInt();
		
		System.out.println("수학 점수 입력");
		int mat = scan.nextInt();

		System.out.println("영어 점수 입력");
		int eng = scan.nextInt();
		
//		int tot = kor + eng + mat;
//		double avg = tot / 3;

		SungJukDTO sungJukDTO = new SungJukDTO(name,perno, kor, eng, mat);
		sungJukDTO.Calc();
		list.add(sungJukDTO);
		
	
	}
}
