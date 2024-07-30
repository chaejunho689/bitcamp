package member.service;

import java.util.Scanner;


public class WriteService implements Member {
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		// DB - 싱글톤 
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		System.out.println("이름을 입력하세요.");
		String name = scan.next();
		
		while(true) {
			System.out.println("아이디를 입력하세요.");
			String id = scan.next();
			
			//DB
			boolean exist = memberDAO.isExistId(id);
			
			
			if(exist == true) {
				System.out.println("중복된 ID입니다.");
				return;
			} else {
				System.out.println("사용 가능한 아이디입니다.");
				System.out.println("비밀번호를 입력하세요.");
				String pwd = scan.next();
		
				System.out.println("휴대폰 번호를 입력하세요.(xxx-xxxx-xxxx)");
				String phone = scan.next();
		
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setName(name);
				memberDTO.setId(id);
				memberDTO.setPwd(pwd);
				memberDTO.setPhone(phone);
				
			
				
				//입력
				int su = memberDAO.write(memberDTO);
			
				System.out.println(su + "개의 행이 만들어졌습니다. ");
			}
		}
		
	}
}
