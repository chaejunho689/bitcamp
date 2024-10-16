package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="hello.do", method=RequestMethod.GET)
	public ModelAndView hello() {  //사용자 만든 콜백메서드
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring MVC!!");
		mav.setViewName("hello"); //JSP 파일이름 => /WEB-INF/hello.jsp
		return mav;
	}

}
