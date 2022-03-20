package cn.tedu.boot41.controller;

import cn.tedu.boot41.entity.User;
import cn.tedu.boot41.mapper.UserMapper;
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
}
