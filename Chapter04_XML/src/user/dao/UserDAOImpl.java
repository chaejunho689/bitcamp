package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.lang.Nullable;

import user.bean.UserDTO;

/*
@Setter
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

@Nullable
private JdbcTemplate jdbcTemplate = null;
	
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
*/

/*
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {


	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}
	
	
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
	}
}
*/


// NamedParameterJdbcDaoSupport-> paramter를 map형태로 :value 로 전달
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

	@Override
	public void write(UserDTO userDTO) {
		Map<String, String> map = new HashMap<>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		String sql = "insert into usertable values(:name,:id,:pwd)";
		getNamedParameterJdbcTemplate().update(sql, map);
	}
	
	
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		
	}


//	Rowmapper 행단위
	@Override
	public UserDTO getExistId(String id) {
		String sql = "select * from usertable where id = ?";
		try {
			
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO> (UserDTO.class),id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}


	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}


	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=?";
		getJdbcTemplate().update(sql, id);
		
	}
	
}


