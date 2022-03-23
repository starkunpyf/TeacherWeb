package cn.tedu.boot52.controller;

import cn.tedu.boot52.entity.User;
import cn.tedu.boot52.entity.Weibo;
import cn.tedu.boot52.mapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class WeiboController {
    @Autowired(required = false)
    WeiboMapper mapper;

    @RequestMapping("/insert")
    public int insert(@RequestBody Weibo weibo, HttpSession session){
        //得到当前登录的用户对象
        User u = (User) session.getAttribute("user");
        if (u==null){//代表未登录
            return 2;
        }
        System.out.println("weibo = " + weibo);
        //, nick 发布时间,user_id
        //把当前登录用户的昵称和id添加给weibo对象
        weibo.setNick(u.getNick());
        weibo.setUserId(u.getId());
        //设置微博发布时间为当前系统时间 new Date()得到当前系统时间
        weibo.setCreated(new Date());

        mapper.insert(weibo);
        return 1;//代表发布微博成功
    }

}
