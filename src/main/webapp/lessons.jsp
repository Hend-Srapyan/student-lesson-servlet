<%@ page import="com.example.studentlessonservlet.model.Lesson" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Hend
  Date: 15.11.2024
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lessons</title>
</head>
<body>
<h2>Lessons:</h2><a href="/addLesson">Add Lesson</a> | <a href="index.jsp">Main</a><br>
<% List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons"); %>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>duration</th>
        <th>lecturerName</th>
        <th>price</th>
    </tr>
    <% for (Lesson lesson : lessons) { %>
    <tr>
        <td><%=lesson.getId() %>></td>
        <td><%=lesson.getName() %>></td>
        <td><%=lesson.getDuration() %>></td>
        <td><%=lesson.getLecturerName() %>></td>
        <td><%=lesson.getPrice() %>></td>
        <td><a href="/deleteLesson?id=<%= lesson.getId()%>">DELETE</a> / <a href="/editLesson?id=<%= lesson.getId()%>">EDIT</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
