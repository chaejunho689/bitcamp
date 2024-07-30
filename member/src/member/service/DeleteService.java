package member.service;

import java.util.Scanner;

public class DeleteService  implements Member {
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		while(true) {
			System.out.println("삭제할 할 아이디를 입력하세요.");
			String id = scan.next();
			
			System.out.println("비밀번호를 입력하세요.");
			String pwd = scan.next();
			
//			boolean exist = memberDAO.isExistId(id);
			String exist = memberDAO.isExistPwd(id, pwd);

			if(exist == null) {
				System.out.println("검색한 ID가 없거나 비밀번호가 틀렸습니다.");
				return;
			} else {
				memberDAO.delete(id);
				
				System.out.println("삭제가 완료되었습니다.");
				break;
			}
		}
	}
}
