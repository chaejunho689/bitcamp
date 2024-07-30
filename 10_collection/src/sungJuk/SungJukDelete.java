package sungJuk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {
	@Override
	public void execute(ArrayList<SungJukDTO> list) {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제 할 대상자의 이름 입력 ");
		String name = scan.next();
		
//		int count = 0;
		
		// 에러 이유 : list 사이즈는 내부에서 정하기 때문에
//		for(SungJukDTO sungJukDTO : list) {
//			if(sungJukDTO.getName().equals(name)) {
//				list.remove(sungJukDTO);
//			count++;
//			}
//		}
		
		for(int i = list.size()-1; i >= 0; i--) {
			if(list.get(i).getName().equals(name)) {
				list.remove(list.get(i));
//				count++;
			}
		}
		

		// Iterator가 더 좋은 방법
//		if(count == 0) {
//			System.out.println("회원 정보가 없습니다.");
//		} else
//			System.out.println(count + "건을 삭제하였습니다.");
		
		Iterator<SungJukDTO> it = list.iterator();
		while(it.hasNext()) {
			SungJukDTO sungJukDTO = it.next();
			if(sungJukDTO.getName().equals(name)) {
				it.remove();
				System.out.println("삭제하였습니다.");
				break;
			} else {
				System.out.println("회원 정보가 없습니다.");
				break;
			}
		}
	}
}
