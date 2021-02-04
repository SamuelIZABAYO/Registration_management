/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author The Crush
 */
@Entity
public class Registration {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "course_code")
    private Course reg_course;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "student_id")
    private Student reg_student;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getReg_course() {
        return reg_course;
    }

    public void setReg_course(Course reg_course) {
        this.reg_course = reg_course;
    }

    public Student getReg_student() {
        return reg_student;
    }

    public void setReg_student(Student reg_student) {
        this.reg_student = reg_student;
    }

}
