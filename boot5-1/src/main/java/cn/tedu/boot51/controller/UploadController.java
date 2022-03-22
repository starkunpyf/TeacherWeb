package cn.tedu.boot51.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile picFile){
        //得到原始文件名
        String fileName = picFile.getOriginalFilename();
        //得到后缀  .jpg
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //得到唯一文件名 UUID.randomUUID()获取唯一标识符
        fileName = UUID.randomUUID()+suffix;
        System.out.println("文件名:"+fileName);
        //保存图片的文件夹
        String dirPath = "D:/file";
        File dirFile = new File(dirPath);
        //判断如果文件夹不存在 则创建文件夹
        if (!dirFile.exists()){
            dirFile.mkdirs();//创建文件夹
        }

        return "测试上传";
    }
}
