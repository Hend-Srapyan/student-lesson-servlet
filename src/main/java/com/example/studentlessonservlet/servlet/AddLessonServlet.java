package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.model.Lesson;
import com.example.studentlessonservlet.service.LessonService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addLesson")
public class AddLessonServlet extends HttpServlet {

    private final LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addLesson.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int duration = Integer.parseInt(req.getParameter("duration"));
        String lecturerName = req.getParameter("lecturerName");
        double price = Double.parseDouble(req.getParameter("price"));

        Lesson lesson = Lesson.builder()
                .name(name)
                .duration(duration)
                .lecturerName(lecturerName)
                .price(price)
                .build();

        lessonService.add(lesson);

        resp.sendRedirect("/lessons");
    }
}
