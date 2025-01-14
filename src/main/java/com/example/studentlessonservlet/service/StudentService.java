package com.example.studentlessonservlet.service;

import com.example.studentlessonservlet.db.DBConnectionProvider;
import com.example.studentlessonservlet.model.Lesson;
import com.example.studentlessonservlet.model.Student;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final LessonService lessonService = new LessonService();

    public void add(Student student) {
        String sql = "INSERT INTO student(name,surname,email,age,lesson_id) VALUES(?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setInt(5, student.getLesson().getId());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                student.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM student";
        List<Student> students = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                students.add(Student.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .email(resultSet.getString("email"))
                        .age(resultSet.getInt("age"))
                        .lesson(lessonService.getLessonById(resultSet.getInt("lesson_id")))
                        .build());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentById(int id) {
        String sql = "SELECT * FROM student WHERE id = " + id;


        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Student student = Student.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .email(resultSet.getString("email"))
                        .age(resultSet.getInt("age"))
                        .lesson(lessonService.getLessonById(resultSet.getInt("lesson_id")))
                        .build();
                return student;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public void update(Student student) {
        String sql = """
                UPDATE student SET name = '%s', surname = '%s', email = '%s',
                age = '%s', lesson = '%s' WHERE id = %d
                """.formatted(student.getName(), student.getSurname(),
                student.getEmail(), student.getAge(), student.getLesson().getId(), student.getId());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM student WHERE id = " + studentId;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
