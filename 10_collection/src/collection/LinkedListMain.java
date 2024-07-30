package collection;

import static java.lang.System.out;
import java.util.LinkedList;

public class LinkedListMain {
	public static void main(String[] args) {

		String[] item = {"소나타","렉스턴", "재규어"};

		LinkedList<String> q = new LinkedList<String>();

		for(String n : item) 
			q.offer(n);
		
		out.println( "q의크기 : " + q.size() + "\n");
		
		String data= "";
		
		while( (data = q.poll()) != null ) {
			out.println( data + "삭제" );
			out.println( "q의크기 : " + q.size() + "\n");
		}
	}
		
}
