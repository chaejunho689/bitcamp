package homework_;

public class MemberDTO {
	private String name, cellphone, address;
	private int age;
	
	// SETTER
	// 이름
	public void setName(String s) {
		this.name = s;
	}
	
	// 주소
	public void setAddress(String s) {
		this.address = s;
	}
	
	// 휴대폰번호
	public void setCellphone(String s) {
		this.cellphone = s;
	}
	
	// 나이
	public void setAge(int n) {
		this.age = n;
	}
	
	// GETTER
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	
	public int getAge() {
		return age;
	}


	

}
