package com.voicecyber.controller;

import com.voicecyber.model.Student;
import com.voicecyber.service.student.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sean on 2018/9/11
 *
 * @author Sean
 */
@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    private IStudent studentService;

    @RequestMapping(value = "getStudentList")
    public List<Student> studentList() {
        List<Student> studentList = studentService.getStudentList();
        return studentList;
    }

    @RequestMapping(value = "getStudent")
    public Student getStudent(int id) {
        Student studentById = studentService.getStudentById(id);
        return studentById;
    }
    @RequestMapping(value = "add")
    public String add(){
        Student student = new Student(null, "hello world", 24, "未知");
        studentService.add(student);
        return student.toString();
    }
    @RequestMapping("edit")
    public String edit(int id){
        Student student=new Student(id,"test",243,"男");
        studentService.edit(student);
        return student.toString();
    }

}
