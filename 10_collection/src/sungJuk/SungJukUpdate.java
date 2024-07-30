package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukUpdate implements SungJuk {
	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		Scanner scan = new Scanner(System.in);
//		SungJukDTO sungJukDTO = new SungJukDTO();
		System.out.println("수정 할 대상자의 학번 입력 ");
		int perno = scan.nextInt();
		
		for(SungJukDTO sungJukDTO : list) {
			if(sungJukDTO.getPerno() == perno) {
				System.out.println("수정 할 이름 입력");
				String name = scan.next();
				
				System.out.println("수정 할 국어 점수 입력");
				int kor = scan.nextInt();
				  
				System.out.println("수정 할 수학 점수 입력");
				int mat = scan.nextInt();

				System.out.println("수정 할 영어 점수 입력");
				int eng = scan.nextInt();
				
				int tot = kor + eng + mat;
				double avg = tot / 3;
				
				sungJukDTO.setName(name);
				sungJukDTO.setKor(kor);
				sungJukDTO.setEng(eng);
				sungJukDTO.setMat(mat);
				sungJukDTO.setTot(tot);
				sungJukDTO.setAvg(avg);
				sungJukDTO.Calc();
				
				System.out.println("수정 완료");
				break;
			}
		}
//				
//				System.out.println(list.size());
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getPerno() == perno) {
//				System.out.println("수정 할 이름 입력");
//				String name = scan.next();
//				
//				System.out.println("수정 할 국어 점수 입력");
//				int kor = scan.nextInt();
//				
//				System.out.println("수정 할 수학 점수 입력");
//				int mat = scan.nextInt();
//
//				System.out.println("수정 할 영어 점수 입력");
//				int eng = scan.nextInt();
//				
//				int tot = kor + eng + mat;
//				double avg = tot / 3;
//				
//				sungJukDTO.setName(name);
//				sungJukDTO.setKor(kor);
//				sungJukDTO.setEng(eng);
//				sungJukDTO.setMat(mat);
//				sungJukDTO.setTot(tot);
//				sungJukDTO.setAvg(avg);
//				sungJukDTO.Calc();
//				
//				System.out.println("수정 완료");
//				break;
//			}
//		}
//		
//		list.set(i, sungJukDTO);

		
	}
}
