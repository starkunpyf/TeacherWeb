package cn.tedu.boot70weibo.controller;


import cn.tedu.boot70weibo.entity.Comment;
import cn.tedu.boot70weibo.entity.User;
import cn.tedu.boot70weibo.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentController {
    @Autowired(required = false)
    CommentMapper mapper;
    @RequestMapping("/comment/insert")
    public int insert(@RequestBody Comment comment, HttpSession session){
        System.out.println("comment = " + comment );
        User u = (User) session.getAttribute("user");
        if (u==null){//代表未登录
            return 2;
        }
        //把当前登录的用户信息添加到评论对象里面
        comment.setNick(u.getNick());
        mapper.insert(comment);
        return 1;//代表评论成功!
    }

    @RequestMapping("/comment/select")
    public List<Comment> select(int id){
        return mapper.selectByWeiboId(id);
    }
}
