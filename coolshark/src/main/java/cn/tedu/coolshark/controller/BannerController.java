package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.Banner;
import cn.tedu.coolshark.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class BannerController {
    @Autowired(required = false)
    BannerMapper mapper;
    @RequestMapping("/banner/select")
    public List<Banner>select(){
        return mapper.select();
    }
    @RequestMapping("/banner/delete")
    public void delete(int id){
        //得到删除轮播图的图片名     /xxxx.jpg
        String url = mapper.selectUrlById(id);
        //得到文件的完整路径
        String filePath = "D:/file"+url;
        //删除文件
        new File(filePath).delete();

        mapper.deleteById(id);
    }

}
