package com.sean.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sean on 2018/9/28
 *
 * @author Sean
 */
@ExcelTarget("bo")
public class Bo implements Serializable{

    @ExcelCollection(name = "")
    private List<ExtBo> extBoList;

    @Excel(name = "help",needMerge = true,orderNum = "2" ,width = 30)
    private String help;

    public List<ExtBo> getExtBoList() {
        return extBoList;
    }

    public void setExtBoList(List<ExtBo> extBoList) {
        this.extBoList = extBoList;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }
}
