package modules.courses.util;

import modules.courses.dto.Course;
import org.junit.Assert;
import org.junit.Test;

public class CoursesUtilTest {

    CoursesUtil coursesUtil = new CoursesUtil();

    @Test
    public void testAddCourse() {

    }

    @Test
    public void testGetAllCourses() {

    }

    @Test
    public void testIsCourse() {

    }

    @Test
    public void testGetCourse() {
        Course course = coursesUtil.getCourse("Salsa");
        String act = course.getTitle();
        String exp = "Salsa";
        Assert.assertEquals(exp, act);


    }
}