package user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectService implements UserService {
	@Setter
	private UserDAO userDAO;
		
	@Override
	public void execute() {
		List<UserDTO> list = userDAO.getUserList();
		
		for(UserDTO userDTO :list ) {
			String id = userDTO.getId();
			String name = userDTO.getName();
			
			System.out.println("아이디 : "  +  id);
			System.out.println("이름 : "  +  name);
		}
		
	}
	
	

}
