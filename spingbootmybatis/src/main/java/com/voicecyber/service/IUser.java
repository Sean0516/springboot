package com.voicecyber.service;

import com.voicecyber.model.User;

import java.util.List;

/**
 * Created by Sean on 2018/7/30
 *
 * @author Sean
 */
public interface IUser {
    List<User> findUserAll();
    User findUserById(int id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUserById(int id);
}
