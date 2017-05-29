package modules.teachers.dto;

import modules.courses.dto.Course;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Teachers")
public class Teacher {

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

    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Course> courses;

    @Column
    private boolean active;
}
