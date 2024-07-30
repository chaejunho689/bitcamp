package member.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static MemberDAO instance = new MemberDAO();
//	private static MemberDAO instance;
	
	public MemberDAO() {
		try {
			Class.forName(driver);
			System.out.println("driver loading...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 싱글톤
	public static MemberDAO getInstance() {
//		if(instance == null) {
//			synchronized (MemberDAO.class) {
//				instance = new MemberDAO();
//			}
//		}
		return instance;
	}
	
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Oracle Connect...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int write(MemberDTO memberDTO) {
		int su = 0;
		
		getConnection();
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,memberDTO.getName());
			pstmt.setString(2,memberDTO.getId());
			pstmt.setString(3,memberDTO.getPwd());
			pstmt.setString(4,memberDTO.getPhone());
			
//			pstmt.execute();
			
			su = pstmt.executeUpdate();
			System.out.println(su + "개 행이 삽입되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return su;
	}

	public boolean isExistId(String id) {
		boolean exist = false;
		
		getConnection();
		try {
			pstmt = con.prepareStatement("SELECT ID FROM MEMBER WHERE ID = ?");
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) exist = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // finally : 에러와 상관없이 끝나면 실행 됨.
			// 거꾸로 close 해줘야 함.
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		return exist;
	}
	
	public String isExistPwd(String id, String pwd) {
		String name = null;
		
		getConnection();
		try {
			pstmt = con.prepareStatement("SELECT name FROM MEMBER WHERE ID = ? AND PWD = ?");
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return name;
	}
	
	
	
	public void update(String id,String pwd,String phone,String name) {
		getConnection();
		String sql = "UPDATE MEMBER SET NAME = ?, PWD = ?, PHONE = ? WHERE ID= ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,name);
			pstmt.setString(2,pwd);
			pstmt.setString(3,phone);
			pstmt.setString(4,id);
			
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	public void delete(String id) {
		getConnection();
		String sql = "DELETE MEMBER WHERE ID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,id);
//			pstmt.setString(2,pwd);
			
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	public MemberDTO getMember(String id) {
		getConnection();
		String sql = "SELECT * FROM MEMBER WHERE ID= ?";
		
		MemberDTO memberDTO = null;         
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("NAME"));
				memberDTO.setId(rs.getString("ID"));
				memberDTO.setPwd(rs.getString("PWD"));
				memberDTO.setPhone(rs.getString("PHONE"));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}
	
	
}
