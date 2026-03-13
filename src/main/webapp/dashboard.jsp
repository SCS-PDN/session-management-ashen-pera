<%@ page import="java.util.*, model.Course" %>

<h2>Available Courses</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Instructor</th>
<th>Enroll</th>
</tr>

<%
List<Course> courses = (List<Course>) request.getAttribute("courses");

for(Course c : courses){
%>

<tr>

<td><%= c.getCourseId() %></td>
<td><%= c.getCourseName() %></td>
<td><%= c.getInstructor() %></td>

<td>
<a href="EnrollServlet?courseId=<%=c.getCourseId()%>">
Enroll
</a>
</td>

</tr>

<%
}
%>

</table>

<br>

<a href="LogoutServlet">Logout</a>