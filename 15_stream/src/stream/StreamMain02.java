package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor //매개변수가 있는 생성자 모두생성
@Getter
@Setter
class Food {
	String name;
	int calorie;

}

public class StreamMain02 {
	static int hap;

	public static void main(String[] args) {
		
		Food aa = new Food("돈까스", 775);
		Food bb = new Food("탕수육", 112);
		Food cc = new Food("라면", 675);
		Food dd = new Food("떡볶이", 654);
		Food ee = new Food("짜장면", 740);

		List<Food> list = new ArrayList<Food>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		list.add(dd);
		list.add(ee);
		
		List<Food> calorieList = new ArrayList<Food>();
		for(Food food : list) {
			if(food.getCalorie() > 500) {
				calorieList.add(food);
			}
		}
			
		Collections.sort(calorieList, new Comparator<Food>() {
			@Override
			public int compare(Food o1, Food o2) {
				return Integer.compare(o1.getCalorie(), o2.getCalorie());
			}
		});
		
		List<String> foodName = new ArrayList<String>();
		for(Food food : calorieList) {
			foodName.add(food.getName());
			System.out.println(food.getName());
		}
		System.out.println(foodName);
		System.out.println("\n");
		
		//스트림 처리
		List<String> foodNameList = list.stream()
				.filter(f -> f.getCalorie() > 500)
				.sorted(Comparator.comparing(Food :: getCalorie))
				.map(f -> f.getName())
				.collect(Collectors.toList());

		System.out.println(foodNameList);
		
		
		// 합계
		// .reduce(초기값, (누적변수, 요소) -> 처리문)
		// .reduce()는 Stream의 요소들을 하나의 데이터로 만드는 작업을 수행
		IntStream stream = IntStream.range(1, 5);
		int sum = stream.reduce(0, (total, num) -> total + num);
		System.out.println("합계는 " + sum);
		
		IntStream stream2 = IntStream.rangeClosed(1, 5); //rangeClosed() 끝수를 포함한다. 1,2,3,4,5
		stream2.forEach(x -> hap+=x);
		System.out.println("합계는 " + hap);
	}
}
