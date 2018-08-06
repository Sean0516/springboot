package com.voicecyber.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;


/**
 * Created by Sean on 2018/8/2
 *
 * @author Sean
 */
@Service
@Validated
public class UserImpl {
    public void test(@Size(min=2,max=4) String type){
        System.out.println(type);
    }

}
