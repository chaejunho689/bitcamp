package Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class AccountDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@192.168.0.43:1521:xe";
	private String username = "c##java";
	private String password = "1234";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public String session_id = null;
	public String session_pwd = null;
	public String session_name = null;
	public boolean login_yn = false;
	public int session_auth;

	private static AccountDAO instance = new AccountDAO();
	
	public AccountDAO() {
		try {
			Class.forName(driver);
			//			System.out.println("driver loading...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static AccountDAO getInstance() {
		return instance;
	}
	
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
			//			System.out.println("Oracle Connect...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void register(String user_id, String user_pw, String user_name, String user_email, String user_address, String user_phonenumber) {
		getConnection();
		String sql = "INSERT INTO USER_ACCOUNT(USER_ID, USER_PW, USER_NAME, USER_EMAIL, USER_ADDRESS, USER_PHONENUMBER, USER_NO) VALUES(?, ?, ?, ?, ?, ?, FOOD_SEQUENCE.NEXTVAL)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,user_id);
			pstmt.setString(2,user_pw);
			pstmt.setString(3,user_name);
			pstmt.setString(4,user_email);
			pstmt.setString(5,user_address);
			pstmt.setString(6,user_phonenumber);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public String login(String user_id, String user_pw) {
		String result = "fail";
		getConnection();

		try {
			pstmt = con.prepareStatement("SELECT USER_ID, USER_PW, USER_NAME FROM USER_ACCOUNT WHERE USER_ID = ? and USER_PW = ?");
			pstmt.setString(1,user_id);
			pstmt.setString(2,user_pw);

			rs = pstmt.executeQuery();
	        if (rs.next()) {
	            result = "success";
	            System.out.println("로그인 성공: ID=" + user_id + ", PW=" + user_pw);
	        } else {
	            System.out.println("로그인 실패: 아이디 또는 비밀번호가 일치하지 않습니다.");
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
		
		return result;
	}
	
	// AccountDTO를 반환하는 메서드 추가
    public AccountDTO getAccountById(String userId) {
        AccountDTO account = null;
        getConnection();

        try {
            String sql = "SELECT USER_ID, USER_PW, USER_NAME, USER_EMAIL, USER_ADDRESS, USER_PHONENUMBER FROM USER_ACCOUNT WHERE USER_ID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String userPw = rs.getString("USER_PW");
                String userName = rs.getString("USER_NAME");
                String userEmail = rs.getString("USER_EMAIL");
                String userAddress = rs.getString("USER_ADDRESS");
                String userPhoneNumber = rs.getString("USER_PHONENUMBER");

                account = new AccountDTO(userId, userPw, userName, userEmail, userAddress, userPhoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return account;
    }

    // 자원 해제 메서드
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
}
