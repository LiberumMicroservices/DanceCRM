package modules.courses.servlets;

import modules.courses.dto.Course;
import modules.courses.util.CoursesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detaleCourse.do")
public class DetaleCourse extends HttpServlet{

    CoursesUtil coursesUtil = new CoursesUtil();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            Course course = coursesUtil.getCourse(title);
            if(course == null) {
                request.setAttribute("error", "Error groupe name.");
                request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
            }
            else {
                request.setAttribute("course", course);
                request.getRequestDispatcher("WEB-INF/views/detaleCourse.jsp").forward(request, response);
            }
        }catch (Exception e){
            String error = e.getMessage();
            request.setAttribute("error", error);
            request.getRequestDispatcher("WEB-INF/views/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
