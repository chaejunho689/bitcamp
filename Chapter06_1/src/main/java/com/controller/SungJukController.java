package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;

@Component
@Controller
public class SungJukController {
	@RequestMapping(value="sungjuk/input.do", method = RequestMethod.GET)
	public String input(HttpSession httpSession
//			@ModelAttribute SungJukDTO sungJukDTO, Model model
			) {
		return "/sungjuk/input";
	}
	
	@RequestMapping(value="sungjuk/result.do", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String result(@ModelAttribute SungJukDTO sungJukDTO, ModelMap modelMap) {
		int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMat();
		double avg = tot / 3.;
		
		sungJukDTO.setTot(tot);
		sungJukDTO.setAvg(avg);
		modelMap.put("sungJukDTO", sungJukDTO);

		return "/sungjuk/result";
	}
	
}
