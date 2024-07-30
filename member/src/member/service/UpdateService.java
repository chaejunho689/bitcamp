package member.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UpdateService implements Member{
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		MemberDAO memberDAO = MemberDAO.getInstance();

		while(true) {
			System.out.println("업데이트 할 아이디를 입력하세요.");
			String id = scan.next();

//			boolean exist = memberDAO.isExistId(id);
//
//			if(exist == false) {
//				System.out.println("검색한 ID가 없습니다.");
//				return;
//			} else {
				
				// 검색 된 ID의 select 정보 출력
				MemberDTO memberDTO = memberDAO.getMember(id);
				
				if(memberDTO == null) {
					System.out.println("검색 된 ID가 없습니다.");
					return;
				}
				
				System.out.println("이름\tID\t패스워드\t전화번호");
				System.out.println(memberDTO);

				System.out.println("변경할 이름을 입력하세요..");
				String name = scan.next();
	
				System.out.println("변경할 비밀번호를 입력하세요.");
				String pwd = scan.next();
				
				System.out.println("전화번호를 입력하세요.");
				String phone = scan.next();
				
				//방법1
				memberDAO.update(id,pwd,phone,name);
				
				//방법2
				Map<String, String> map = new HashMap<>();
				map.put("name", name);
				
				System.out.println("수정이 완료되었습니다.");
				break;
//			}
		}
		
	}
}

