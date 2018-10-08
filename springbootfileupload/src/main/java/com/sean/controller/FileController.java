package com.sean.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sean on 2018/7/23
 *
 * @author Sean
 */
@Controller
@RequestMapping(value = "file")
public class FileController {

    @Value("${upload.pictures.uploadPath}")
    private String uploadPath;
    @RequestMapping(value = "toFileUpload")
    public String toFileUpload() {
        return "fileUpload";
    }

    @RequestMapping(value = "toUpLoadBatch")
    public String toUpLoadBatch() {
        return "mutifileupload";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file , HttpSession session) {
        if (!file.isEmpty()) {
            try {
                FileCopyUtils.copy(file.getBytes(), new File(uploadPath + file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
                return "文件上传失败" + e.getMessage();
            }
            return "上传成功，文件名为" + file.getOriginalFilename();
        } else {
            return "文件上传失败，文件是空的";
        }
    }
    @RequestMapping(value = "batchUpLoad" ,method = RequestMethod.POST)
    @ResponseBody
    public String batchUpLoad(HttpServletRequest request ){
        List<MultipartFile> file = ((MultipartHttpServletRequest) request).getFiles("file");
        StringBuilder stringBuilder=new StringBuilder();
        for (MultipartFile multipartFile : file) {
            if (!multipartFile.isEmpty()){
                try {
                    FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadPath + multipartFile.getOriginalFilename()));
                    stringBuilder.append(multipartFile.getOriginalFilename()+"上传成功"+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                    stringBuilder.append(multipartFile.getOriginalFilename()+"上传失败"+e.getMessage()+"\n");
                    return stringBuilder.toString();
                }
            } else {
                System.out.println("文件为空");
            }
        }
        return stringBuilder.toString();

    }

}
