<%--
  Created by IntelliJ IDEA.
  User: Hend
  Date: 16.11.2024
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Lesson</title>
</head>
<body>
<h1>Add Lesson</h1>
<a href="/lessons">Lessons</a> | <a href="index.jsp">Main</a> <br>
<form action="/addLesson" method="post">
    Name: <input type="text" name="name"><br>
    Duration: <input type="text" name="duration"><br>
    Lecturer Name: <input type="text" name="lecturerName"><br>
    Price: <input type="text" name="price"><br>
</select>
    <br>
    <input type="submit" value="ADD">

</form>
</body>
</html>
