package dbtestl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	private Connection con;
	private PreparedStatement pstmt;
	
	public InsertMain() {
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
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
		
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		
		System.out.print("키 입력 : ");
		double height = scan.nextDouble();
		
		this.getConnection(); // 호출
		System.out.println("실행");
		
		try {
			//sql문장을 실행해주는 가이드
			// "?"에 데이터를 매핑
			pstmt = con.prepareStatement("insert into dbtest values(?,?,?, sysdate)"); // 생성
		
			// 1~3 물음표 순번 
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);

			//실행 - 개수 리턴
			int su = pstmt.executeUpdate();
			System.out.println(su + "개 행이 삽입되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // finally : 에러와 상관없이 끝나면 실행 됨.ㄴ
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
	
	public static void main(String[] args) {
		new InsertMain().insertArticle(); // 1회만 생성자를 호출 하고 돌아옴.
		//InsertMain 실행 -> insertArticle 실행 -> getConnection 실행
	}
}
