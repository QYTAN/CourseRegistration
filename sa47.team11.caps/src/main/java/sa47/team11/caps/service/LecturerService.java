package sa47.team11.caps.service;

import java.util.ArrayList;

import sa47.team11.caps.model.Course;
import sa47.team11.caps.model.StudentEnrolment;
import sa47.team11.caps.model.User;

public interface LecturerService {
	ArrayList<StudentEnrolment> FindCourseidCoursenameCreditById(int uid);   //function from repository
	//method to be implemented in LecturerServiceImpl
	
	/*ArrayList<StudentEnrolment> FindScoreById(int uid);*/
	
	int updateUser(User u);

	User findUserById(Integer id);
}
