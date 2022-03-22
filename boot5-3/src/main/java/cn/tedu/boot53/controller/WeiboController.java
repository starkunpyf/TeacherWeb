package cn.tedu.boot53.controller;

import cn.tedu.boot53.entity.Weibo;
import cn.tedu.boot53.mapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeiboController {
    @Autowired(required = false)
    WeiboMapper mapper;
    @RequestMapping("/insert")
    public void insert(@RequestBody Weibo weibo){
        mapper.insert(weibo);
    }
}
