package modules.students.dto;

import modules.courses.dto.Course;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Students")
public class Student {

    //TODO add activate-deactivate

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "f_name", nullable = true, insertable = true, updatable = true, length = 60)
    private String fName;

    @Basic
    @Column(name = "l_name", nullable = true, insertable = true, updatable = true, length = 60)
    private String lName;

    @Column
    private LocalDate birthday;

    @Basic
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 60)
    private String address;

    @Column
    private int phone;

    @Column
    private int phone2;

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 60)
    private String email;

    @Basic
    @Column(name = "skype", nullable = true, insertable = true, updatable = true, length = 60)
    private String skype;

    @Basic
    @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 60)
    private String comment;

//    @ManyToMany (fetch = FetchType.LAZY)
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Course> courses;

    public Student() { }

    public Student(String fName, String lName, LocalDate birthday, String address, int phone, int phone2, String email, String skype, String comment, Set<Course> courses) {
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.phone2 = phone2;
        this.email = email;
        this.skype = skype;
        this.comment = comment;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone2() {
        return phone2;
    }

    public void setPhone2(int phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (phone != student.phone) return false;
        if (phone2 != student.phone2) return false;
        if (fName != null ? !fName.equals(student.fName) : student.fName != null) return false;
        if (lName != null ? !lName.equals(student.lName) : student.lName != null) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (skype != null ? !skype.equals(student.skype) : student.skype != null) return false;
        if (comment != null ? !comment.equals(student.comment) : student.comment != null) return false;
        return courses != null ? courses.equals(student.courses) : student.courses == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + phone;
        result = 31 * result + phone2;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
//        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", phone2=" + phone2 +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", comment='" + comment + '\'' +
                ", course=" + courses.size() +
                '}';
    }
}
