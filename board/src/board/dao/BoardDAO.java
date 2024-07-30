package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.bean.BoardDTO;

public class BoardDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public String session_id = null;
	public String session_pwd = null;
	public String session_name = null;
	private boolean login_yn;

	
	
	private static BoardDAO instance = new BoardDAO();
	
	public BoardDAO() {
		try {
			Class.forName(driver);
			System.out.println("driver loading...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() {
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
	
	
	public boolean isExistId(String id) {
		boolean exist = false;
		
		getConnection();
		try {
			pstmt = con.prepareStatement("SELECT ID FROM food_account WHERE ID = ?");
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
	
	public void register(BoardDTO boardDTO) {
		getConnection();
		String sql = "INSERT INTO food_account(NAME, ID, PWD, logtime) VALUES(?, ?, ?, sysdate)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,boardDTO.getName());
			pstmt.setString(2,boardDTO.getId());
			pstmt.setString(3,boardDTO.getPwd());
			
			pstmt.executeUpdate();
			System.out.println("회원가입이 완료되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void login(String id, String pwd) {

		getConnection();
		
		try {
			pstmt = con.prepareStatement("SELECT ID, PWD, NAME FROM food_account WHERE ID = ? and PWD = ?");
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				session_id = rs.getString("ID");
				session_pwd = rs.getString("PWD");
				session_name = rs.getString("NAME");
				login_yn = true;
			}
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
		
	}
	
	// 로그인 여부 체크 
	public boolean login_check() {
		if(login_yn == false) {
			System.out.println("로그인이 필요한 서비스입니다.");
			return false;
		}
		System.out.println(session_name + "님 접속되었습니다.");
		return true;
	// if(boardDAO.login_check() == false)	return; <이것 서비스에 넣어서 사용
	}
	
	
	public void logout() {
		login_yn = false;
		session_id = null;
		session_pwd = null;
		
		System.out.println("로그아웃 되었습니다.");
		
	}
	
	
	public void boardWrite(BoardDTO boardDTO) {
		getConnection();
		String sql = "INSERT INTO BOARD_JAVA(seq, id, name, subject, content, logtime) VALUES(BOARD_JAVA_SEQ.NEXTVAL,?, ?, ?, ?, sysdate)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,boardDTO.getId());
			pstmt.setString(2,boardDTO.getName());
			pstmt.setString(3,boardDTO.getSubject());
			pstmt.setString(4,boardDTO.getContent());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void boardList() {
		getConnection();
		
		try {
			pstmt = con.prepareStatement("SELECT SEQ,NAME,SUBJECT,CONTENT,TO_CHAR(LOGTIME, 'YYYY/MM/DD') AS LOGTIME FROM board_java");

			rs = pstmt.executeQuery();
			
			if(rs == null) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			
			System.out.println("---------------------------------------------------------");
			System.out.println("글번호\t작성자\t제목\t작성시간");
			System.out.println("---------------------------------------------------------");
			while(rs.next()) {
				System.out.printf("%2s %8s %14s %20s\n",
								rs.getString("SEQ"),
								rs.getString("NAME"),
								rs.getString("SUBJECT"),
								rs.getString("LOGTIME")
						);
			} 
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
	}
	
	public void boardView(int num) {
		getConnection();
		
		try {
			pstmt = con.prepareStatement("SELECT SEQ,NAME,ID, SUBJECT,CONTENT, TO_CHAR(LOGTIME, 'YYYY/MM/DD') AS LOGTIME FROM board_java WHERE SEQ=?");
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();
			
			if(rs == null) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			
			System.out.print("글번호\t작성자ID\t작성자이름\n");
			while(rs.next()) {
				System.out.println(
						  rs.getString("SEQ") + "\t"
						+ rs.getString("ID") + "\t"
						+ rs.getString("NAME") + "\n"
						+ "날짜 : " + rs.getString("LOGTIME")  + "\n"
						+ "내용 : " + rs.getString("CONTENT")
						);
			} 
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
	}
}
