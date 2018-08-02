package com.voicecyber.service.student;

import com.voicecyber.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
@Service
public class StudentImpl  implements IStudent{
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void add(String key, Student student) {
        redisTemplate.opsForValue().set(key,student);
    }

    @Override
    public Student getStudent(String key) {
        Student  student = (Student) redisTemplate.opsForValue().get(key);
        return student;
    }

    @Override
    public void delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
