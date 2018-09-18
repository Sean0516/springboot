package com.voicecyber.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by Sean on 2018/9/15
 *
 * @author Sean
 */
@RestController
public class RestUserController {

    @RequestMapping(value = "getUserName")
    public ResponseEntity userName(UriComponentsBuilder uriComponentsBuilder) {
        URI getUserName = uriComponentsBuilder.path("getUserName")
                .build().toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(getUserName);
        return new ResponseEntity("sean", httpHeaders, HttpStatus.OK);

    }

}
