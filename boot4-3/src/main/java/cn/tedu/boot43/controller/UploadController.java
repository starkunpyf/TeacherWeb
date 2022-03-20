package cn.tedu.boot43.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public void upload(String intro, MultipartFile picFile){
        System.out.println("intro = " + intro + ", picFile = " + picFile);


    }
}
