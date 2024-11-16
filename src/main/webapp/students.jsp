<%@ page import="java.util.List" %>
<%@ page import="com.example.studentlessonservlet.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Hend
  Date: 15.11.2024
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<h2>Student:</h2><a href="/addStudent">Add Student</a> | <a href="index.jsp">Main</a><br>
<% List<Student> students = (List<Student>) request.getAttribute("students");%>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>age</th>
        <th>lesson_id</th>
    </tr>
    <% for (Student student : students) { %>

    <tr>
        <td><%=student.getId() %>></td>
        <td><%=student.getName() %>></td>
        <td><%=student.getSurname() %>></td>
        <td><%=student.getEmail() %>></td>
        <td><%=student.getAge()%>></td>
        <td><%=student.getLesson().getId()%>></td>
        <td><a href="/deleteStudent?id=<%= student.getId()%>">DELETE</a> / <a href="/editStudent?id=<%= student.getId()%>">EDIT</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
