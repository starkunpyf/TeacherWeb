package cn.tedu.boot53.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile picFile) throws IOException {
        //得到原始文件名
        String fileName = picFile.getOriginalFilename();
        //得到后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //得到唯一文件名
        fileName = UUID.randomUUID()+suffix;
        //得到保存图片的文件夹路径
        String dirPath = "D:/file";
        File dirFile = new File(dirPath);
        if (!dirFile.exists()){// 如果文件夹不存在
            dirFile.mkdirs();//创建文件夹
        }
        String filePath = dirPath+"/"+fileName;
        //把图片保存到指定的文件夹
        picFile.transferTo(new File(filePath));
        //       /abc.jpg
        return "/"+fileName;
    }

    @RequestMapping("/remove")
    public void remove(String name){
        String dirPath = "D:/file";
        String filePath = dirPath+name;
        new File(filePath).delete();//删除文件
    }
}
