package sungJuk;

public class SungJukDTO implements Comparable<SungJukDTO> {
	private int perno, kor, eng, mat, tot;
	private double avg;
	private String name;
	
	
	public SungJukDTO() {
	}

	public SungJukDTO(String name, int perno,int kor, int eng, int mat) {
		this.name = name;
		this.perno = perno;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
//		this.tot = tot;
//		this.avg = avg;
		this.Calc();
	}
	
	
	public int getPerno() {
		return perno;
	}
	public void setPerno(int perno) {
		this.perno = perno;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return perno + "\t"
				+name + "\t"
				+name + "\t"
				+kor + "\t"
				+eng + "\t"
				+mat + "\t"
				+tot + "\t"
				+String.format("%.2f", avg);
	}
	
	public void Calc() {
		this.tot = kor + eng + mat;
		this.avg = tot / 3.0;
	}

	// 총점으로 내림차 순.1``
	public int compareTo(SungJukDTO sungJukDTO) {
		if(this.tot > sungJukDTO.tot) {
			return -1;
		} else if(this.tot < sungJukDTO.tot) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
