package member.service;

import java.util.Scanner;

public class LoginService implements Member {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		// DB - 싱글톤 
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		while(true) {
			System.out.println("아이디를 입력하세요.");
			String id = scan.next();
			
			System.out.println("비밀번호를 입력하세요.");
			String pwd = scan.next();

			String name = memberDAO.isExistPwd(id, pwd);
			
			if(name == null) {
				System.out.println("아이디 또는 비밀번호가 잘못되었습니다..");
			} else {
				System.out.println(name + "님이 로그인하였습니다.");
				break;
			}
		}
	}
}
