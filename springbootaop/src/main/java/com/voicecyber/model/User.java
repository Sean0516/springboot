package com.voicecyber.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sean on 2018/9/10
 *
 * @author Sean
 */
public class User {
    @NotNull
    @Size(min = 2,max = 10)
    private String  name;

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
