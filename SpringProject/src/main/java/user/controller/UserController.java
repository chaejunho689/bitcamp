package user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping (value="user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="writeForm", method = RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(value="getExistId", method = RequestMethod.POST)
	@ResponseBody
	public String getExistId(String id) {
		return userService.getExistId(id);
	}
	
	@RequestMapping(value="write", method = RequestMethod.POST)
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(@RequestParam(required = false, defaultValue= "1") String pg, Model model) {
		Map<String, Object> map2 = userService.list(pg);
		
		map2.put("pg", pg);
		model.addAttribute("map2", map2);    
		
//		model.addAttribute("list", map2.get("list"));
//		model.addAttribute("userPaging", map2.get("userPaging"));
		return "/user/list";
	}

	@RequestMapping(value="updateForm", method = RequestMethod.GET)
	public String update(@RequestParam String id, @RequestParam String pg, ModelMap modelMap) {
		UserDTO userDTO =  userService.getUser(id);
		
		modelMap.put("pg", pg);
		modelMap.put("userDTO", userDTO);
		return "/user/updateForm";
	}

	@RequestMapping(value="update", method = RequestMethod.POST)
	@ResponseBody
	public void update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);
	}
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
	@ResponseBody
	public void delete(@ModelAttribute UserDTO userDTO) {
		userService.delete(userDTO);
	}

	
	
}
