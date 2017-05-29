package modules.students.servlets;

import modules.students.dto.Student;
import modules.students.util.StudentsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detaleStudent.do")
public class DetaleStudent extends HttpServlet{

    StudentsUtil studentsUtil = new StudentsUtil();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";
        try {
            int id = Integer.valueOf(request.getParameter("id"));
            Student student = studentsUtil.getStudent(id);
            if(student == null) {
                error = "Error receiving user";
                request.setAttribute("error", error);
                request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
            }
            else {
                request.setAttribute("student", student);
                request.getRequestDispatcher("WEB-INF/views/detaleStudent.jsp").forward(request, response);
            }
        }catch (Exception e){
            error = e.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
