package school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SchoolMain {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "1234";
	private String sql = null;
	private Connection con;
	private PreparedStatement pstmt;
	Scanner scan = new Scanner(System.in);
	private String name;
	private String value;
	private int sqlkind;
	private ResultSet rs;
	
	public SchoolMain() {
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
	
	public void menu() {
		int num = 0;
		
		while(true) {
			System.out.println("\n\t학교 관리 메뉴");
			System.out.println("**********************************");
			System.out.println("1. 입력 : ");
			System.out.println("2. 검색 : ");
			System.out.println("3. 삭제 : ");
			System.out.println("4. 종료 : ");
			System.out.println("**********************************");
			System.out.print("번호 : ");
			num = scan.nextInt();
			
			if(num == 4) break;
			if(num == 1) {
				insertArticle();
			} else if (num == 2) {
				searchArticle();
			} else if (num == 3) {
				deleteArticle();
			} else {
				System.out.println("1~4번 중에 선택하세요.");
				break;
			}
		}
	}
			
			
		
	public void insertArticle() {
		sql = "INSERT INTO SCHOOL VALUES(?,?,?)";
		int num = 0;
		String group = null;
		System.out.println("1. 학생 ");
		System.out.println("2. 교수 ");
		System.out.println("3. 관리자 ");
		System.out.println("4. 이전메뉴 ");
		System.out.print("번호 : ");
		num = scan.nextInt();
		sqlkind = num; //학생, 교수, 관리자 구분 코드를 전역 함수에서 받음.
		
		if(sqlkind == 1) { group = "학번"; } 
		else if(sqlkind == 2) { group = "담당 과목"; }
		else if(sqlkind == 3) { group = "담당 부서"; }
		
		if(num == 4) {
			menu();
		} else {
			if(sqlkind > 0 && sqlkind <= 3) {
				System.out.print("이름 입력 : ");
				name = scan.next();
				
				System.out.print(group + "입력 : ");
				value = scan.next();
				
				getConnectionExecuteInsert(); // 공통 실행 부분
			} else {
				System.out.println("잘못 선택했습니다. ");
				insertArticle();
			}
		}

	}
	
	
	public void searchArticle() {
		int num = 0;
		System.out.println("1. 이름 검색 ");
		System.out.println("2. 전체 검색 ");
		System.out.println("3. 이전메뉴 ");
		System.out.print("번호 : ");
		num = scan.nextInt();
		
		if(num == 3) {
			menu();
		} else {
			if(num == 1) {
				System.out.print("이름 입력 : ");
				name = scan.next();
				getConnectionExecuteSearch(name); // 공통 실행 부분
			} else if(num == 2) {
				getConnectionExecuteSearchEntire(); // 공통 실행 부분
			} else {
				System.out.println("잘못 선택했습니다. ");
				insertArticle();
			}
		}
	}
	
	
	public void updateArticle() {
		sql = "UPDATE SCHOOL SET VALUES=? WHERE NAME=?";
	}
	
	public void deleteArticle() {
		sql = "DELETE SCHOOL WHERE NAME=?"; 
		
		System.out.print("삭제할 이름 입력 : ");
		name = scan.next();
		getConnectionExecuteDelete(); // 공통 실행 부분
	}
	
	
	
	// insert 문을 실행한다.
	public void getConnectionExecuteInsert() {
		this.getConnection(); // 호출
		System.out.println("실행");

		try {
			pstmt = con.prepareStatement(sql); // 생성
		
			pstmt.setString(1, name);
			pstmt.setString(2, value);
			pstmt.setInt(3, sqlkind); //분류코드 : 1학생 2교수 3관리자

			int su = pstmt.executeUpdate();
			System.out.println(su + "개 행이 삽입되었습니다.");
			
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
	
	// delete 문을 실행한다.
	public void getConnectionExecuteDelete() {
		this.getConnection(); // 호출
		System.out.println("실행");
		
		try {
			pstmt = con.prepareStatement(sql	); // 생성
		
			pstmt.setString(1, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + "개 행이 삭제되었습니다.");
			
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
	
	
	// search 문을 실행한다. (이름 일부 검색)
	public void getConnectionExecuteSearch(String name) {
		this.getConnection(); // 호출
		System.out.println("실행");
		
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM SCHOOL WHERE NAME LIKE ?"); // 생성
			pstmt.setString(1,"%" + name + "%");
			rs = pstmt.executeQuery();
			
			if(rs == null) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			
			while(rs.next()) {
				System.out.println(
						  "이름 : "
						+ rs.getString("NAME") + "\t"
						+ "상세 : "
						+ rs.getString("VALUE") + "\t"
						+ "분류 : "
						+ rs.getString("CODE")
						);
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
	}
	
	// search 문을 실행한다. (전체 검색)
	public void getConnectionExecuteSearchEntire() {
		this.getConnection(); // 호출
		System.out.println("실행");
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM SCHOOL WHERE NAME LIKE ?"); // 생성
			pstmt.setString(1,"%");
			
			rs = pstmt.executeQuery();
			if(rs == null) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			while(rs.next()) {
				System.out.println(
						  "이름 : "
						+ rs.getString("NAME") + "\t"
						+ "상세 : "
						+ rs.getString("VALUE") + "\t"
						+ "분류 : "
						+ rs.getString("CODE")
						);
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
	}
	
	
	
	
	
	public static void main(String[] args) {
//		SchoolMain schoolMain = new SchoolMain();
//		schoolMain.menu();
		//명시적 객체 참조: 인스턴스가 schoolMain 변수에 할당되어 있기 때문에, 
		//			    필요할 경우 schoolMain을 통해 나중에 다시 이 객체를 참조 가능
		
		new SchoolMain().menu();
		//익명 객체: 인스턴스를 변수에 할당하지 않고 바로 사용 
		//		   메서드 호출 후 이 인스턴스는 더 이상 참조되지 않기 때문에, 이후에 이 객체를 다시 사용 불가
		
		System.out.println("프로그램을 종료합니다.");
	}

}
