package modules.courses.util;

import modules.courses.dao.CoursesDao;
import modules.courses.dto.Course;
import util.Factory;

import java.util.List;

public class CoursesUtil {
    private Factory factory = Factory.getInstance();
    private CoursesDao coursesDao = factory.getCoursesDao();

//            Clock clock = Clock.system(ZoneId.of("Europe/Kiev"));
//            course.setStartDate(LocalDate.now(clock));
//            course.setEndDate(LocalDate.now(clock).plusMonths(3));

    public void addOrUpdate(Course course){
        coursesDao.save(course);
    }

    public void clearAllCourses(){
        List<Course> courses = coursesDao.allCourses();
        for (Course c : courses)
            coursesDao.delete(c);
    }

    public List<Course> getAllCourses(){
        return coursesDao.allCourses();
    }

    public boolean isCourse(String course){
        Course c = coursesDao.getCourse(course);
        if(c == null)
            return false;
        else
            return true;
    }

    public Course getCourse(String title) {
        return coursesDao.getCourse(title);
    }
}
