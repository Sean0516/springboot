package com.voicecyber.service.user;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.voicecyber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
@Service
public class UserImpl implements IUser {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private Gson gson = new Gson();

    @Override
    public void add(String key, User user) {
        redisTemplate.opsForValue().set(key, gson.toJson(user), 60, TimeUnit.MINUTES);
    }

    @Override
    public void add(String key, List<User> userList) {
        redisTemplate.opsForValue().set(key, gson.toJson(userList), 60, TimeUnit.MINUTES);
    }

    @Override
    public List<User> getUserList(String key) {
        String s = redisTemplate.opsForValue().get(key);
        List<User> users = null;
        if (!StringUtils.isEmpty(s)) {
            users = gson.fromJson(s, new TypeToken<List<User>>() {
            }.getType());
        }
        return users;
    }

    @Override
    public User getUser(String key) {
        String s = redisTemplate.opsForValue().get(key);
        User user = null;
        if (!StringUtils.isEmpty(s)){
            user= gson.fromJson(s, User.class);
        }
        return user;
    }

    @Override
    public void delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
