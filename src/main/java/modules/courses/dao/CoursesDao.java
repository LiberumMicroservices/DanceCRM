package modules.courses.dao;

import modules.courses.dto.Course;

import java.util.List;

public interface CoursesDao {
    List<Course> allCourses();
    Course getCourse(int id);
    Course getCourse(String title);
    void save(Course course);
    void delete(Course course);
}
