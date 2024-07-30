package homework_;

public class FruitMain {
	public static void main(String[] args) {
		Fruit aa = new Fruit("사과", 100, 81, 75);
		Fruit bb = new Fruit("바나나", 90, 85, 35);
		Fruit cc = new Fruit("포도", 59, 75, 71);
		
		Fruit[] ar = new Fruit[3];
		ar[0] = new Fruit("사과", 100, 81, 75);
		ar[1] = new Fruit("바나나", 90, 85, 35);
		ar[2] = new Fruit("포도", 59, 75, 71);
		
		Fruit[] ab = {
				new Fruit("사과", 100, 81, 75),
				new Fruit("바나나", 90, 85, 35),
				new Fruit("포도", 59, 75, 71)	
		};
		
		Fruit[] ac = new Fruit[] {
				new Fruit("사과", 100, 81, 75),
				new Fruit("바나나", 90, 85, 35),
				new Fruit("포도", 59, 75, 71)	
		};
		
		for(int i = 0; i < ac.length; i++) {
			ar[i].calcTot();
		}
		
		
		System.out.println("-----------------------------------------------");
        System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		for(int i = 0; i < ac.length; i++) {
			ar[i].calcTot();
			ar[i].display();
		}
		System.out.println("-----------------------------------------------");
		System.out.println("-----------------------------------------------");
		
		
	}
	
	
}
/*
과일 판매량 구하기
월별 매출합계도 구하시오

[클래스]
Fruit
[필드]
pum, jan, feb, mar, tot
sumJan, sumFeb, sumMar
[메소드]
생성자(품명, 1월, 2월, 3월)
calcTot()
display()
public static void output()

[클래스]
FruitMain

[실행결과]
---------------------------------------
PUM JAN   FEB   MAR TOT
---------------------------------------
사과    100    80    75     255
포도     30    25    10     xxx
딸기     25    30    90     xxx
---------------------------------------
        xxx   xxx   xxx output()로 처리
*/