package com.sean.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 * Created by Sean on 2018/9/28
 *
 * @author Sean
 */
@ExcelTarget("ext")
public class Ext implements Serializable{
    @Excel(name = "分机名" ,orderNum = "0")
    private String name;
    @Excel(name = "员工名" ,orderNum="1")
    private String staff;
    @Excel(name = "描述",orderNum="2")
    private String des;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Ext{" +
                "name='" + name + '\'' +
                ", staff='" + staff + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
