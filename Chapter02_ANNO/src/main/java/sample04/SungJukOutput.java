package sample04;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SungJukOutput implements SungJuk {
	@Autowired
	@Qualifier("arrayList")
	private ArrayList<SungJukDTO2> list;
	
	@Override
	public void execute(List<SungJukDTO2> list) {
		System.out.println();
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO2 sungJukDTO2 : list) {
			System.out.println(sungJukDTO2);
		}
	}

}
