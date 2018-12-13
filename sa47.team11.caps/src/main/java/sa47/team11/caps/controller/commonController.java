package sa47.team11.caps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sa47.team11.caps.service.UserService;
import sa47.team11.caps.model.User;



@Controller
@RequestMapping(value = "/home")
public class commonController {
	
	@Autowired
	private UserService uService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute("user") User user, HttpSession session, BindingResult result) {
		//ModelAndView mav = 
		if (result.hasErrors())
			return new ModelAndView("login");
		//UserSession us = new UserSession();
		if (user.getEmail() != null && user.getPassword() != null) {
			User u = uService.authenticate(user.getEmail(), user.getPassword());
			if(u == null) {
				return new ModelAndView("login");
			}
			//us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			//us.setSessionId(session.getId());
			//us.setEmployee(eService.findEmployeeById(us.getUser().getEmployeeId()));
			//ArrayList<Employee> subordinates = eService.findSubordinates(us.getUser().getEmployeeId());
			//if (subordinates != null) {
			//	us.setSubordinates(subordinates);

			//}
			return new ModelAndView("redirect:/course/index");
		} else {
			return new ModelAndView("login");
		}
	//	session.setAttribute("USERSESSION", us);
		//return mav;
	}
}
