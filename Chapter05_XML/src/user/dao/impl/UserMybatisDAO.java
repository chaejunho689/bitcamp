package user.dao.impl;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserMybatisDAO implements UserDAO {
	@Setter
	private SqlSession sqlSession;
	
	@Override
	@Transactional
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	@Transactional
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	@Transactional
	public UserDTO getExistId(String id) {
		return sqlSession.selectOne("userSQL.getExistId", id);
	}

	@Override
	@Transactional
	public void update(Map<String, String> map) {
		sqlSession.update("userSQL.update", map);
	}

	@Override
	@Transactional
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	}
	
}


