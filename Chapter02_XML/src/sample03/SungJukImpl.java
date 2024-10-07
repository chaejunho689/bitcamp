package sample03;

import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SungJukImpl implements SungJuk {
	private SungJukDTO sungJukDTO = null;

//	public SungJukImpl(SungJukDTO sungJukDTO) {
//		this.sungJukDTO = sungJukDTO;
//	}

	@Override
	public void calcTot() {
		int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
		sungJukDTO.setTot(tot);
	}

	@Override
	public void calcAvg() {
		double avg = sungJukDTO.getTot() / 3.;
		sungJukDTO.setAvg(avg);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.print(sungJukDTO);
	}

	@Override
	public void modify() {
		Scanner sc = new Scanner(System.in);
		
        System.out.print("이름 입력 : ");
        String name = sc.next();
        System.out.print("국어 입력 : ");
        int kor = sc.nextInt();
        System.out.print("영어 입력 : ");
        int eng = sc.nextInt();
        System.out.print("수학 입력 : ");
        int math = sc.nextInt();
        
       sungJukDTO.setName(name);
       sungJukDTO.setKor(kor);
       sungJukDTO.setEng(eng);
       sungJukDTO.setMath(math);
	}

}









