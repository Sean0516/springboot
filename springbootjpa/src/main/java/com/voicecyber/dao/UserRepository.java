package com.voicecyber.dao;

import com.voicecyber.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sean on 2018/9/12
 *
 * @author Sean
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User getUsersByName(String name);
}
