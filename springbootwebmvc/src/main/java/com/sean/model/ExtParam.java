package com.sean.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 * Created by Sean on 2018/9/28
 *
 * @author Sean
 */
@ExcelTarget("extParam")
public class ExtParam implements Serializable {
    @Excel(name = "IP 地址" ,orderNum="10" ,replace = "192.168.6.80_1")
    private String ip;
    @Excel(name = "Mac 地址",orderNum="11")
    private String mac;
    @Excel(name = "自定义字段",orderNum="12")
    private String coustom;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getCoustom() {
        return coustom;
    }

    public void setCoustom(String coustom) {
        this.coustom = coustom;
    }

    @Override
    public String toString() {
        return "ExtParam{" +
                "ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", coustom='" + coustom + '\'' +
                '}';
    }
}
