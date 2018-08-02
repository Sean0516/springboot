package com.voicecyber.service.student;

import com.voicecyber.model.Student;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
public interface IStudent {
    void add(String key,Student student);
    Student getStudent(String key);
    void delete(String key);

}
