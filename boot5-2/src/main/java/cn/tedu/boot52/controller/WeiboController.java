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
import java.util.List;

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

    @RequestMapping("/select")
    public List<Weibo> select(){
        return mapper.select();
    }
    @RequestMapping("/selectById")
    public Weibo selectById(int id){

        return mapper.selectById(id);
    }

    @RequestMapping("/selectSelf")
    public List<Weibo> selectSelf(HttpSession session){
        User u = (User) session.getAttribute("user");
        if (u==null){
            return null;
        }
        //通过当前登录用户的id查询相关的微博信息
        return mapper.selectByUserId(u.getId());
    }

    @RequestMapping("/delete")
    public void delete(int id){
        mapper.deleteById(id);
    }

}
