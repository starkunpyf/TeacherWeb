package cn.tedu.boot400.controller;

import cn.tedu.boot400.entity.User;
import cn.tedu.boot400.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/reg")
    public String reg(User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return "用户名已存在!";
        }
        mapper.insert(user);
        return "注册成功!";
    }
    @RequestMapping("/login")
    public String login(User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                return "登录成功!";
            }
            return "密码错误!";
        }
        return "用户名不存在!";
    }
}
