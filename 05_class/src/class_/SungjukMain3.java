package class_;

public class SungjukMain3 {
	public static void main(String[] args) {
		Sungjuk[] ar = new Sungjuk[3]; // 객체의 배열을 생성해서 사용하는 것이 효과적

		ar[0] = new Sungjuk(); // 객체 생성
		ar[1] = new Sungjuk(); // 객체 생성
		ar[2] = new Sungjuk(); // 객체 생성
		
		ar[0].setData("윈터", 56, 81, 37);
		ar[1].setData("카리나", 70, 50, 90);
		ar[2].setData("닝닝", 99, 19, 33);

		for(int i = 0; i < ar.length; i++) {
			ar[i].calc();
			System.out.println(
					  ar[i].getName() + "\t"
					+ ar[i].getKor() + "\t"
					+ ar[i].getEng() + "\t"
					+ ar[i].getMath() + "\t"
					+ ar[i].getTot() + "\t"
					+ String.format("%.2f", ar[i].getAvg()) + "\t"
					+ ar[i].getGrade() + "\t"
					);		}
		
		
	}
}
