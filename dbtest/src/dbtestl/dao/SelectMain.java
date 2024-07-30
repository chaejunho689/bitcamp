package dbtestl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMain {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	private String sql = null;
	private ResultSet rs;
	private Connection con;
	private PreparedStatement pstmt;
	Scanner scan = new Scanner(System.in);

	public SelectMain() {
		try {
			Class.forName(driver);
			System.out.println("driver loading");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Oracle 접속 ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void selectArticle() {
		getConnection(); // 1. 오라클 접속
		sql = "SELECT * FROM DBTEST";
		try {
			pstmt = con.prepareStatement(sql); //sql문 실행 
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t"
						+ rs.getInt("age") + "\t"
						+ rs.getDouble("height") + "\t"
						+ rs.getString("logtime") + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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
	
	public static void main(String[] args) {
		new SelectMain().selectArticle();
	}
}
