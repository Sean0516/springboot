package com.voicecyber.config;

import com.voicecyber.model.Staff;
import com.voicecyber.model.Student;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Sean on 2018/8/7
 *
 * @author Sean
 */
public class StudentItemProcessor implements ItemProcessor<Student, Staff> {
    @Override
    public Staff process(Student student) throws Exception {
        System.out.println(student.toString());
        Staff staff = new Staff();
        staff.setName(student.getName());
        staff.setSex(student.getSex());
        staff.setPhone(134);
        return staff;
    }
}
