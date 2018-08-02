package com.voicecyber.model;

import java.io.Serializable;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
public class Student implements Serializable {
    private final static long serializableID=20L;
    private int num;
    private String name;
    private int age;
    private String sex;

    public Student() {
    }

    public Student(int num, String name, String sex) {
        this.num = num;
        this.name = name;
        this.sex = sex;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
