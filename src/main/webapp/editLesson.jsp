<%@ page import="com.example.studentlessonservlet.model.Lesson" %><%--
  Created by IntelliJ IDEA.
  User: Hend
  Date: 16.11.2024
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Lesson</title>
</head>
<body>
<%Lesson lesson = (Lesson) request.getAttribute("lesson"); %>
<h1>Edit Lesson</h1>
<a href="/lessons">Lessons</a> | <a href="index.jsp">Main</a><br>
<form action="/editLesson" method="post">
    <input type="hidden" name="id" value="<%=lesson.getId()%>"> <br>
    Name: <input type="text" name="name"><br>
    Duration: <input type="text" name="duration"><br>
    Lecturer Name: <input type="text" name="lecturerName"><br>
    Price: <input type="text" name="price"><br>
    </select>
    <br>
    <input type="submit" value="UPDATE">

</form>
</body>
</html>
