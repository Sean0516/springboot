package com.voicecyber.config;


import com.voicecyber.model.User;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.Validator;

/**
 * Created by Sean on 2018/8/6
 *
 * @author Sean
 */
public class UserItemProcessor extends ValidatingItemProcessor<User> {
    @Override
    public User process(User user) {
        System.out.println("user" +user.toString());
        user.setSex("男");
        return user;
    }

}
