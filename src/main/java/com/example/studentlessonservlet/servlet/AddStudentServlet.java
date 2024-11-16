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

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    private final StudentService studentService = new StudentService();
    private final LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addStudent.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        Lesson lesson = lessonService.getLessonById(Integer.parseInt(req.getParameter("lessonId")));

        Student student = Student.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .age(age)
                .lesson(lesson)
                .build();

       studentService.add(student);

        resp.sendRedirect("/students");
    }
}
