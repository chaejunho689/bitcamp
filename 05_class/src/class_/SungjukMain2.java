package class_;

public class SungjukMain2 {
	public static void main(String[] args) {
		Sungjuk aa = new Sungjuk();
		aa.setData("윈터", 100, 89, 53);
		aa.calc();
		System.out.println(
				  aa.getName() + "\t"
				+ aa.getKor() + "\t"
				+ aa.getEng() + "\t"
				+ aa.getMath() + "\t"
				+ aa.getTot() + "\t"
				+ String.format("%.2f", aa.getAvg()) + "\t"
				+ aa.getGrade() + "\t"
				);
		
		Sungjuk bb = new Sungjuk();
		bb.setData("카리나", 70, 19, 93);
		bb.calc();
		System.out.println(
				  bb.getName() + "\t"
				+ bb.getKor() + "\t"
				+ bb.getEng() + "\t"
				+ bb.getMath() + "\t"
				+ bb.getTot() + "\t"
				+ String.format("%.2f", bb.getAvg()) + "\t"
				+ bb.getGrade() + "\t"
				);
		
		Sungjuk cc = new Sungjuk();
		cc.setData("닝닝", 90, 92, 99);
		cc.calc();
		System.out.println(
				  cc.getName() + "\t"
				+ cc.getKor() + "\t"
				+ cc.getEng() + "\t"
				+ cc.getMath() + "\t"
				+ cc.getTot() + "\t"
				+ String.format("%.2f", cc.getAvg()) + "\t"
				+ cc.getGrade() + "\t"
				);
	}
}
