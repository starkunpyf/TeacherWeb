package cn.tedu.boot51.controller;

import cn.tedu.boot51.entity.Weibo;
import cn.tedu.boot51.mapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeiboController {
    @Autowired(required = false)
    WeiboMapper mapper;
    @RequestMapping("/insert")
    public void insert(@RequestBody Weibo weibo){
        //由于客户端提交的参数不是FormData对象了 是一个自定义的对象
        // 需要通过@RequestBody注解修饰接收数据的参数
        System.out.println("weibo = " + weibo);
        mapper.insert(weibo);
    }

    @RequestMapping("/select")
    public List<Weibo> select(){
        return mapper.select();
    }
}
