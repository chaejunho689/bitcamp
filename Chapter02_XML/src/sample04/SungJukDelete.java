package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukDelete implements SungJuk {
	@Setter
	private List<SungJukDTO2> list;
	
	@Override
	public void execute(List<SungJukDTO2> list) {

		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 이름을 입력하세요.");
		String name = scan.next();
		
		System.out.println();
		int sw = 0;
		Iterator<SungJukDTO2> it = list.iterator();
		
		while(it.hasNext()) { //항목이 있으면 true, 없으면 false
			SungJukDTO2 sungJukDTO2 = it.next();
			//it가 가리키는 항목을 꺼내서 저장하고, it는 다음 항목으로 이동

			if(sungJukDTO2.getName().equals(name)) {
			sw=1;
			it.remove();
			System.out.println(name = "님의 데이터를 삭제했습니다.");
			
			break;
			} // while
		}
		if(sw == 0) {
			System.out.println("일치하는 이름이 없습니다.");
		}
	}
}
