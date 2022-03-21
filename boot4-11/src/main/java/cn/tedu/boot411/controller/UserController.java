package cn.tedu.boot411.controller;

import cn.tedu.boot411.entity.User;
import cn.tedu.boot411.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/reg")
    public int reg(User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return 2; //代表用户名已存在
        }
        mapper.insert(user);
        return 1; //代表注册成功
    }
}
