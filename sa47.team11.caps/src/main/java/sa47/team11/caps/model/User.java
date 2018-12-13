package sa47.team11.caps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_JOINED")
	private Date dateJoined;

	private String email;

	@Column(name="FIRST_MID_NAME")
	private String firstMidName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	private String status;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="user")
	private List<Course> courses;

	//bi-directional many-to-one association to StudentEnrolment
	@OneToMany(mappedBy="user")
	private List<StudentEnrolment> studentEnrolments;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="ROLEID")
	private Role role;

	public User() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getDateJoined() {
		return this.dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstMidName() {
		return this.firstMidName;
	}

	public void setFirstMidName(String firstMidName) {
		this.firstMidName = firstMidName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setUser(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setUser(null);

		return cours;
	}

	public List<StudentEnrolment> getStudentEnrolments() {
		return this.studentEnrolments;
	}

	public void setStudentEnrolments(List<StudentEnrolment> studentEnrolments) {
		this.studentEnrolments = studentEnrolments;
	}

	public StudentEnrolment addStudentEnrolment(StudentEnrolment studentEnrolment) {
		getStudentEnrolments().add(studentEnrolment);
		studentEnrolment.setUser(this);

		return studentEnrolment;
	}

	public StudentEnrolment removeStudentEnrolment(StudentEnrolment studentEnrolment) {
		getStudentEnrolments().remove(studentEnrolment);
		studentEnrolment.setUser(null);

		return studentEnrolment;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}*/

}