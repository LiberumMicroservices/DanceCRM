package dto;

import modules.courses.dto.Course;

import java.time.LocalDate;

public class Teacher {

    private int id;
    private String fName;
    private String lName;
    private LocalDate birthday;
    private String address;
    private int phone;
    private int phone2;
    private String email;
    private String skype;
    private String comment;
    private Course course;

    public Teacher() { }

    public Teacher(String fName, String lName, LocalDate birthday, String address, int phone, int phone2, String email, String skype, String comment, Course course) {
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.phone2 = phone2;
        this.email = email;
        this.skype = skype;
        this.comment = comment;
        this.course = course;
    }

    public int getId() {
        return id;
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

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;

        Teacher teacher = (Teacher) o;

        if (phone != teacher.phone) return false;
        if (phone2 != teacher.phone2) return false;
        if (course != teacher.course) return false;
        if (fName != null ? !fName.equals(teacher.fName) : teacher.fName != null) return false;
        if (lName != null ? !lName.equals(teacher.lName) : teacher.lName != null) return false;
        if (birthday != null ? !birthday.equals(teacher.birthday) : teacher.birthday != null) return false;
        if (address != null ? !address.equals(teacher.address) : teacher.address != null) return false;
        if (email != null ? !email.equals(teacher.email) : teacher.email != null) return false;
        if (skype != null ? !skype.equals(teacher.skype) : teacher.skype != null) return false;
        return comment != null ? comment.equals(teacher.comment) : teacher.comment == null;

    }

    @Override
    public int hashCode() {
        int result = fName != null ? fName.hashCode() : 0;
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + phone;
        result = 31 * result + phone2;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
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
                ", course=" + course.getTitle() +
                '}';
    }
}
