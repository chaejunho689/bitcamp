package book;

import java.io.File;
import java.io.IOException;

public class BookMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		BookService bookService = new BookService();
		bookService.menu();
		System.out.println("프로그램 종료");
		
		// 프로그램 종료 시 파일 삭제
		File file = new File("book.txt");
		if(file.exists()) {
			file.delete();
//			System.out.println("debug 파일 삭제");
		} else {
//			System.out.println("debug 삭제할 파일 없음 ");
		}
	}
}
