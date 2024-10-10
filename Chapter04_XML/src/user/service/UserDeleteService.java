package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;


@Setter
@Service
public class UserDeleteService implements UserService {
	private UserDAO userDAO;
	private String id;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제 할 아이디 입력 : ");
		String id = scan.next();
		
		UserDTO userDTO = userDAO.getExistId(id);
		
		if(userDTO == null ) {
			System.out.println("찾고자 하는 ID가 없습니다.");
			return;
		}
		
		userDAO.delete(id);
		
		System.out.println(id + "님의 데이터를 삭제하였습니다.");
		
	}
}
