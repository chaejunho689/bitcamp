package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "쟈스민공주");
		map.put("book301", "백설공주");
		map.put("book101", "엄지공주");
		map.put("book401", "피오나공주");
		
		System.out.println(map.get("book101"));
		System.out.println(map.get("book301"));
		System.out.println(map.get("book501"));
		System.out.println();
		
		for(Map.Entry<String, String> data : map.entrySet()) {
			String key =  data.getKey();
			String value =  data.getValue();
		
		System.out.println("key : " + key + "\t Value : " + value);
		}
		
		

	}
}
