package com.voicecyber.service.user;

import com.voicecyber.model.User;

import java.util.List;

/**
 * Created by Sean on 2018/9/12
 *
 * @author Sean
 */
public interface IUser {
    List<User> getUserList();
    User getUserById(int id);
    void  add(User user);
    void edit(User user);
    void delete(int id);
    User getUserByName(String name);
}
