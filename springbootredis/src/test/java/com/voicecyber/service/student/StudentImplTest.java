package com.voicecyber.service.student;

import com.voicecyber.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentImplTest {
    @Autowired
    private IStudent studentService;
    @Test
    public void add() throws Exception {
        studentService.add("student_4",new Student(222,"se1an","男"));
    }

    @Test
    public void getStudent() throws Exception {
        Student student_1 = studentService.getStudent("student_4");
        System.out.println(student_1.toString());
    }

    @Test
    public void delete() throws Exception {
        studentService.delete("student_3");
    }

}