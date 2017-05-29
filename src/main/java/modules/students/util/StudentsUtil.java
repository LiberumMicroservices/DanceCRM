package modules.students.util;

import modules.students.dao.StudentsDao;
import modules.students.dto.Student;
import util.Factory;

import java.util.List;

public class StudentsUtil {

    private Factory factory = Factory.getInstance();
    private StudentsDao studentsDao = factory.getStudentsDao();


    public void addStudent(Student student){
        studentsDao.save(student);
    }

    public void clearAllStudents(){
        List<Student> students = studentsDao.allStudents();
        for (Student s : students)
            studentsDao.delete(s);
    }

    public Student getStudent(int id){
        return studentsDao.getStudent(id);
    }

    public List<Student> getStudents(){
        return studentsDao.allStudents();
    }

    public List<Student> getStudents(String fName, String lName){
        return studentsDao.students(fName, lName);
    }
}
