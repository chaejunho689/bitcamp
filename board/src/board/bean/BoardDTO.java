package board.bean;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDTO {
	private String id;
	private String pwd;
	private String name;
	private String subject;
	private String content;
	private Date logtime;
	private int seq;
	
	@Override
	public String toString() {
		return name + "\t"
				+ seq + "\t"  
				+ id + "\t"  
				+ pwd + "\t"  
				+ name + "\t"
				+ subject + "\t"
				+ content + "\t"
				+ logtime + "\t";
	}
	
	
}
