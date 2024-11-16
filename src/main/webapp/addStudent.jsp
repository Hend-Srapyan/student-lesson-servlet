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
    <title>Add Student</title>
</head>
<body>
<h1>Add Student</h1>
<a href="/students">Students</a> | <a href="index.jsp">Main</a> <br>
<form action="/addStudent" method="post">
    Name: <input type="text" name="name"><br>
    Surname: <input type="text" name="surname"><br>
    Email: <input type="text" name="email"><br>
    Age: <input type="text" name="age"><br>
    Lesson ID: <input type="text" name="lessonId"><br>
    </select>
    <br>
    <input type="submit" value="ADD">

</form>
</body>
</html>
