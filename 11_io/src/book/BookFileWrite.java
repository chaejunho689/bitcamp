package book;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookFileWrite implements Book{
	@Override
	public void execute(ArrayList<BookDTO> list) throws IOException, ClassNotFoundException {

		// 파일 삭제 후 재생성
		File file = new File("book.txt");
		if(file.exists()) {
			file.delete();
		}
		
		try {
			if(file.createNewFile()) {
				System.out.println("book.txt 파일이 생성되었습니다.");
			} else {
				System.out.println("book.txt 파일이 이미 존재합니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

		
		// 리스트를 텍스트 파일에 쓰기
        BufferedWriter writer = new BufferedWriter(new FileWriter("book.txt"));
        for (BookDTO dto : list) {
            writer.write(dto.getCode() + "," 
            		+ dto.getTitle() + "," 
            		+ dto.getAuthor() + "," 
            		+ dto.getPrice() + "," 
            		+ dto.getQty() + "," 
            		+ dto.getTotal()
            		);
            writer.newLine();
        }
        writer.close();

        
        /*
         
        //다른방법2
        try {
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"))
    		for(BookDTO bookDTO : list) {
    			oos.writeObject(bookDTO);
    		}//for
    		
    		oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		*/
        
        
        // 아래 처럼 했는데, 잘안되서 어레이 리스트를 파일로 저장하는 부분이 안되서 검색 후 위처럼 해결함.
		/*
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"));
		oos.writeObject(list);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"));
//		BookDTO dto2 = (BookDTO)ois.readObject();
        ArrayList<BookDTO> readList = (ArrayList<BookDTO>) ois.readObject();

        for(BookDTO dto : readList) {
            System.out.println("이름 : " + dto.getTitle());
            System.out.println("저자 : " + dto.getAuthor());
            System.out.println("코드 : " + dto.getCode());
        }
		oos.close();
	*/
	}
}
