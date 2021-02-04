/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author The Crush
 */
@Entity
public class Department {

    @Id
    private String departmentName;
    @ManyToOne
    @JoinColumn(name = "facultyname")
    private Faculty faculty;
    @OneToMany(mappedBy = "department")
    private List<Course> course;
    @OneToMany(mappedBy = "department")
    private List<Student> student;

    public Department() {
    }

    public Department(String departmentName, Faculty faculty) {
        this.departmentName = departmentName;
        this.faculty = faculty;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

}
