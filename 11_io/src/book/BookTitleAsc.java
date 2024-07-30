package book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookTitleAsc implements Book {
	@Override
	public void execute(ArrayList<BookDTO> list) {
		Collections.sort(list);
		
		Comparator<BookDTO> com = new Comparator<BookDTO>() {
			
			@Override
			public int compare(BookDTO o1, BookDTO o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		};
		Collections.sort(list, com);
		
		
		System.out.println();
		System.out.println("코드\t제목\t저자\t가격\t수량\t합계");
		for(BookDTO bookDTO : list) {
			System.out.println(bookDTO);
		}//for     
	}
}
