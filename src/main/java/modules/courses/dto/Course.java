package modules.courses.dto;

import modules.students.dto.Student;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="Course")
public class Course {

    //TODO add activate-deactivate

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 60)
    private String title;

    @Basic
    @Column(name = "subtitle", nullable = true, insertable = true, updatable = true, length = 100)
    private String subtitle;

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 1260)
    private String description;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column(name = "price", nullable = true, insertable = true, updatable = true)
    private int price;

//    @ManyToMany (fetch = FetchType.LAZY)
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Student> students;

    public Course() { }

    public Course(String title, String subtitle, String description, LocalDate startDate, LocalDate endDate, int price, Set<Student> students) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (price != course.price) return false;
        if (title != null ? !title.equals(course.title) : course.title != null) return false;
        if (subtitle != null ? !subtitle.equals(course.subtitle) : course.subtitle != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (startDate != null ? !startDate.equals(course.startDate) : course.startDate != null) return false;
        if (students != null ? !students.equals(course.students) : course.students != null) return false;
        return endDate != null ? endDate.equals(course.endDate) : course.endDate == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", students=" + students.size() +
                '}';
    }
}
