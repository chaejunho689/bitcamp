package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {
	
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
	
		

		for(int i = 1; i <= 10; i++ ) {
			v.add(i + "");
			System.out.println(v.get(i-1) + " ");
		}
		System.out.println();
		System.out.println("벡터 크기 = " + v.size());
		System.out.println("벡터 용량 = " + v.capacity());
		System.out.println();	
		
		System.out.println("항목 1개 추가");
		v.addElement(5 + ""); // 중복허용
		System.out.println("벡터 크기 = " + v.size());
		System.out.println("벡터 용량 = " + v.capacity());
		System.out.println();
		
		System.out.println("항목 5를 삭제");
		v.remove(5); // 인덱스가 5번 항목 6열 삭제
		v.remove(5 + ""); // 앞에 있는 항목 5가 삭제
		System.out.println(v);
		System.out.println();
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next() + " ");
		}
		
	}
	
	
}
