package sa47.team11.caps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the student_enrolment database table.
 * 
 */
@Entity
@Table(name="student_enrolment")
@NamedQuery(name="StudentEnrolment.findAll", query="SELECT s FROM StudentEnrolment s")
public class StudentEnrolment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_ENROL_ID")
	private int studentEnrolId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_REGISTERED")
	private Date dateRegistered;

	private int score;
	
	@Column(name="STUDENTID", nullable=false)
	private int studentid;

	@Column(name="STATUS_ENROLL")
	private String statusEnroll;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="COURSEID")
	private Course course;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="STUDENTID" , insertable=false, updatable=false)
	private User user;

	public StudentEnrolment() {
	}
	
	public int getStudentId() {
		return this.studentid;
	}

	public void setStudentId(int studentid) {
		this.studentid = studentid;
	}

	public int getStudentEnrolId() {
		return this.studentEnrolId;
	}

	public void setStudentEnrolId(int studentEnrolId) {
		this.studentEnrolId = studentEnrolId;
	}

	public Date getDateRegistered() {
		return this.dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getStatusEnroll() {
		return this.statusEnroll;
	}

	public void setStatusEnroll(String statusEnroll) {
		this.statusEnroll = statusEnroll;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}