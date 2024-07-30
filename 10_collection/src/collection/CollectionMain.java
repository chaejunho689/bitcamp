package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain  {

	@SuppressWarnings("all") // 모든 오류 대해서 무시하도록 어노
	public static void main(String[] args) {
		Collection coll = new ArrayList(); // import
		
		coll.add("호랑이");
		coll.add("호랑이");
		coll.add("사자");
		coll.add("토끼");
		coll.add(25);
		coll.add(11.1);
		coll.remove("사자");
		
		// collection 등  항목을 가리키는 지정자
		Iterator it = coll.iterator(); // 인터페이스 iterator를 넘겨줌
		
		
		while(it.hasNext()) { //현재위치에 항목이 있으면 true, 없으면 false
			System.out.println(it.next());// 현재 위치의 항목을 꺼내서 버퍼에 기억 시키고, 다음 항목으로 이동한다.
		}
		
	}
}
