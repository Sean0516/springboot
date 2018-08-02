package com.voicecyber.mapper.school;


import com.voicecyber.mapper.factory.StaffMapper;
import com.voicecyber.model.factory.Staff;
import com.voicecyber.model.school.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Sean on 2018/8/2
 *
 * @author Sean
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StaffMapper staffMapper;
    @Test
    public void testAdd(){
        Student student=new Student();
        student.setName("sean");
        student.setAge(12);
        student.setSex("男");
        studentMapper.insertSelective(student);
    }
    @Test
    public void testAddStaff(){
        Staff staff=new Staff();
        staff.setName("赵");
        staff.setSex("女");
        staff.setPhone(234111);
        staffMapper.insertSelective(staff);
    }
}