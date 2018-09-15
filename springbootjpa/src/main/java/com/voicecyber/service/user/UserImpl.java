package com.voicecyber.service.user;

import com.voicecyber.dao.UserRepository;
import com.voicecyber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sean on 2018/9/12
 *
 * @author Sean
 */
@Service
public class UserImpl implements IUser {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public User getUserByName(String name) {
        User usersByName = userRepository.getUsersByName(name);
        return usersByName;
    }
}
