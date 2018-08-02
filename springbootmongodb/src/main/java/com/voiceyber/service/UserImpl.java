package com.voiceyber.service;

import com.voiceyber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
@Service
public class UserImpl implements IUser {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> getAllUser() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUserByName(String name) {
        return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)),User.class);
    }

    @Override
    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public void update(User user) {
        mongoTemplate.updateMulti(new Query(Criteria.where("id").is(user.getId())),Update.update("name",user.getName()),User.class);
    }

    @Override
    public void removeByName(String userName) {
        mongoTemplate.remove(new Query(Criteria.where("name").is(userName)),User.class);
    }
}
