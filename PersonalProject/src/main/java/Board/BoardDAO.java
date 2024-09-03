package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;

import oracle.jdbc.proxy.annotation.Post;

public class BoardDAO {
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

	private static BoardDAO instance = new BoardDAO();
	
	public BoardDAO() {
		try {
			Class.forName(driver);
			//			System.out.println("driver loading...");
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
			//			System.out.println("Oracle Connect...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 // 게시글 목록 조회
	 public List<BoardDTO> getBoardList() {
	        List<BoardDTO> boardList = new ArrayList<>();
	        getConnection();
	        String sql = "SELECT BOARD_NO, BOARD_TITLE, BOARD_AUTHOR, BOARD_CONTENT, BOARD_HIT, BOARD_DATE FROM USER_BOARD ORDER BY BOARD_DATE";

	        try {
	            pstmt = con.prepareStatement(sql);
	            rs = pstmt.executeQuery();

	            while (rs.next()) {
	                int board_no = rs.getInt("BOARD_NO");
	                String board_title = rs.getString("BOARD_TITLE");
	                String board_author = rs.getString("BOARD_AUTHOR");
	                String board_content = rs.getString("BOARD_CONTENT");
	                String board_hit = rs.getString("BOARD_HIT");
	                String board_date = rs.getString("BOARD_DATE");

	                BoardDTO boardDTO = new BoardDTO(board_no, board_title, board_author, board_content, board_hit, board_date);
	                boardList.add(boardDTO);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (pstmt != null) pstmt.close();
	                if (con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return boardList;
	    }
	 
	 // 게시글 작성 
	    public void writePost(String title, String content, String author) {
	        getConnection();
	        String sql = "INSERT INTO USER_BOARD(BOARD_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_AUTHOR, BOARD_HIT, BOARD_DATE) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, SYSDATE)";
	        
	        try {
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, title);
	            pstmt.setString(2, content);
	            pstmt.setString(3, author);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(pstmt != null) pstmt.close();
	                if(con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    // 게시글 번호로 게시글 조회
	    public BoardDTO getBoardByNo(int board_no) {
	        getConnection();

	        String sql = "SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_AUTHOR, BOARD_HIT, TO_CHAR(BOARD_DATE, 'YYYY-MM-DD HH24:MI:SS') AS BOARD_DATE "
	                   + "FROM USER_BOARD WHERE BOARD_NO = ?";
	        
	        BoardDTO board = null;

	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setInt(1, board_no);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                board = new BoardDTO(
	                    rs.getInt("BOARD_NO"),
	                    rs.getString("BOARD_TITLE"),
	                    rs.getString("BOARD_CONTENT"),
	                    rs.getString("BOARD_AUTHOR"),
	                    rs.getString("BOARD_HIT"),
	                    rs.getString("BOARD_DATE")
	                );
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(pstmt != null) pstmt.close();
	                if(con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return board;
	    }
	    
	    
	    // 조회수 증가 메서드
	    public void increaseHit(int board_no) {
	        getConnection();
	        
	        String sql = "UPDATE USER_BOARD SET BOARD_HIT = BOARD_HIT + 1 WHERE BOARD_NO = ?";

	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setInt(1, board_no);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
} // END
