<%@taglib uri ="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri = "http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>viewstudentbyid</title>
</head>
<body>

<h1 style="text-align:center">Student Performance</h1>
Student name

<div class="table-responsive">
  <table class="table table-striped">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">Course Id</th>
        <th scope="col">Course Name</th>
        <th scope="col">Credits</th>
        <th scope="col">Score</th>
        <th scope="col">Grade</th>
      </tr>
    </thead>
    <tbody>
		<c:forEach items ="${courses}" var= "course" varStatus="index">
			<tr>
		<td>${index.index+1}</td>  
		<td>${course.course.courseid}</td>  <!-- course variable is studentenrolment class from repository/service. To access courseid coursename we can access through course class because of mapping -->
		<td>${course.course.courseName}</td>
		<td>${course.course.credit}<c:set var = "totalcredit" value = "${credit + course.course.credit}"/><c:set var = "credit" value = "${course.course.credit}"/></td>
		<td>${course.score}</td>
<%-- 		<td>${course.user.userid}</td> --%>
		<td>
			<c:choose>
				<c:when test ='${course.score>80}'>A<c:set var = "coursegpa5" value = "5"/></c:when>
				<c:when test ='${course.score>70}'>B<c:set var = "coursegpa4" value = "4"/></c:when>
				<c:when test ='${course.score>60}'>C<c:set var = "coursegpa3" value = "3"/></c:when>
				<c:when test ='${course.score>50}'>D<c:set var = "coursegpa2" value = "2"/></c:when>
				<c:when test ='${course.score<50}'>F<c:set var = "coursegpa1" value = "1"/></c:when>
			</c:choose>
		</td>
		</tr>
		</c:forEach>
    </tbody>
  </table>
</div>

<%-- test:${coursegpa5}
test:${coursegpa4}
test:${coursegpa3}
test:${coursegpa2}
test:${coursegpa1}  


test:${coursegpa1 + coursegpa2 + coursegpa3 + coursegpa4 + coursegpa5}
test:${coursegpa3 * course.course.credit}   

test:${totalcredit}
test:${credit} --%> 
<div>
<c:set var="totalcredit" value="${0}"/>    <!-- create new variable and set to value 0 -->
<c:forEach var="course" items="${courses}">  <!-- for each course add credit to totalcredit -->
    <c:set var="totalcredit" value="${totalcredit + course.course.credit}" />
</c:forEach>
<c:set var = "CGPA" value = "${(coursegpa1*credit + coursegpa2*credit + coursegpa3*credit + coursegpa4*credit + coursegpa5*credit)/totalcredit}"/>
Total credits: <strong>${totalcredit}</strong>     CGPA:<strong>${CGPA}</strong> <c:choose><c:when test ='${CGPA>4}'>Honours</c:when><c:when test ='${CGPA>2.5}'>Merit</c:when><c:when test ='${CGPA<2.5}'><span style="color:red;">On probation</span></c:when></c:choose>
</div>
</body>
</html>