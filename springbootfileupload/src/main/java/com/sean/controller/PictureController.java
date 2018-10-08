package com.sean.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLConnection;

/**
 * Created by Sean on 2018/10/8
 *
 * @author Sean
 */
@Controller
@RequestMapping(value = "person")
public class PictureController {
    @Value("${upload.pictures.personPicture}")
    private Resource personPicturePath;

    @RequestMapping(value = "getPerson")
    public String getPerson() {
        return "person";
    }

    @RequestMapping(value = "personInfo")
    public void getPersonPicture(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(personPicturePath.getFilename()));
        IOUtils.copy(personPicturePath.getInputStream(), response.getOutputStream());
    }
}
