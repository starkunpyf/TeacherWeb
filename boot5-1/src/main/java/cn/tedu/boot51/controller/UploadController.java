package cn.tedu.boot51.controller;

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
        //准备一个完整的文件路径
        String filePath = dirPath+"/"+fileName;
        //把上传的文件保存到上面指定的路径   异常抛出
        picFile.transferTo(new File(filePath));

        //把图片在服务器中的路径返回给客户端
        return "/"+fileName;
    }

    @RequestMapping("/remove")
    public void remove(String name){
        //文件夹路径
        String dirPath = "D:/file";
        //得到文件的完整路径
        String file = dirPath+name;
        System.out.println("删除的文件路径:"+file);
        //删除服务器中的文件
        new File(file).delete();
    }
}












