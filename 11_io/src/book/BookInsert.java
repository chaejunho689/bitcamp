package book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookInsert implements Book{
	@Override
	public void execute(ArrayList<BookDTO> list)  {
		Scanner scan = new Scanner(System.in);

		String title;
		String author;
		int code;
		int price;
		int qty;
		
		System.out.println("등록할 책의 코드를 입력하세요."); 
		code = scan.nextInt();
		
		// 비어있는지 체크 후 코드 중복 확인
		if(!(list.isEmpty())) { //list가 비어있으면 true 리턴 
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getCode() == code) {
					System.out.println("코드가 중복됩니다. 다시 입력하세요.");
					return;
				} 
			}
		}
		
		System.out.println("책 제목을 입력하세요.");
		title = scan.next();
		
		System.out.println(title + " 책의 저자를 입력하세요.");
		author = scan.next();
		
		System.out.println(title + " 책의 가격 입력하세요.");
		price = scan.nextInt();
		
		System.out.println(title + " 책의 수량을 입력하세요.");
		qty = scan.nextInt();
		
		BookDTO bookDTO = new BookDTO(code, title, author, price, qty);
		bookDTO.Calc();
		list.add(bookDTO);
		
		System.out.println(title + "책 저장이 완료되었습니다.");
		
	}
}
