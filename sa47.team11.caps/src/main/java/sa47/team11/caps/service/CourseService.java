package sa47.team11.caps.service;

import java.util.List;

import sa47.team11.caps.model.Course;

public interface CourseService {
	List<Course> getAllCourses();
	List<String> getCourseNames();
}
