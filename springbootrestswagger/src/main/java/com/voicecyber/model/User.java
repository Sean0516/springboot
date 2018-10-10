package com.voicecyber.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Sean on 2018/10/10
 *
 * @author Sean
 */
@XmlRootElement(name = "user")
public class User {
    private String name;
    private int age;

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
}
