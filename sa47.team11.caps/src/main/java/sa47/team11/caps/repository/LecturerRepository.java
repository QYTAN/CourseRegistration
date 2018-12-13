package sa47.team11.caps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa47.team11.caps.model.Course;
import sa47.team11.caps.model.StudentEnrolment;

public interface LecturerRepository extends JpaRepository<StudentEnrolment, Integer> {   //model class and its primary key data type

	//where  se.studentid=10 and se.courseid= 1;	@Query("select c.courseid, c.course_name, c.credit from caps_team11.student_enrolment se, caps_team11.course c where se.courseid=c.courseid and se.studentid=uid")  //select ... where student id =id and join both tables
	@Query("SELECT c FROM StudentEnrolment c where c.studentid = :studentid")//WHERE c.studentid = ?0   where c.userid =:uid
	ArrayList<StudentEnrolment> FindCourseidCoursenameCreditById(@Param("studentid") int uid);  
}
