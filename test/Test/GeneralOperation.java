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
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import java.time.LocalDate;
import java.sql.Date;

public class GeneralOperation {
//new java.time.LocalDateTime loc = new

    Date date;

    public static Operation INSERT_FACULTY
            = Operations.insertInto("faculty")
                    .columns("facultyname")
                    .values("Information technology")
                    .values("Business Administration")
                    .values("Theology")
                    .build();
    public static Operation INSERT_DEPARTMENT
            = Operations.insertInto("department")
                    .columns("departmentname", "facultyname")
                    .values("Software Engineering", "Information technology")
                    .values("Information Management", "Information technology")
                    .values("Accounting", "Business Administration")
                    .values("Finance", "Business Administration")
                    .build();
    public static Operation INSERT_COURSE
            = Operations.insertInto("course")
                    .columns("code", "name", "credits", "department_name")
                    .values("100", "Java", 4, "Software Engineering")
                    .values("200", "Accounting", 3, "Accounting")
                    .build();
    public static Operation INSERT_STUDENT
            = Operations.insertInto("student")
                    .columns("student_id", "name", "gender", "dob", "phonenumber", "email", "department_name")
                    .values("100", "AAA", "MALE", Date.valueOf(LocalDate.of(2019, 01, 10)), "000", "a@email.com", "Finance")
                    //                    .values("200", "Accounting", 3, "Accounting")
                    .build();

    public static Operation DELETE_FACULTY
            = Operations.deleteAllFrom("faculty");
    public static Operation DELETE_DEPARTMENT
            = Operations.deleteAllFrom("department");
    public static Operation DELETE_COURSE
            = Operations.deleteAllFrom("course");
    public static Operation DELETE_STUDENT
            = Operations.deleteAllFrom("student");
    public static Operation DELETE_REGISTRATION
            = Operations.deleteAllFrom("registration");
}
