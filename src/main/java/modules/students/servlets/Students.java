package modules.students.servlets;

import modules.students.dto.Student;
import modules.students.util.StudentsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students.do")
public class Students extends HttpServlet{
    StudentsUtil studentsUtil = new StudentsUtil();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentsUtil.getStudents();

        request.setAttribute("students", students);
        request.getRequestDispatcher("WEB-INF/views/students.jsp").forward(request, response);
    }
}
