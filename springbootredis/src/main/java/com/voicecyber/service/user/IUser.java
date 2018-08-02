package com.voicecyber.service.user;

import com.voicecyber.model.User;

import java.util.List;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
public interface IUser {
    void add(String key,User user);

    void add(String key,List<User> userList);

    List<User> getUserList(String key);

    User getUser(String key);

    void delete(String key);

}
