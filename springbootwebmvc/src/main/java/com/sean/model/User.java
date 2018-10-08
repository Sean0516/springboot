package com.sean.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sean on 2018/10/8
 *
 * @author Sean
 */
public class User {
    @NotNull
    @Size(min = 1,max = 22)
    private String name;
    @Min(0) @Max(200)
    private Integer age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
