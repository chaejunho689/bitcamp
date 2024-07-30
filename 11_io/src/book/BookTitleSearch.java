package book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTitleSearch implements Book{
	@Override
	public void execute(ArrayList<BookDTO> list) {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("검색할 제목을 입력");
		String title = scan.next().toLowerCase();
		
		
		int switch_var = 0;
		for(BookDTO bookDTO : list) {
			if(bookDTO.getTitle().toLowerCase().contains(title)) {
				System.err.println(bookDTO);
				switch_var = 1;
			} 
		}
		
		if(switch_var == 0) {
			System.out.println("검색한 책이 없습니다.");
		}
		
		
		
	}
}
