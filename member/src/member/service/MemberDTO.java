package member.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO {
	private String name;
	private String id;
	private String pwd;
	private String phone;
	
	@Override
	public String toString() {
		return name + "\t"
				+ id + "\t"  
				+ pwd + "\t"
				+ phone + "\t";
	}
	
	
}
