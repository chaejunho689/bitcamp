package collection;

import java.util.ArrayList;

public class CollectionMain2 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("호랑이");
		list.add("호랑이");
		list.add("사자");
		list.add("토끼");
		list.remove("호랑이");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-----------");
		
		for(String data : list) {
			System.out.println(data);
		}
		
		
	}
}
