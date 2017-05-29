package modules.courses.servlets;

import modules.courses.dto.Course;
import modules.courses.util.CoursesUtil;
import util.ParserWebItems;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/courses.do")
public class Courses extends HttpServlet {

    CoursesUtil coursesUtil = new CoursesUtil();
    ParserWebItems parser = new ParserWebItems();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = coursesUtil.getAllCourses();
        if (courses.size() > 250)
            courses = courses.subList(0, 250);

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("WEB-INF/views/courses.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = "";
        try {
            if(coursesUtil.isCourse(req.getParameter("title")))
                status = "<h5><font color=\"red\"> Course " + req.getParameter("title") + " already exists!</font></h5>";
            else {
                Course course = new Course();
                course.setTitle(req.getParameter("title"));
                course.setSubtitle(req.getParameter("subtitle"));
                course.setDescription(req.getParameter("description"));
                int price = Integer.valueOf(req.getParameter("price"));
                course.setPrice(price);
                String[] dates = req.getParameter("dates").split("-");
                LocalDate startDate = parser.parseStringToLocalDate(dates[0].trim());
                LocalDate endDate = parser.parseStringToLocalDate(dates[1].trim());
                course.setStartDate(startDate);
                course.setEndDate(endDate);
                coursesUtil.addOrUpdate(course);

                status = "<h5><font color=\"green\"> Course " + req.getParameter("title") + " added successful!</font></h5>";
            }
        } catch (Exception e){
            status = "<h5><font color=\"red\"> Course " + req.getParameter("title") + " added error!\n + " + e + "</font></h5>\n";
        }

        resp.getWriter().write(status);
    }
}
