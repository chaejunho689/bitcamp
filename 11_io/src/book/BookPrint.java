package book;

import java.util.ArrayList;

public class BookPrint implements Book{
	@Override
	public void execute(ArrayList<BookDTO> list) {
		System.out.println("\t\t\t책 리스트");
		System.out.println("코드\t제목\t저자\t단가\t개수\t합계");
		for(BookDTO bookDTO : list) {
			System.out.print(bookDTO.getCode() + "\t");
			System.out.print(bookDTO.getTitle() + "\t");
			System.out.print(bookDTO.getAuthor() + "\t");
			System.out.print(bookDTO.getPrice() + "\t");
			System.out.print(bookDTO.getQty() + "\t");
			System.out.print(bookDTO.getTotal() + "\t");
			System.out.println();
		}
	}
}
