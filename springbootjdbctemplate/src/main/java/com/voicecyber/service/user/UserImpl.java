package com.voicecyber.service.user;

import com.voicecyber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sean on 2018/9/11
 *
 * @author Sean
 */
@Service
public class UserImpl implements IUser {
    @Autowired
    @Qualifier("userTemplate")
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<User> findUserAll() {
        List<User> userList = jdbcTemplate.query("select * from USER ", new Object[]{}, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }


    @Override
    public User findUserById(int id) {
        List<User> userList = jdbcTemplate.query("select * from user where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        if (!userList.isEmpty()) {
            User user = userList.get(0);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User findUserObjectById(int id) {
        User user = jdbcTemplate.queryForObject("select * from user where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public User findUserPrepStatementById(int id) {
        List<User> userList = jdbcTemplate.query("select * from user where id = ?", preparedStatement -> preparedStatement.setInt(1,id), new BeanPropertyRowMapper<>(User.class));
        if (!userList.isEmpty()) {
            User user = userList.get(0);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void insertUser(User user) {
        jdbcTemplate.update("INSERT  into USER (NAME ,AGE ,SEX) VALUES (?,?,?)", user.getName(), user.getAge(), user.getSex());
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE USER SET  NAME =?,AGE=?,SEX=? WHERE ID=?", user.getName(), user.getAge(), user.getSex(), user.getId());
    }

    @Override
    public void deleteUserById(int id) {
//        jdbcTemplate.update("DELETE  FROM  USER  WHERE  ID=?",id);
        Map<String, Integer> map = new HashMap<>(1);
        map.put("id", id);
        namedParameterJdbcTemplate.update("delete from user where id=:id", map);
    }
}
