package util;

import modules.courses.util.CoursesUtil;
import modules.students.util.StudentsUtil;

public class Main {
    public static void main(String[] args) {

        CoursesUtil coursesUtil = new CoursesUtil();
        StudentsUtil studentsUtil = new StudentsUtil();

//        Course course = new Course();
//        course.setTitle("asdfas");
//        coursesUtil.addCourse(course);

//        coursesUtil.clearAllCourses();
//        List<Course> allCourse = coursesUtil.getAllCourses();
//        System.out.println(allCourse.size());

//        Student student = new Student();
//        student.setfName("Aleksandr");
//        student.setlName("Shevchenko");
//        student.setAdress("Karavaeva 44");
//        student.setPhone(22332233);
//        student.setEmail("aleksandr@mail.com");
//        Set<Course> courseSet = new HashSet<Course>();
//        courseSet.add(allCourse.get(0));
//        student.setCourses(courseSet);
//

//        studentsUtil.addStudent(student);

//        List<Student> students = studentsUtil.getStudents();
//        List<Course> courses = coursesUtil.getAllCourses();
//
//        for(Course c: courses) {
//            List<Student> full = new ArrayList<Student>();
//            for (Student s : students)
//                if (s.getCourses().contains(c)) {
//                    full.add(s);
//                    System.out.println(s.getfName() + " contains " + c.getTitle());
//                }
//            Set<Student> ttt = new HashSet<Student>(full);
//            c.setStudents(ttt);
//        }
//
//        System.out.println("-----------------------------------------------------");
//
//        for (Course c: courses)
//            coursesUtil.addOrUpdate(c);

        HibernateUtil.shutdown();

    }
}
