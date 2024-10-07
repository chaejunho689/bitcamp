package user.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.Setter;
import user.bean.UserDTO;

public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate = null;
		
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Override
	public void write(UserDTO userDTO) {
		// TODO Auto-generated method stub
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}
	
	
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
	}
}
