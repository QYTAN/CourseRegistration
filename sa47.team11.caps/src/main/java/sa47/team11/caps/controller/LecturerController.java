package sa47.team11.caps.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sa47.team11.caps.model.StudentEnrolment;
import sa47.team11.caps.service.LecturerService;

@Controller
/*@RequestMapping(value = "/home")*/

public class LecturerController {
	@Autowired
	private LecturerService lservice;
	
/*	@RequestMapping(value="/lecturer", method = RequestMethod.GET)
	public ModelAndView lecturer() {
		//model.addAttribute("user", new User());
		return new ModelAndView("lecturer");
	}*/
	
	@RequestMapping(value="/lecturer/viewstudent/{uid}", method = RequestMethod.GET)
	public ModelAndView viewStudentById(@PathVariable int uid, Model model) {
		ModelAndView mav = new ModelAndView("viewstudentbyid");
		ArrayList<StudentEnrolment> courses = lservice.FindCourseidCoursenameCreditById(uid);
		/*ArrayList<StudentEnrolment> scores = lservice.FindScoreById(uid);*/
		model.addAttribute("courses",courses);
		/*model.addAttribute("scores", scores);*/
		return mav;
	}
	
/*	@RequestMapping(value="/lecturer/viewstudent/edit/{uid}", method = RequestMethod.GET)
	public ModelAndView editScores() {
		//model.addAttribute("user", new User());
		return new ModelAndView("editscore");
	}*/
/*	public ModelAndView editScores(@PathVariable int uid) {
		ModelAndView mav = new ModelAndView("editscore");
		lservice.updateUser(user);
		ArrayList<Course> courses = lservice.FindCourseidCoursenameCreditById(uid);
		ArrayList<StudentEnrolment> scores = lservice.FindScoreById(uid);
		model.addAttribute("courses",courses);
		model.addAttribute("scores", scores);
		ModelAndView mav 
		return mav;
	}*/

	
	
/*	@RequestMapping(value="/lecturer/viewstudent", method = RequestMethod.GET)
	public ModelAndView viewstudent() {
		ModelAndView mav = new  ModelAndView("lecturer/viewstudent", "user", new User());
		return mav;
	}*/
}
