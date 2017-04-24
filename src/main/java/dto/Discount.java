package dto;

import modules.courses.dto.Course;
import modules.students.dto.Student;

public class Discount {

    private int id;
    private Student student;
    private Course course;
    private int discount;

    public Discount() { }

    public Discount(Student student, Course course, int discount) {
        this.student = student;
        this.course = course;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discount)) return false;

        Discount discount1 = (Discount) o;

        if (discount != discount1.discount) return false;
        if (student != null ? !student.equals(discount1.student) : discount1.student != null) return false;
        return course != null ? course.equals(discount1.course) : discount1.course == null;

    }

    @Override
    public int hashCode() {
        int result = student != null ? student.hashCode() : 0;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + discount;
        return result;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", student=" + student.getfName() + " " + student.getlName() +
                ", course=" + course.getTitle() +
                ", discount=" + discount +
                '}';
    }
}
