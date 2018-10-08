package com.sean.config.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 * Created by Sean on 2018/9/28
 *
 * @author Sean
 */
@ExcelTarget("extBo")
public class ExtBo extends Ext implements Serializable {

    @ExcelEntity(id = "extParam")
    private ExtParam extParam;
    private Ext ext=new Ext();

    public void setExt(Ext ext) {
        this.ext = ext;
    }

    public ExtParam getExtParam() {
        return extParam;
    }

    public void setExtParam(ExtParam extParam) {
        this.extParam = extParam;
    }
    public Ext getExt(){
        ext.setName(getName());
        ext.setStaff(getStaff());
        ext.setDes(getDes());
        return ext;
    }
}
