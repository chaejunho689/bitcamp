package com.guestbook.dao;

import com.guestbook.bean.GuestbookDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@192.168.0.43:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	
	private PreparedStatement pstmt;
	private Connection con;
	private ResultSet rs;
	
	
	public GuestbookDAO() {
		try {
			Class.forName(driver);
			//			System.out.println("driver loading...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static GuestbookDAO guestbookDAO = new GuestbookDAO();
		
	public static GuestbookDAO getInstance() {
		return guestbookDAO;
	}
	
	
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void guestbookWrite(GuestbookDTO guestbookDTO) {
		getConnection();
		String sql = "INSERT INTO GUESTBOOK(SEQ, NAME, EMAIL, HOMEPAGE, SUBJECT, CONTENT, LOGTIME) VALUES(seq_guestbook.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,guestbookDTO.getName());
			pstmt.setString(2,guestbookDTO.getEmail());
			pstmt.setString(3,guestbookDTO.getHomepage());
			pstmt.setString(4,guestbookDTO.getSubject());
			pstmt.setString(5,guestbookDTO.getContent()); 
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<GuestbookDTO> guestbookList(int startNum, int endNum) {
        List<GuestbookDTO> guestbookList = new ArrayList<GuestbookDTO>();
        
		getConnection();
		String sql = "SELECT * FROM("
				+ "SELECT ROWNUM RN, TT.* FROM( "
				+ "SELECT SEQ, NAME, EMAIL, HOMEPAGE, SUBJECT, CONTENT, LOGTIME FROM GUESTBOOK ORDER BY LOGTIME"
				+ ") TT"
				+ ") WHERE RN >= ? AND RN <= ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,startNum);
			pstmt.setInt(2,endNum);
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
		        GuestbookDTO guestbookDTO = new GuestbookDTO();
		        
		        guestbookDTO.setSeq(rs.getInt("seq"));
		        guestbookDTO.setName(rs.getString("name"));
		        guestbookDTO.setEmail(rs.getString("email"));
		        guestbookDTO.setHomepage(rs.getString("homepage"));
		        guestbookDTO.setSubject(rs.getString("subject"));
		        guestbookDTO.setContent(rs.getString("content"));
		        guestbookDTO.setLogtime(rs.getDate("logtime"));

		        guestbookList.add(guestbookDTO);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			guestbookList = null;
		} finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return guestbookList;
	}

} // end


/*
1.Driver loading
2. connection
3.preparedStatement
 
*/