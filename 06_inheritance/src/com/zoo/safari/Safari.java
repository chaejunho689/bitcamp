package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo { //
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.tiger();
		zoo.elephant();
		zoo.giraffe();
		zoo.lion();
		
		
		Safari safari = new Safari();
		safari.tiger();
		safari.giraffe(); // 자식 클래스일 때는 가능
		safari.elephant();
		safari.lion();
	}
}
