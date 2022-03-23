package cn.tedu.boot52.controller;

import cn.tedu.boot52.entity.Weibo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeiboController {

    @RequestMapping("/insert")
    public void insert(@RequestBody Weibo weibo){
        System.out.println("weibo = " + weibo);
    }

}
