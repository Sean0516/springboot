package com.sean.config;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Sean on 2018/7/23
 *
 * @author Sean
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);
    private JSONObject jsonObject = new JSONObject();

    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(Exception e) {
        LOGGER.error(e.getMessage());
        jsonObject.put("code", -1);
        jsonObject.put("message", e.getMessage());
        ResponseEntity responseEntity = new ResponseEntity(jsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        return  responseEntity;
    }
    @ModelAttribute
    public void addModelAttribute(Model model){
        model.addAttribute("msg","hello world");
    }
}
