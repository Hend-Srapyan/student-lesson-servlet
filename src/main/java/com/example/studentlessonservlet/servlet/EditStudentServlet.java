package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.model.Lesson;
import com.example.studentlessonservlet.model.Student;
import com.example.studentlessonservlet.service.LessonService;
import com.example.studentlessonservlet.service.StudentService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    private final StudentService studentService = new StudentService();
    private final LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.getStudentById(studentId);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/editStudent.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String lesson = req.getParameter("lessonId");

        Student student = Student.builder()
                .id(Integer.parseInt(id))
                .name(name)
                .surname(surname)
                .email(email)
                .age(Integer.parseInt(age))
                .lesson(lessonService.getLessonById(Integer.parseInt(lesson)))
                .build();

        studentService.update(student);

        resp.sendRedirect("/students");
    }
}
