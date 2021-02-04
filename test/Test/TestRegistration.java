/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author The Crush
 */
import DAO.GenericDao;
import Model.Faculty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import DAO.HibernateUtil;
import Model.Course;
import Model.Department;
import static Model.Gender.MALE;
import Model.Registration;
import Model.Student;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegistration extends AbstractTestCase {

    GenericDao<Faculty> fac = new GenericDao<>(Faculty.class);
    GenericDao<Department> dep = new GenericDao<>(Department.class);
    GenericDao<Course> cou = new GenericDao<>(Course.class);
    GenericDao<Student> stu = new GenericDao<>(Student.class);
    GenericDao<Registration> reg1 = new GenericDao<>(Registration.class);

    @Test
    public void testCreateFaculty() {
        Faculty faculty = new Faculty("Marketing");
        String actual = fac.createX(faculty);
        String expected = "success";
        Assert.assertEquals(actual, expected);
        System.out.println("Faculty created");
    }

    @Test
    public void testCreateDepartment() {
        Faculty faculty = fac.findById("IT");
        Department depart = new Department("Communication");
        depart.setFaculty(faculty);
        String actual = dep.createX(depart);
        String expected = "success";
        Assert.assertEquals(actual, expected);
        System.out.println("Department created");
    }

    @Test
    public void testCreateCourse() {
        Department depar = dep.findById("Accounting");
        Course course = new Course("SENG222", "Software", 3);
        course.setDepartment(depar);
        String actual = cou.createX(course);
        String expected = "success";
        Assert.assertEquals(actual, expected);
        System.out.println("Course created");
    }

    @Test
    public void testCreateStudent() {
        Department depar = dep.findById("Information Management");

        Student student = new Student("400", "Alex", MALE, Date.valueOf(LocalDate.of(2019, 01, 10)), "078800", "Alex@gmail.com");
        student.setDepartment(depar);
        String actual = stu.createX(student);
        String expected = "success";
        Assert.assertEquals(actual, expected);
        System.out.println("Student created");
    }

    @Test
    public void testFindFaculty() {
        List<Faculty> list = fac.findAll();
        Assert.assertEquals(list.size(), 3);
        System.out.println("select faculty");
    }

    @Test
    public void testFindDepartment() {
        List<Department> list = dep.findAll();
        Assert.assertEquals(list.size(), 4);
        System.out.println("select department");
    }

    @Test
    public void testFindCourse() {
        List<Course> list = cou.findAll();
        Assert.assertEquals(list.size(), 2);
        System.out.println("select course");
    }

    @Test
    public void testFindStudent() {
        List<Student> list = stu.findAll();
        Assert.assertEquals(list.size(), 1);
        System.out.println("select student");
    }

    @Test
    public void updateCourse() {
        Department depar = dep.findById("Accounting");
        Course course = new Course("200", "Web Tech", 3);
        course.setDepartment(depar);
        String actual = cou.updateX(course);
        String expected = "success";
        Assert.assertEquals(actual, expected);
        System.out.println("Course Updated");
    }

    @Test
    public void updateStudent() {
        Department depar = dep.findById("Information Management");
        Student student = new Student("100", "Niyodusenga", MALE, new Date(1999, 3, 15), "078298776", "mugisha@gmail.com");
        student.setDepartment(depar);
        String actual = stu.updateX(student);
        String expected = "success";
        Assert.assertEquals(actual, expected);
        System.out.println("Student Updated");
    }

    @Test
    public void deleteCourse() {
        Course cour = cou.findById("100");
        String actual = cou.deleteX(cour);
        String expected = "success";
        Assert.assertEquals(actual, expected);
        System.out.println("Course deleted");
    }

    @Test
    public void deleteStudent() {
        Student stud = stu.findById("100");
        String actual = stu.deleteX(stud);
        String expected = "success";
        Assert.assertEquals(actual, expected);
        System.out.println("Student deleted");
    }

    @Test
    public void createNewRegistration() {
        Registration reg = new Registration();
        Student stdent = stu.findById("400");
        Course cr = cou.findById("SENG222");
        reg.setReg_student(stdent);
        reg.setReg_course(cr);
        reg1.createX(reg);
    }

    @BeforeMethod
    public void initializeTest() {
        System.out.println("Initializing test");
        execute(GeneralOperation.INSERT_FACULTY);
        execute(GeneralOperation.INSERT_DEPARTMENT);
        execute(GeneralOperation.INSERT_COURSE);
        execute(GeneralOperation.INSERT_STUDENT);

    }

    @AfterMethod
    public void cleanTest() {
        System.out.println("Cleaning test");
        execute(GeneralOperation.DELETE_REGISTRATION);
        execute(GeneralOperation.DELETE_STUDENT);
        execute(GeneralOperation.DELETE_COURSE);
        execute(GeneralOperation.DELETE_DEPARTMENT);
        execute(GeneralOperation.DELETE_FACULTY);
    }

    @BeforeTest
    public void init() {
        System.out.println("Create Tables");
        HibernateUtil.getSessionFactory();
    }
}
