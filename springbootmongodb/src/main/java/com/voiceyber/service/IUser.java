package com.voiceyber.service;

import com.voiceyber.model.User;

import java.util.List;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
public interface IUser {
    List<User> getAllUser();
    User getUserByName(String name);
    void insert(User user);
    void update(User user);
    void removeByName(String userName);

}
