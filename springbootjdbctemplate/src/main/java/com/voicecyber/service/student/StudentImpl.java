package com.voicecyber.service.student;

import com.voicecyber.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sean on 2018/9/11
 *
 * @author Sean
 */
@Service
public class StudentImpl implements IStudent {
    @Autowired
    @Qualifier("studentTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getStudentList() {
        List<Student> studentList = jdbcTemplate.query("select * from student ", new Object[]{}, new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }

    @Override
    public Student getStudentById(int id) {
        List<Student> studentList = jdbcTemplate.query("select * from student WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
        if (!studentList.isEmpty()) {
            Student student = studentList.get(0);
            return student;
        }else {
            return null;
        }
    }

    @Override
    public void add(Student student) {
        jdbcTemplate.update("INSERT  INTO  student (name,age,sex) VALUES (?,?,?)",student.getName(),student.getAge(),student.getSex());
    }

    @Override
    public void edit(Student student) {
        jdbcTemplate.update("UPDATE student SET NAME =?,age=?,sex=? WHERE id=?",student.getName(),student.getAge(),student.getSex(),student.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE  FROM  student WHERE id=?",id);
    }
}
