package com.example.studentlessonservlet.servlet;

import com.example.studentlessonservlet.model.Lesson;
import com.example.studentlessonservlet.service.LessonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lessons")
public class LessonServlet extends HttpServlet {

    private LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lesson> allLessons = lessonService.getAllLessons();
        req.setAttribute("lessons", allLessons);
        req.getRequestDispatcher("/lessons.jsp").forward(req, resp);

    }
}
