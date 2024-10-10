package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="hello.do", method=RequestMethod.GET)
	public ModelAndView hello() { //사용자 만든 콜백메서드
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring MVC!!");
		mav.setViewName("/view/hello"); //JSP 파일이름  hello.jsp 파일을 찾는다.
		return mav;
	}
	
	@RequestMapping(value="hello2.do", method=RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String hello2() {
		return "<h3> 스프링 테스트 </h3>";
	}
}
/*
URL에서 바로 jsp가 실행되지 않게 하기 위해서 /WEB-INF에 JSP 파일을 작성한다.
http://localhost:8080/Chapter06/WEB-INF/hello.jsp 실행할 수 없다.

스프링에서 return Type이 String이면 단순문자열이 아니라, JSP 파일명으로 인식한다.
만약 단순 문자열로 처리하고 싶으면 브라우저에 바로 뿌리려면 @ResponseBody를 써야 한다.


return의 한글 String은 
 produces = "text/html; charset=UTF-8"
 를 써야 한글이 깨짐없이 나오게 된다.
*/