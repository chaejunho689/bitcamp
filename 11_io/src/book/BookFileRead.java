package book;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BookFileRead  implements Book{
	@Override
	public void execute(ArrayList<BookDTO> list) throws IOException, FileNotFoundException {
		
		// 파일 존재하는지 여부 체크
		File file = new File("book.txt");
		if(file.exists()) {
		} else {
			System.out.println(file + "파일이 존재하지 않습니다.");
			return;
		}
		
        // 텍스트 파일에서 리스트 읽기
        BufferedReader reader = new BufferedReader(new FileReader("book.txt"));
        String line;
 		System.out.println(file); // 파일 제목 출력 
        System.out.println("파일 원본 내용");
 		System.out.println("콤마 변환 내용");
		System.out.println("코드\t제목\t저자\t단가\t개수\t합계");
		/*	readLine은 \n 또는 \r 등의 문장의 라인피드를 나타내는 표시가 나올 때까지 *
		* 	한 줄을 통으로 읽어서  그 문장들 안에 포함되어 있는 문자열을 리턴한다. 		*/
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            // 콤마를 기준으로 배열화 한다.
            String code = parts[0];
            String title = parts[1];
            String author = parts[2];
            String price = parts[3];
            String qty = parts[4];
            String total = parts[5];
            System.out.print(code 	+ "\t");
            System.out.print(title	+ "\t");
            System.out.print(author	+ "\t");
            System.out.print(price	+ "\t");
            System.out.print(qty	+ "\t");
            System.out.print(total);
            System.out.println();
        }

        reader.close();
        
        
        // 다른방법2
        /*
        list.clear(); // 리스트 안에 항목 전부 제거 후 파일 가져오기
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"));
        	//파일에서 List 꺼내오기
            list = (List<BookDTO>)ois.readObject();

        	for(BookDTO bookDTO : loadList) {
				list.add(bookDTO);
			}
            //파일에서 BookDTO 꺼내오기
            while(true) {
            	try {
					BookDTO bookDTO = (BookDTO)ois.readObject();
				
				} catch (EOFException  e) {
					break;
				}
            }
            ois.close();
        } catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		*/
	
	}
}
