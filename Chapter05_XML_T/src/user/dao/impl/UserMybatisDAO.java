package user.dao.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;

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
