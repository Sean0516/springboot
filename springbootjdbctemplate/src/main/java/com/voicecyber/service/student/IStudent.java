package com.voicecyber.service.student;

import com.voicecyber.model.Student;

import java.util.List;

/**
 * Created by Sean on 2018/9/11
 *
 * @author Sean
 */
public interface IStudent {
    List<Student> getStudentList();
    Student getStudentById(int id);
    void add(Student student);
    void edit(Student student);
    void delete(int id);
}
