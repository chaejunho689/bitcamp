package homework_;

import java.util.Scanner;

public class MemberService {
	private MemberDTO[] ar = new MemberDTO[5]; //5명 인원
	private Scanner scan = new Scanner(System.in);
	                                         
	//	menu 함수
	public void menuSelect() {
		System.out.print(
			"메뉴 입력해주세요. \n" +
			"************** \n" +
			"   1. 가입 \n" +
			"   2. 출력 \n" +
			"   3. 수정 \n" +
			"   4. 탈퇴 \n" +
			"   5. 끝내기 \n" +
			"************** \n"
			);
	
		while(true) {
			System.out.print("메뉴 입력 : ");
			int menu_num = scan.nextInt();
			boolean flag = false;
			
			switch(menu_num) {
				case 1 : 
					this.insert();
					break;
				case 2 : 
					this.list();
					break;
				case 3 : 
					this.update();
					break;
				case 4 : 
					this.delete();
					break;
				case 5 : 
					flag = true; 
					break;
				default : System.out.println("잘못 입력했습니다.");
			}
			
			if(flag == true) {
				break;
			}
		}
	}
	//	insert 함수
	public void insert() {
		// 정원이 가득 찼는지 체크
		if(fullCheck() == false) {
			return;
		}

		int count = binCheck();		
		ar[count] = new MemberDTO();

		System.out.print("이름 입력 : ");
		ar[count].setName(scan.next());
		
		System.out.print("나이 입력 : ");
		ar[count].setAge(scan.nextInt());

		System.out.print("핸드폰 입력 : ");
		ar[count].setCellphone(scan.next());
		
		System.out.print("주소 입력 : ");
		ar[count].setAddress(scan.next());
		System.out.println(count+1 + "번 회원으로 회원 가입이 완료되었습니다.");
	}
	
	//	list 함수
	public void list() {
		// 5명 정원 및 빈 배열 체크 
		if(nullCheck() == false) {
			return;
		}
		
		System.out.println("이름\t나이\t전화번호\t\t주소");
		for(int i = 0; i < ar.length; i++) {
			if(ar[i] != null) {
				System.out.println(ar[i].getName()+"\t"
				+ ar[i].getAge()+"\t"
				+ ar[i].getCellphone()+"\t\t"
				+ ar[i].getAddress());
			}
		}
	}
	
	//	update 함수
	public void update() {
		if(nullCheck() == false) {
			return;
		}
		
		System.out.println("수정할 회원의 전화번호를 입력하세요.");
		String cellphone_input = scan.next();

	    // 회원을 찾기 위한 반복문
	    int count = -1;
	    for (int i = 0; i < ar.length; i++) {
	        if (ar[i] != null && ar[i].getCellphone().equals(cellphone_input)) {
	            count = i;
	            break;
	        }
	    }

	    // 회원을 찾지 못한 경우
	    if (count == -1) {
	        System.out.println("찾는 회원이 없습니다.");
	        return;
	    }
		
		System.out.print("이름 입력 : ");
		ar[count].setName(scan.next());
		
		System.out.print("나이 입력 : ");
		ar[count].setAge(scan.nextInt());

		System.out.print("핸드폰 입력 : ");
		ar[count].setCellphone(scan.next());
		
		System.out.print("주소 입력 : ");
		ar[count].setAddress(scan.next());
		
        System.out.println("수정 완료 되었습니다.");

	}
	
	//	delete 함수 
	public void delete() {
		if(nullCheck() == false) {
			return;
		}
		
		System.out.println("삭제할 회원의 전화번호를 입력하세요.");
		String cellphone_input = scan.next();

	    // 회원을 찾기 위한 반복문
	    int count = -1;
	    for (int i = 0; i < ar.length; i++) {
	        if (ar[i] != null && ar[i].getCellphone().equals(cellphone_input)) {
	            count = i;
	            break;
	        }
	    }

	    // 회원을 찾지 못한 경우
	    if (count == -1) {
	        System.out.println("찾는 회원이 없습니다.");
	        return;
	    }
	    
	    // 회원정보 null값으로 초기화
		ar[count] = null;
	    
        System.out.println("삭제 완료 되었습니다.");
	}
	
	//리스트가 비어있는지 체크
	public boolean nullCheck() {
		int count = 0;
		
		for(int i = 0; i < ar.length; i++) {
			if(ar[i] == null) {
				count++;
			} else {
				count = 0;
			}
		}
		if(count == 5) {
			System.out.println("아직 회원이 아무도 없습니다.");
			return false; //회원이 1도 없음.
		} else {
			return true; //회원이 1명이상 존재함
		}
	}
	
	//5명 정원 다 찼는지 체크
	public boolean fullCheck() {
		int count = 0;
		
		for(int i = 0; i < ar.length; i++) {
			if(ar[i] != null) {
				count++;
			}
		}
		if(count == 5) {
			System.out.println("5명 정원이 가득 찼습니다.");
			return false; //회원이 꽉 참.
		} else {
			return true; //자리 존재 함.(가입 가능)
		}
	}
	
	//빈자리(배열번호) 체크
	public int binCheck() {
		int count = 0;
		
		for(int i = 0; i < ar.length; i++) {
			if(ar[i] == null) {
				count = i;
				break;
			}
		}
		return count;
	}
	
	//전화번호가 일치하는 멤버 검색 후 배열번호 리턴 
	public int findMemer(String cp) {
		System.out.println("debug find member");
		int count = 0;

		for(int i = 0; i < ar.length; i++) {
			if(ar[i].getCellphone().equals(cp)) {
				count = i;
			}
		}
		return count;
	}
	
	public boolean findMemberCheck(String cp) {
		System.out.println("debug find member check");
		int count = 0;

		for(int i = 0; i < ar.length; i++) {
			if(!ar[i].getCellphone().equals(cp)) {
				count++;
			}
		}
		if(count > 5) {
			System.out.println("찾는 회원이 없습니다.");
			return false; // 존재하지 않음.
		} else {
			return true; // 존재 함.
		}
	}
	
}
