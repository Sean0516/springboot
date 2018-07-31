package com.voicecyber.service;

import com.voicecyber.mapper.UserMapper;
import com.voicecyber.model.User;
import com.voicecyber.model.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sean on 2018/7/30
 *
 * @author Sean
 */
@CacheConfig(cacheNames = "userCache")
@Service
public class UserImpl implements IUser {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Cacheable()
    @Override
    public List<User> findUserAll() {
        List<User> users = userMapper.selectByExample(new UserExample());
        return users;
    }

    /**
     * 应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调 用方法获取数据，然后把数据添加到缓存中，适用于查找
     * @param id
     * @return
     */
    @Cacheable(key = "#id")
    @Override
    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用。适用于更新和插入
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertUser(User user) {
        userMapper.insertSelective(user);
    }
    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 主要针对方法配置，能够根据一定的条件对缓存进行清空。适用于删除
     * @param id
     */
    @CacheEvict(key = "#id")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteUserById(int id) {
        userMapper.deleteByPrimaryKey(id);
        try {
            if (id == 2) {
                throw new RuntimeException("回滚测试");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
}
