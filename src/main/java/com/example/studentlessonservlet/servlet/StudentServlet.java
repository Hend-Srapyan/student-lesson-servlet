package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.model.Student;
import com.example.studentlessonservlet.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> allStudents = studentService.getAllStudents();
        req.setAttribute("students", allStudents);
        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }
}
