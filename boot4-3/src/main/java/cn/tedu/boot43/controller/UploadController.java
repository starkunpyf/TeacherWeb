package cn.tedu.boot43.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public void upload(String intro, MultipartFile picFile) throws IOException {
        System.out.println("intro = " + intro + ", picFile = " + picFile);
        //得到原始文件名  a.jpg
        String fileName = picFile.getOriginalFilename();
        //得到后缀 .jpg
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //得到唯一的文件名 UUID.randomUUID()获取唯一标识符
        fileName = UUID.randomUUID()+suffix;
        System.out.println("唯一文件名:"+fileName);
        //准备文件夹路径
        String dirPath = "d:/file";
        File dirFile = new File(dirPath);
        //判断文件夹是否存在 如果不存在 则创建
        if (!dirFile.exists()){
            dirFile.mkdirs();//创建文件
        }
        //得到完整的文件路径
        String filePath = dirPath+"/"+fileName;
        //保存文件到上面指定的路径   异常抛出
        picFile.transferTo(new File(filePath));

    }
}
