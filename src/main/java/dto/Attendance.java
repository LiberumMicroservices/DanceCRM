package dto;

import modules.students.dto.Student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "id")
    private Student student;

    @Column
    private boolean status;

    public Attendance() { }

    public Attendance(LocalDate date, Student student, boolean status) {
        this.date = date;
        this.student = student;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setstudent(Student student) {
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendance)) return false;

        Attendance that = (Attendance) o;

        if (status != that.status) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return student != null ? student.equals(that.student) : that.student == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", date=" + date +
                ", student=" + student.getfName() + " " + student.getlName() +
                ", status=" + status +
                '}';
    }
}
