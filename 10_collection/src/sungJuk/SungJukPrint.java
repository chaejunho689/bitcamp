package sungJuk;

import java.util.ArrayList;

public class SungJukPrint implements SungJuk {
	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		
		System.out.println("\t\t\t성적표");
		System.out.println("이름\t학번\t국어\t영어\t수학\t총합\t평균");
		for(SungJukDTO sungJukDTO : list) {
			System.out.print(sungJukDTO.getName() + "\t");
			System.out.print(sungJukDTO.getPerno() + "\t");
			System.out.print(sungJukDTO.getKor() + "\t");
			System.out.print(sungJukDTO.getEng() + "\t");
			System.out.print(sungJukDTO.getMat() + "\t");
			System.out.print(sungJukDTO.getTot() + "\t");
			System.out.print(sungJukDTO.getAvg() + "\t\n");

		}
		
	}
	
	
}
