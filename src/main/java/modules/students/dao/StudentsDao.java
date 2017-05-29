package modules.students.dao;

import modules.students.dto.Student;

import java.util.List;

public interface StudentsDao {
    List<Student> allStudents();
    List<Student> students(String fName, String lName);
    Student getStudent(int id);
    void save(Student student);
    void delete(Student student);
}