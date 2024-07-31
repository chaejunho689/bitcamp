package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("이재훈");
		list.add("엄태구");
		list.add("이동욱");
		list.add("안효섭");
		list.add("이준기");
		list.add("나연우");
		
		// 람다식
		Stream<String> stream = list.stream();
		stream.forEach(name -> System.out.println(name));
		System.out.println();
		
		// 람다식 메서드 참조
		Stream<String> stream2 = list.stream();
		stream2.forEach(System.out :: println);
		
	}
}

/*
스트림(Stream)
스트림(Stream)은 자바 8 API에 새로 추가된 기능이다.
람다를 활용해 배열과 컬렉션을 함수함으로 간단하게 처리할 수 있는 기술이다.
*/