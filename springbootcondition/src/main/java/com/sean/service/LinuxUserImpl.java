package com.sean.service;

/**
 * Created by Sean on 2018/7/20
 *
 * @author Sean
 */
public class LinuxUserImpl implements IUser {
    @Override
    public void getName() {
        System.out.println("系统版本为 linux" );
    }
}
